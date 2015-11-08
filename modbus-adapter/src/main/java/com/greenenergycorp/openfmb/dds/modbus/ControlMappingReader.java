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
package com.greenenergycorp.openfmb.dds.modbus;

import com.greenenergycorp.openfmb.dds.mapping.xml.*;
import com.greenenergycorp.openfmb.mapping.Control;
import com.greenenergycorp.openfmb.mapping.ControlHandler;
import com.greenenergycorp.openfmb.mapping.ControlHandlerMapping;
import com.greenenergycorp.openfmb.mapping.MeasValue;
import com.greenenergycorp.openfmb.mapping.transform.MeasTransform;
import com.greenenergycorp.openfmb.mapping.transform.TransformXmlLoader;
import com.greenenergycorp.openfmb.mapping.xml.CommonConversions;
import org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind;
import org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.totalgrid.modbus.japi.CommandResultHandler;
import org.totalgrid.modbus.japi.ModbusCommandHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Loads control mapping configuration from XML.
 */
public class ControlMappingReader {

    private final static Logger logger = LoggerFactory.getLogger(ControlMappingReader.class);

    public static ControlHandlerMapping load(final ModbusMaster xmlConfig, final ModbusCommandHandler acceptor) {

        final List<ControlHandlerMapping.KeyMapping> keyMappings = new ArrayList<ControlHandlerMapping.KeyMapping>();
        final List<ControlHandlerMapping.DeviceControlMapping> deviceControlMappings = new ArrayList<ControlHandlerMapping.DeviceControlMapping>();
        final List<ControlHandlerMapping.SetPointMapping> setPointMappings = new ArrayList<ControlHandlerMapping.SetPointMapping>();

        if (xmlConfig.getWriteCoilFromKeyMappings() != null && xmlConfig.getWriteCoilFromKeyMappings().getMapping() != null) {
            for (WriteCoilKeyMapping mapping: xmlConfig.getWriteCoilFromKeyMappings().getMapping()) {
                final ControlHandlerMapping.KeyMapping keyMapping = convert(acceptor, mapping);
                if (keyMapping != null) {
                    keyMappings.add(keyMapping);
                }
            }
        }

        if (xmlConfig.getWriteCoilFromEndDeviceControlMappings() != null && xmlConfig.getWriteCoilFromEndDeviceControlMappings().getMapping() != null) {
            for (WriteCoilDeviceMapping mapping: xmlConfig.getWriteCoilFromEndDeviceControlMappings().getMapping()) {
                final ControlHandlerMapping.DeviceControlMapping deviceControlMapping = convert(acceptor, mapping);
                if (deviceControlMapping != null) {
                    deviceControlMappings.add(deviceControlMapping);
                }
            }
        }

        if (xmlConfig.getWriteRegisterFromKeyMappings() != null && xmlConfig.getWriteRegisterFromKeyMappings().getMapping() != null) {
            for (WriteRegisterKeyMapping mapping: xmlConfig.getWriteRegisterFromKeyMappings().getMapping()) {
                final ControlHandlerMapping.KeyMapping keyMapping = convert(acceptor, mapping);
                if (keyMapping != null) {
                    keyMappings.add(keyMapping);
                }
            }
        }

        if (xmlConfig.getWriteRegisterFromSetPointMappings() != null && xmlConfig.getWriteRegisterFromSetPointMappings().getMapping() != null) {
            for (WriteRegisterSetPointMapping mapping: xmlConfig.getWriteRegisterFromSetPointMappings().getMapping()) {
                final ControlHandlerMapping.SetPointMapping setPointMapping = convert(acceptor, mapping);
                if (setPointMapping != null) {
                    setPointMappings.add(setPointMapping);
                }
            }
        }

        return new ControlHandlerMapping(
                keyMappings,
                deviceControlMappings,
                setPointMappings);

    }

    private static ControlHandlerMapping.KeyMapping convert(ModbusCommandHandler acceptor, WriteCoilKeyMapping mapping) {
        if (mapping.getAdapterName() == null) {
            logger.warn("WriteCoilKeyMapping was lacking a device");
            return null;
        }
        if (mapping.getIndex() == null) {
            logger.warn("WriteCoilKeyMapping was lacking an index");
            return null;
        }
        if (mapping.getKey() == null) {
            logger.warn("WriteCoilKeyMapping was lacking a key");
            return null;
        }

        MeasTransform transform = null;
        if (mapping.getTransform() != null) {
            transform = TransformXmlLoader.load(mapping.getTransform());
        }

        final KeyWriteCoilHandler keyWriteCoilHandler = new KeyWriteCoilHandler(acceptor, (int)(long)mapping.getIndex(), transform);

        final Control.KeyControlId keyControlId = new Control.KeyControlId(mapping.getAdapterName(), mapping.getKey());

        return new ControlHandlerMapping.KeyMapping(keyControlId, keyWriteCoilHandler);
    }

