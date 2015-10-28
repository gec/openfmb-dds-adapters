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
package com.greenenergycorp.openfmb.dds.dnp3;

import com.greenenergycorp.openfmb.mapping.MeasValue;
import com.greenenergycorp.openfmb.mapping.transform.MeasTransform;
import com.greenenergycorp.openfmb.mapping.transform.TransformXmlLoader;
import com.greenenergycorp.openfmb.mapping.xml.CommonConversions;
import org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind;
import org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind;
import com.greenenergycorp.openfmb.dds.mapping.xml.*;
import com.greenenergycorp.openfmb.mapping.Control;
import com.greenenergycorp.openfmb.mapping.ControlHandler;
import com.greenenergycorp.openfmb.mapping.ControlHandlerMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.totalgrid.dnp3.*;
import org.totalgrid.dnp3.Setpoint;

import java.util.ArrayList;
import java.util.List;

public class ControlMappingReader {

    private final static Logger logger = LoggerFactory.getLogger(ControlMappingReader.class);

    public static ControlHandlerMapping load(final DNP3Master xmlConfig, final ICommandAcceptor acceptor) {

        final List<ControlHandlerMapping.KeyMapping> keyMappings = new ArrayList<ControlHandlerMapping.KeyMapping>();
        final List<ControlHandlerMapping.DeviceControlMapping> deviceControlMappings = new ArrayList<ControlHandlerMapping.DeviceControlMapping>();
        final List<ControlHandlerMapping.SetPointMapping> setPointMappings = new ArrayList<ControlHandlerMapping.SetPointMapping>();

        if (xmlConfig.getIndexMapping() != null) {

            final IndexMapping.ControlFromKeyMappings controlFromKeyMappings = xmlConfig.getIndexMapping().getControlFromKeyMappings();
            if (controlFromKeyMappings != null) {
                for (ControlKeyMapping mapping: controlFromKeyMappings.getMapping()) {
                    final ControlHandlerMapping.KeyMapping keyMapping = convertControlKeyMapping(acceptor, mapping);
                    if (keyMapping != null) {
                        keyMappings.add(keyMapping);
                    }
                }
            }

            final IndexMapping.ControlFromEndDeviceControlMappings controlFromEndDeviceControlMappings = xmlConfig.getIndexMapping().getControlFromEndDeviceControlMappings();
            if (controlFromEndDeviceControlMappings != null) {
                for (ControlDeviceMapping mapping: controlFromEndDeviceControlMappings.getMapping()) {
                    final ControlHandlerMapping.DeviceControlMapping deviceControlMapping = convert(acceptor, mapping);
                    if (deviceControlMapping != null) {
                        deviceControlMappings.add(deviceControlMapping);
                    }
                }
            }

            final IndexMapping.SetpointFromKeyMappings setpointFromKeyMappings = xmlConfig.getIndexMapping().getSetpointFromKeyMappings();
            if (setpointFromKeyMappings != null) {
                for (SetpointKeyMapping mapping: setpointFromKeyMappings.getMapping()) {
                    final ControlHandlerMapping.KeyMapping keyMapping = convert(acceptor, mapping);
                    if (keyMapping != null) {
                        keyMappings.add(keyMapping);
                    }
                }
            }

            final IndexMapping.SetpointFromSetPointMappings setpointFromSetPointMappings = xmlConfig.getIndexMapping().getSetpointFromSetPointMappings();
            if (setpointFromSetPointMappings != null) {
                for (SetpointSetPointMapping mapping: setpointFromSetPointMappings.getMapping()) {
                    final ControlHandlerMapping.SetPointMapping setPointMapping = convert(acceptor, mapping);
                    if (setPointMapping != null) {
                        setPointMappings.add(setPointMapping);
                    }
                }
            }
        }

        return new ControlHandlerMapping(
                keyMappings,
                deviceControlMappings,
                setPointMappings);

    }

