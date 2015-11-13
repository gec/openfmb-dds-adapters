/**
 * Copyright 2015 Green Energy Corp.
 *
 * Licensed to Green Energy Corp (www.greenenergycorp.com) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. Green Energy
 * Corp licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.greenenergycorp.openfmb.mapping;

import com.greenenergycorp.openfmb.dds.mapping.xml.OpenFMBMapping;
import com.greenenergycorp.openfmb.mapping.transform.MeasTransform;
import com.greenenergycorp.openfmb.mapping.transform.TransformXmlLoader;
import com.greenenergycorp.openfmb.mapping.xml.CommonConversions;
import org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind;
import org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind;

import java.util.ArrayList;
import java.util.List;

public class NamedControlMappingLoader {

    public static ControlHandlerMapping load(OpenFMBMapping xml, NamedControlHandler namedControlHandler) {

        final List<ControlHandlerMapping.KeyMapping> keyMappings = new ArrayList<ControlHandlerMapping.KeyMapping>();
        final List<ControlHandlerMapping.DeviceControlMapping> deviceControlMappings = new ArrayList<ControlHandlerMapping.DeviceControlMapping>();
        final List<ControlHandlerMapping.SetPointMapping> setPointMappings = new ArrayList<ControlHandlerMapping.SetPointMapping>();

        if (xml.getKeyControlMapping() != null && xml.getKeyControlMapping().getMapping() != null) {
            for (OpenFMBMapping.KeyControlMapping.Mapping mapping: xml.getKeyControlMapping().getMapping()) {

                if (mapping.getMapTo() == null) {
                    throw new IllegalArgumentException("Control mapping must have control name to map to");
                }
                final String commandName = mapping.getMapTo();

                if (mapping.getAdapterName() == null) {
                    throw new IllegalArgumentException("Control mapping must have adapter name");
                }
                final String adapterName = mapping.getAdapterName();

                if (mapping.getKey() == null) {
                    throw new IllegalArgumentException("Control mapping for " + adapterName + " must have key");
                }

                Boolean matchBoolean = null;
                if (mapping.getMatchBoolValue() != null) {
                    matchBoolean = mapping.getMatchBoolValue();
                }

                MeasTransform transform = null;
                if (mapping.getTransform() != null) {
                    transform = TransformXmlLoader.load(mapping.getTransform());
                }

                final Control.KeyControlId keyControlId = new Control.KeyControlId(adapterName, mapping.getKey());
                final MappedKeyControlHandler handler = new MappedKeyControlHandler(namedControlHandler, commandName, transform, matchBoolean);
                keyMappings.add(new ControlHandlerMapping.KeyMapping(keyControlId, handler));
            }
        }

        if (xml.getEndDeviceControlMapping() != null && xml.getEndDeviceControlMapping().getMapping() != null) {
            for (OpenFMBMapping.EndDeviceControlMapping.Mapping mapping: xml.getEndDeviceControlMapping().getMapping()) {

                if (mapping.getMapTo() == null) {
                    throw new IllegalArgumentException("Control mapping must have control name to map to");
                }
                final String commandName = mapping.getMapTo();

                if (mapping.getAdapterName() == null) {
                    throw new IllegalArgumentException("Control mapping must have adapter name");
                }
                final String adapterName = mapping.getAdapterName();

                if (mapping.getAction() == null) {
                    throw new IllegalArgumentException("Control mapping for " + adapterName + " must have action");
                }
                if (mapping.getType() == null) {
                    throw new IllegalArgumentException("Control mapping for " + adapterName + " must have type");
                }

                final Control.EndDeviceControl endDeviceControl = new Control.EndDeviceControl(adapterName, mapping.getAction(), mapping.getType());
                final MappedDeviceControlHandler handler = new MappedDeviceControlHandler(namedControlHandler, commandName, null);
                deviceControlMappings.add(new ControlHandlerMapping.DeviceControlMapping(endDeviceControl, handler));
            }
        }

        if (xml.getSetPointControlMapping() != null && xml.getSetPointControlMapping().getMapping() != null) {
            for (OpenFMBMapping.SetPointControlMapping.Mapping mapping : xml.getSetPointControlMapping().getMapping()) {
                if (mapping.getMapTo() == null) {
                    throw new IllegalArgumentException("Control mapping must have control name to map to");
                }
                final String commandName = mapping.getMapTo();

                if (mapping.getAdapterName() == null) {
                    throw new IllegalArgumentException("Control mapping must have adapter name");
                }
                final String adapterName = mapping.getAdapterName();

                if (mapping.getControlType() == null) {
                    throw new IllegalArgumentException("Control mapping for " + adapterName + " must have a control type");
                }
                if (mapping.getUnit() == null) {
                    throw new IllegalArgumentException("Control mapping for " + adapterName + " lacking unit");
                }
                final UnitSymbolKind unitSymbolKind = CommonConversions.convertFromXml(mapping.getUnit());
                if (unitSymbolKind == null) {
                    throw new IllegalArgumentException("Control mapping for " + adapterName + " couldn't convert unit");
                }
                if (mapping.getMultiplier() == null) {
                    throw new IllegalArgumentException("Control mapping for " + adapterName + " was lacking unit multipler");
                }
                final UnitMultiplierKind unitMultiplierKind = CommonConversions.convertFromXml(mapping.getMultiplier());
                if (unitMultiplierKind == null) {
                    throw new IllegalArgumentException("Control mapping for " + adapterName + " couldn't convert unit multiplier");
                }

                MeasTransform transform = null;
                if (mapping.getTransform() != null) {
                    transform = TransformXmlLoader.load(mapping.getTransform());
                }

                final Control.SetpointId setpointId = new Control.SetpointId(adapterName, mapping.getControlType(), unitSymbolKind, unitMultiplierKind);
                final MappedSetPointControlHandler handler = new MappedSetPointControlHandler(namedControlHandler, commandName, transform);
                setPointMappings.add(new ControlHandlerMapping.SetPointMapping(setpointId, handler));
            }
        }

        return new ControlHandlerMapping(
            keyMappings,
            deviceControlMappings,
            setPointMappings);

    }

    public static class MappedKeyControlHandler implements ControlHandler {

        private NamedControlHandler handler;
        private String commandName;
        private MeasTransform transform;
        private Boolean matchBoolean;

        public MappedKeyControlHandler(NamedControlHandler handler, String commandName, MeasTransform transform, Boolean matchBoolean) {
            this.handler = handler;
            this.commandName = commandName;
            this.transform = transform;
            this.matchBoolean = matchBoolean;
        }

        public void handle(Control control) {
            if (control instanceof Control.KeyControl) {
                final Control.KeyControl keyControl = (Control.KeyControl) control;

                MeasValue measValue;
                if (transform != null) {
                    measValue = transform.transform(keyControl.getValue());
                } else {
                    measValue = keyControl.getValue();
                }

                if (measValue != null) {
                    if (matchBoolean == null || measValue.asBoolean() == matchBoolean) {
                        handler.handle(commandName, measValue);
                    }
                }

            }
        }
    }


    public static class MappedDeviceControlHandler implements ControlHandler {

        private NamedControlHandler handler;
        private String commandName;
        private MeasValue constValue;

        public MappedDeviceControlHandler(NamedControlHandler handler, String commandName, MeasValue constValue) {
            this.handler = handler;
            this.commandName = commandName;
            this.constValue = constValue;
        }

        public void handle(Control control) {
            if (control instanceof Control.EndDeviceControl) {
                final Control.EndDeviceControl endDeviceControl = (Control.EndDeviceControl) control;

                handler.handle(commandName, constValue);
            }
        }
    }

    public static class MappedSetPointControlHandler implements ControlHandler {

        private NamedControlHandler handler;
        private String commandName;
        private MeasTransform transform;

        public MappedSetPointControlHandler(NamedControlHandler handler, String commandName, MeasTransform transform) {
            this.handler = handler;
            this.commandName = commandName;
            this.transform = transform;
        }

        public void handle(Control control) {
            if (control instanceof Control.SetpointControl) {
                final Control.SetpointControl setPointControl = (Control.SetpointControl) control;

                MeasValue measValue;
                if (transform != null) {
                    measValue = transform.transform(new MeasValue.MeasFloatValue(setPointControl.getValue()));
                } else {
                    measValue = new MeasValue.MeasFloatValue(setPointControl.getValue());
                }

                handler.handle(commandName, measValue);
            }
        }
    }
}