    private static ControlHandlerMapping.DeviceControlMapping convert(ModbusCommandHandler acceptor, WriteCoilDeviceMapping mapping) {
        if (mapping.getAdapterName() == null) {
            logger.warn("WriteCoilDeviceMapping was lacking a device");
            return null;
        }
        if (mapping.getIndex() == null) {
            logger.warn("WriteCoilDeviceMapping was lacking an index");
            return null;
        }
        if (mapping.getAction() == null) {
            logger.warn("WriteCoilDeviceMapping was lacking an action");
            return null;
        }
        if (mapping.getType() == null) {
            logger.warn("WriteCoilDeviceMapping was lacking a type");
            return null;
        }
        if (mapping.getWriteBoolValue() == null) {
            logger.warn("WriteCoilDeviceMapping was lacking a boolean value to match");
            return null;
        }

        final DeviceWriteCoilHandler deviceControlHandler = new DeviceWriteCoilHandler(acceptor, mapping.getIndex().intValue(), mapping.getWriteBoolValue());

        final Control.EndDeviceControl endDeviceControl = new Control.EndDeviceControl(mapping.getAdapterName(), mapping.getAction(), mapping.getType());

        return new ControlHandlerMapping.DeviceControlMapping(endDeviceControl, deviceControlHandler);
    }

    private static ControlHandlerMapping.KeyMapping convert(ModbusCommandHandler acceptor, WriteRegisterKeyMapping mapping) {
        if (mapping.getAdapterName() == null) {
            logger.warn("WriteRegisterKeyMapping was lacking a device");
            return null;
        }
        if (mapping.getIndex() == null) {
            logger.warn("WriteRegisterKeyMapping was lacking an index");
            return null;
        }
        if (mapping.getKey() == null) {
            logger.warn("WriteRegisterKeyMapping was lacking a key");
            return null;
        }

        if ((mapping.getMatchBoolValue() == null) != (mapping.getConstIntValue() == null)) {
            logger.warn("WriteRegisterKeyMapping must include both matchBoolValue and constIntValue or neither");
            return null;
        }

        MeasTransform transform = null;
        if (mapping.getTransform() != null) {
            transform = TransformXmlLoader.load(mapping.getTransform());
        }

        final KeyWriteRegisterHandler keyRegisterHandler = new KeyWriteRegisterHandler(
                acceptor, mapping.getIndex().intValue(), mapping.getMatchBoolValue(), mapping.getConstIntValue(), transform);

        final Control.KeyControlId keyControlId = new Control.KeyControlId(mapping.getAdapterName(), mapping.getKey());

        return new ControlHandlerMapping.KeyMapping(keyControlId, keyRegisterHandler);
    }

    private static ControlHandlerMapping.SetPointMapping convert(ModbusCommandHandler acceptor, WriteRegisterSetPointMapping mapping) {
        if (mapping.getAdapterName() == null) {
            logger.warn("SetpointSetPointMapping was lacking a device");
            return null;
        }
        if (mapping.getIndex() == null) {
            logger.warn("SetpointSetPointMapping was lacking an index");
            return null;
        }
        if (mapping.getControlType() == null) {
            logger.warn("SetpointSetPointMapping was lacking a control type");
            return null;
        }
        if (mapping.getUnit() == null) {
            logger.warn("SetpointSetPointMapping was lacking unit");
            return null;
        }
        final UnitSymbolKind unitSymbolKind = CommonConversions.convertFromXml(mapping.getUnit());
        if (unitSymbolKind == null) {
            logger.warn("SetpointSetPointMapping couldn't convert unit");
            return null;
        }
        if (mapping.getMultiplier() == null) {
            logger.warn("SetpointSetPointMapping was lacking unit multipler");
            return null;
        }
        final UnitMultiplierKind unitMultiplierKind = CommonConversions.convertFromXml(mapping.getMultiplier());
        if (unitMultiplierKind == null) {
            logger.warn("SetpointSetPointMapping couldn't convert unit multiplier");
            return null;
        }

        MeasTransform transform = null;
        if (mapping.getTransform() != null) {
            transform = TransformXmlLoader.load(mapping.getTransform());
        }

        final SetPointWriteRegisterHandler setPointHandler = new SetPointWriteRegisterHandler(acceptor, mapping.getIndex().intValue(), transform);

        final Control.SetpointId setpointId = new Control.SetpointId(mapping.getAdapterName(), mapping.getControlType(), unitSymbolKind, unitMultiplierKind);

        return new ControlHandlerMapping.SetPointMapping(setpointId, setPointHandler);
    }


    public static class KeyWriteCoilHandler implements ControlHandler {
        private final static Logger logger = LoggerFactory.getLogger(KeyWriteCoilHandler.class);

        private final ModbusCommandHandler acceptor;
        private final int index;
        private final MeasTransform transform;