    private static ControlHandlerMapping.KeyMapping convertControlKeyMapping(ICommandAcceptor acceptor, ControlKeyMapping mapping) {
        if (mapping.getAdapterName() == null) {
            logger.warn("ControlFromKeyMappings was lacking a device");
            return null;
        }
        if (mapping.getIndex() == null) {
            logger.warn("ControlFromKeyMappings was lacking an index");
            return null;
        }
        if (mapping.getKey() == null) {
            logger.warn("ControlFromKeyMappings was lacking a key");
            return null;
        }
        if (mapping.getMatchBoolValue() == null) {
            logger.warn("ControlFromKeyMappings was lacking a boolean value to match");
            return null;
        }
        if (mapping.getControlOptions() == null) {
            logger.warn("ControlFromKeyMappings was lacking control options");
            return null;
        }
        if (mapping.getControlOptions().getType() == null) {
            logger.warn("ControlFromKeyMappings was lacking a control type");
            return null;
        }

        final ControlCode controlCode = convertControlCode(mapping.getControlOptions().getType());
        if (controlCode == null) {
            logger.warn("ControlFromKeyMappings had an unknown control type");
            return null;
        }

        MeasTransform transform = null;
        if (mapping.getTransform() != null) {
            transform = TransformXmlLoader.load(mapping.getTransform());
        }

        final KeyControlHandler keyControlHandler = new KeyControlHandler(acceptor,
                mapping.getMatchBoolValue().booleanValue(),
                mapping.getIndex().intValue(),
                controlCode,
                mapping.getControlOptions().getCount().shortValue(),
                mapping.getControlOptions().getOffTime().shortValue(),
                mapping.getControlOptions().getOnTime().shortValue(),
                transform);

        final Control.KeyControlId keyControlId = new Control.KeyControlId(mapping.getAdapterName(), mapping.getKey());

        return new ControlHandlerMapping.KeyMapping(keyControlId, keyControlHandler);
    }

    private static ControlHandlerMapping.DeviceControlMapping convert(ICommandAcceptor acceptor, ControlDeviceMapping mapping) {
        if (mapping.getAdapterName() == null) {
            logger.warn("ControlDeviceMapping was lacking a device");
            return null;
        }
        if (mapping.getIndex() == null) {
            logger.warn("ControlDeviceMapping was lacking an index");
            return null;
        }
        if (mapping.getAction() == null) {
            logger.warn("ControlDeviceMapping was lacking an action");
            return null;
        }
        if (mapping.getType() == null) {
            logger.warn("ControlDeviceMapping was lacking a type");
            return null;
        }
        if (mapping.getControlOptions() == null) {
            logger.warn("ControlDeviceMapping was lacking control options");
            return null;
        }
        if (mapping.getControlOptions().getType() == null) {
            logger.warn("ControlDeviceMapping was lacking a control type");
            return null;
        }

        final ControlCode controlCode = convertControlCode(mapping.getControlOptions().getType());
        if (controlCode == null) {
            logger.warn("ControlDeviceMapping had an unknown control type");
            return null;
        }

        final DeviceControlHandler deviceControlHandler = new DeviceControlHandler(acceptor,
                mapping.getIndex().intValue(),
                controlCode,
                mapping.getControlOptions().getCount() != null ? mapping.getControlOptions().getCount().shortValue() : null,
                mapping.getControlOptions().getOffTime() != null ? mapping.getControlOptions().getOffTime().shortValue() : null,
                mapping.getControlOptions().getOnTime() != null ? mapping.getControlOptions().getOnTime().shortValue() : null);

        final Control.EndDeviceControl endDeviceControl = new Control.EndDeviceControl(mapping.getAdapterName(), mapping.getAction(), mapping.getType());

        return new ControlHandlerMapping.DeviceControlMapping(endDeviceControl, deviceControlHandler);
    }