        private final CommandResultHandler responseAcceptor = new CommandResultHandler() {
            public void completed(boolean successful) {
                logger.debug("Command response: " + successful);
            }
        };

        public KeyWriteCoilHandler(ModbusCommandHandler acceptor, int index, MeasTransform transform) {
            this.acceptor = acceptor;
            this.index = index;
            this.transform = transform;
        }

        public void handle(Control control) {
            logger.debug("Handled control: " + control);

            if (control instanceof Control.KeyControl) {

                final Control.KeyControl keyControl = (Control.KeyControl) control;

                final MeasValue measValue;
                if (transform != null) {
                    measValue = this.transform.transform(keyControl.getValue());
                } else {
                    measValue = keyControl.getValue();
                }

                if (measValue != null) {
                    final Boolean value = measValue.asBoolean();
                    if (value != null) {
                        acceptor.writeSingleCoil(index, value, responseAcceptor);
                    }
                }

            }
        }
    }

    public static class DeviceWriteCoilHandler implements ControlHandler {
        private final static Logger logger = LoggerFactory.getLogger(DeviceWriteCoilHandler.class);

        private final CommandResultHandler responseAcceptor = new CommandResultHandler() {
            public void completed(boolean successful) {
                logger.debug("Command response: " + successful);
            }
        };

        private final ModbusCommandHandler acceptor;
        private final int index;
        private final boolean value;

        public DeviceWriteCoilHandler(ModbusCommandHandler acceptor, int index, boolean value) {
            this.acceptor = acceptor;
            this.index = index;
            this.value = value;
        }

        public void handle(Control control) {
            logger.debug("Handled control: " + control);

            if (control instanceof Control.EndDeviceControl) {

                acceptor.writeSingleCoil(index, value, responseAcceptor);

            }
        }
    }

    public static class KeyWriteRegisterHandler implements ControlHandler {
        private final static Logger logger = LoggerFactory.getLogger(KeyWriteRegisterHandler.class);

        private final CommandResultHandler responseAcceptor = new CommandResultHandler() {
            public void completed(boolean successful) {
                logger.debug("Command response: " + successful);
            }
        };

        private final ModbusCommandHandler acceptor;
        private final int index;
        private final Boolean matchBoolValue;
        private final Long constIntValue;
        private final MeasTransform transform;

        public KeyWriteRegisterHandler(ModbusCommandHandler acceptor, int index, Boolean matchBoolValue, Long constIntValue, MeasTransform transform) {
            this.acceptor = acceptor;
            this.index = index;
            this.matchBoolValue = matchBoolValue;
            this.constIntValue = constIntValue;
            this.transform = transform;
        }

        public void handle(Control control) {
            logger.debug("Handled control: " + control);

            if (control instanceof Control.KeyControl) {

                final Control.KeyControl keyControl = (Control.KeyControl) control;

                if (matchBoolValue != null && constIntValue != null) {

                    if (keyControl.getValue().asBoolean() == matchBoolValue) {
                        acceptor.writeSingleRegister(index, (int)(long)constIntValue, responseAcceptor);
                    }

                } else {

                    final MeasValue measValue;
                    if (transform != null) {
                        measValue = this.transform.transform(keyControl.getValue());
                    } else {
                        measValue = keyControl.getValue();
                    }

                    if (measValue != null) {
                        final Long value = measValue.asLong();

                        if (value != null) {
                            acceptor.writeSingleRegister(index, (int)(long)value, responseAcceptor);
                        }
                    }
                }

            }
        }
    }

    public static class SetPointWriteRegisterHandler implements ControlHandler {
        private final static Logger logger = LoggerFactory.getLogger(SetPointWriteRegisterHandler.class);

        private final CommandResultHandler responseAcceptor = new CommandResultHandler() {
            public void completed(boolean successful) {
                logger.debug("Command response: " + successful);
            }
        };

        private final ModbusCommandHandler acceptor;
        private final int index;
        private final MeasTransform transform;

        public SetPointWriteRegisterHandler(ModbusCommandHandler acceptor, int index, MeasTransform transform) {
            this.acceptor = acceptor;
            this.index = index;
            this.transform = transform;
        }

        public void handle(Control control) {
            logger.debug("Handled control: " + control);

            if (control instanceof Control.SetpointControl) {

                final Control.SetpointControl setpointControl = (Control.SetpointControl) control;

                final MeasValue initialValue = new MeasValue.MeasFloatValue(setpointControl.getValue());
                final MeasValue measValue;
                if (transform != null) {
                    measValue = this.transform.transform(initialValue);
                } else {
                    measValue = initialValue;
                }

                final Long value = measValue.asLong();
                if (value != null) {
                    final int integerVal = (int)(long)value;

                    acceptor.writeSingleRegister(index, integerVal, responseAcceptor);
                }
            }
        }
    }
}