    private static ControlHandlerMapping.KeyMapping convert(ICommandAcceptor acceptor, SetpointKeyMapping mapping) {
        if (mapping.getAdapterName() == null) {
            logger.warn("SetpointKeyMapping was lacking a device");
            return null;
        }
        if (mapping.getIndex() == null) {
            logger.warn("SetpointKeyMapping was lacking an index");
            return null;
        }
        if (mapping.getKey() == null) {
            logger.warn("SetpointKeyMapping was lacking a key");
            return null;
        }

        MeasTransform transform = null;
        if (mapping.getTransform() != null) {
            transform = TransformXmlLoader.load(mapping.getTransform());
        }

        final KeySetpointHandler keySetpointHandler = new KeySetpointHandler(acceptor, mapping.getIndex().intValue(), transform);

        final Control.KeyControlId keyControlId = new Control.KeyControlId(mapping.getAdapterName(), mapping.getKey());

        return new ControlHandlerMapping.KeyMapping(keyControlId, keySetpointHandler);
    }

    private static ControlHandlerMapping.SetPointMapping convert(ICommandAcceptor acceptor, SetpointSetPointMapping mapping) {
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

        final SetPointHandler setPointHandler = new SetPointHandler(acceptor, mapping.getIndex().intValue(), transform);

        final Control.SetpointId setpointId = new Control.SetpointId(mapping.getAdapterName(), mapping.getControlType(), unitSymbolKind, unitMultiplierKind);

        return new ControlHandlerMapping.SetPointMapping(setpointId, setPointHandler);
    }

    private static ControlCode convertControlCode(ControlType type) {

        if (type == ControlType.LATCH_ON) {
            return ControlCode.CC_LATCH_ON;
        } else if (type == ControlType.LATCH_OFF) {
            return ControlCode.CC_LATCH_OFF;
        } else if (type == ControlType.PULSE) {
            return ControlCode.CC_PULSE;
        } else if (type == ControlType.PULSE_CLOSE) {
            return ControlCode.CC_PULSE_CLOSE;
        } else if (type == ControlType.PULSE_TRIP) {
            return ControlCode.CC_PULSE_TRIP;
        } else {
            return null;
        }
    }

    private static BinaryOutput buildBinaryOutput(
            final ControlCode controlCode,
            final Short count,
            final Short offline,
            final Short online) {

        final BinaryOutput binaryOutput = new BinaryOutput(controlCode);
        if (count != null) {
            binaryOutput.setMCount(count);
        }
        if (offline != null) {
            binaryOutput.setMOffTimeMS(offline);
        }
        if (online != null) {
            binaryOutput.setMOnTimeMS(online);
        }
        return binaryOutput;
    }

    public static class KeyControlHandler implements ControlHandler {
        private final static Logger logger = LoggerFactory.getLogger(KeyControlHandler.class);

        private final ICommandAcceptor acceptor;

        private final IResponseAcceptor responseAcceptor = new IResponseAcceptor() {
            @Override
            public void AcceptResponse(CommandResponse arResponse, int aSequence) {
                logger.debug("Command response: " + arResponse.getMResult());
            }
        };

        private final boolean valueMatch;

        private final int index;
        private final ControlCode controlCode;
        private final Short count;
        private final Short offTime;
        private final Short onTime;

        private final MeasTransform transform;

        public KeyControlHandler(ICommandAcceptor acceptor, boolean valueMatch, int index, ControlCode controlCode, Short count, Short offTime, Short onTime, MeasTransform transform) {
            this.acceptor = acceptor;
            this.valueMatch = valueMatch;
            this.index = index;
            this.controlCode = controlCode;
            this.count = count;
            this.offTime = offTime;
            this.onTime = onTime;
            this.transform = transform;
        }

        public void handle(Control control) {
            logger.debug("Handled control: " + control);

            if (control instanceof Control.KeyControl) {

                final Control.KeyControl keyControl = (Control.KeyControl) control;

                MeasValue measValue;
                if (transform != null) {
                    measValue = transform.transform(keyControl.getValue());
                } else {
                    measValue = keyControl.getValue();
                }

                if (measValue != null) {
                    if (measValue.asBoolean() == valueMatch) {

                        final BinaryOutput binaryOutput = buildBinaryOutput(controlCode, count, offTime, onTime);

                        acceptor.AcceptCommand(binaryOutput, index, 0, responseAcceptor);
                    }
                }
            }
        }
    }

    public static class DeviceControlHandler implements ControlHandler {
        private final static Logger logger = LoggerFactory.getLogger(DeviceControlHandler.class);

        private final ICommandAcceptor acceptor;

        private final IResponseAcceptor responseAcceptor = new IResponseAcceptor() {
            @Override
            public void AcceptResponse(CommandResponse arResponse, int aSequence) {
                logger.debug("Command response: " + arResponse.getMResult());
            }
        };

        private final int index;
        private final ControlCode controlCode;
        private final Short count;
        private final Short offTime;
        private final Short onTime;

        public DeviceControlHandler(ICommandAcceptor acceptor, int index, ControlCode controlCode, Short count, Short offTime, Short onTime) {
            this.acceptor = acceptor;
            this.index = index;
            this.controlCode = controlCode;
            this.count = count;
            this.offTime = offTime;
            this.onTime = onTime;
        }

        public void handle(Control control) {
            logger.debug("Handled control: " + control);

            if (control instanceof Control.EndDeviceControl) {

                final BinaryOutput binaryOutput = buildBinaryOutput(controlCode, count, offTime, onTime);

                acceptor.AcceptCommand(binaryOutput, index, 0, responseAcceptor);

            }
        }
    }

    public static class KeySetpointHandler implements ControlHandler {
        private final static Logger logger = LoggerFactory.getLogger(KeySetpointHandler.class);

        private final ICommandAcceptor acceptor;
        private final int index;
        private final MeasTransform transform;

        private final IResponseAcceptor responseAcceptor = new IResponseAcceptor() {
            @Override
            public void AcceptResponse(CommandResponse arResponse, int aSequence) {
                logger.debug("Command response: " + arResponse.getMResult());
            }
        };

        public KeySetpointHandler(ICommandAcceptor acceptor, int index, MeasTransform transform) {
            this.acceptor = acceptor;
            this.index = index;
            this.transform = transform;
        }

        public void handle(Control control) {
            logger.debug("Handled control: " + control);

            if (control instanceof Control.KeyControl) {

                final Control.KeyControl keyControl = (Control.KeyControl) control;

                MeasValue measValue;
                if (transform != null) {
                    measValue = transform.transform(keyControl.getValue());
                } else {
                    measValue = keyControl.getValue();
                }

                if (measValue != null) {
                    final Double value = measValue.asDouble();

                    if (value != null) {

                        final Setpoint setpoint = new Setpoint(value);

                        acceptor.AcceptCommand(setpoint, index, 0, responseAcceptor);
                    }
                }
            }
        }
    }

    public static class SetPointHandler implements ControlHandler {
        private final static Logger logger = LoggerFactory.getLogger(SetPointHandler.class);

        private final ICommandAcceptor acceptor;
        private final int index;
        private final MeasTransform transform;

        private final IResponseAcceptor responseAcceptor = new IResponseAcceptor() {
            @Override
            public void AcceptResponse(CommandResponse arResponse, int aSequence) {
                logger.debug("Command response: " + arResponse.getMResult());
            }
        };

        public SetPointHandler(ICommandAcceptor acceptor, int index, MeasTransform transform) {
            this.acceptor = acceptor;
            this.index = index;
            this.transform = transform;
        }

        public void handle(Control control) {
            logger.debug("Handled control: " + control);

            if (control instanceof Control.SetpointControl) {

                final Control.SetpointControl setpointControl = (Control.SetpointControl) control;

                final MeasValue initialValue = new MeasValue.MeasFloatValue(setpointControl.getValue());
                MeasValue measValue;
                if (transform != null) {
                    measValue = transform.transform(initialValue);
                } else {
                    measValue = initialValue;
                }

                if (measValue != null) {
                    final double value = measValue.asDouble();

                    final Setpoint setpoint = new Setpoint(value);

                    acceptor.AcceptCommand(setpoint, index, 0, responseAcceptor);
                }
            }
        }
    }
}
