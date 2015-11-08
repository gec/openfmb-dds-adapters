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

import com.greenenergycorp.openfmb.dds.mapping.xml.Conversion;
import com.greenenergycorp.openfmb.mapping.DeviceObserver;
import com.greenenergycorp.openfmb.mapping.KeyMeasUpdate;
import com.greenenergycorp.openfmb.mapping.MeasValue;
import com.greenenergycorp.openfmb.mapping.ReadingMeasUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.totalgrid.modbus.japi.BytePair;
import org.totalgrid.modbus.japi.ModbusBitValue;
import org.totalgrid.modbus.japi.ModbusDataObserver;
import org.totalgrid.modbus.japi.ModbusRegisterValue;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implements the Modbus data observer interface to translate and transform data values and then
 * forward them to the DDS device observer.
 */
public class DataObserverAdapter implements ModbusDataObserver {
    private final static Logger logger = LoggerFactory.getLogger(DataObserverAdapter.class);

    private final DeviceObserver deviceObserver;
    private final ModbusDataMapping mapping;

    public DataObserverAdapter(DeviceObserver deviceObserver, ModbusDataMapping mapping) {
        this.deviceObserver = deviceObserver;
        this.mapping = mapping;
    }

    public void onReadDiscreteInput(List<ModbusBitValue> values) {
        final Map<Integer, Boolean> valueMap = bitValuesToMap(values);
        handleBitValues(valueMap, mapping.getDiscreteInputKeyMap(), deviceObserver);
    }

    public void onReadCoilStatus(List<ModbusBitValue> values) {
        final Map<Integer, Boolean> valueMap = bitValuesToMap(values);
        handleBitValues(valueMap, mapping.getCoilStatusKeyMap(), deviceObserver);
    }

    public void onReadHoldingRegister(List<ModbusRegisterValue> values) {
        final Map<Integer, BytePair> valueMap = regValuesToMap(values);
        handleRegisterValues(valueMap, mapping.getHoldingRegisterKeyMap(), mapping.getHoldingRegisterReadingMap(), deviceObserver);
    }

    public void onReadInputRegister(List<ModbusRegisterValue> values) {
        final Map<Integer, BytePair> valueMap = regValuesToMap(values);
        handleRegisterValues(valueMap, mapping.getInputRegisterKeyMap(), mapping.getInputRegisterReadingMap(), deviceObserver);
    }

    private static void handleBitValues(Map<Integer, Boolean> valueMap, List<ModbusDataMapping.IndexKeyMapping> mapping, DeviceObserver deviceObserver) {
        final List<KeyMeasUpdate> measUpdates = new ArrayList<KeyMeasUpdate>();

        for (ModbusDataMapping.IndexKeyMapping map: mapping) {
            final Boolean v = valueMap.get(map.getIndex());
            if (v != null) {

                final MeasValue.MeasBoolValue measValue = new MeasValue.MeasBoolValue(v);

                if (map.getTransform() != null) {
                    final MeasValue result = map.getTransform().transform(measValue);
                    if (result != null) {
                        measUpdates.add(new KeyMeasUpdate(map.getKeyId(), result));
                    }
                } else {
                    measUpdates.add(new KeyMeasUpdate(map.getKeyId(), measValue));
                }
            }
        }

        deviceObserver.publish(null, measUpdates);
    }

    private static void handleRegisterValues(
            Map<Integer, BytePair> valueMap,
            List<ModbusDataMapping.IndexNumericKeyMapping> keyMappings,
            List<ModbusDataMapping.IndexReadingMapping> readingMappings,
            DeviceObserver deviceObserver) {
        final List<KeyMeasUpdate> keyUpdates = new ArrayList<KeyMeasUpdate>();
        final List<ReadingMeasUpdate> readingUpdates = new ArrayList<ReadingMeasUpdate>();

        for (ModbusDataMapping.IndexNumericKeyMapping mapping: keyMappings) {
            final MeasValue measValue = convert(
                    valueMap,
                    mapping.getIndex(),
                    mapping.getNumericMapping().getConversion(),
                    mapping.getNumericMapping().getBitMask());

            if (measValue != null) {
                logger.debug("Saw register value: " + mapping.getKeyId() + " - " + mapping.getIndex() + " - " + measValue);
                if (mapping.getTransform() != null) {
                    final MeasValue result = mapping.getTransform().transform(measValue);
                    if (result != null) {
                        keyUpdates.add(new KeyMeasUpdate(mapping.getKeyId(), result));
                    }
                } else {
                    keyUpdates.add(new KeyMeasUpdate(mapping.getKeyId(), measValue));
                }
            }
        }

        for (ModbusDataMapping.IndexReadingMapping mapping: readingMappings) {
            final MeasValue measValue = convert(
                    valueMap,
                    mapping.getIndex(),
                    mapping.getNumericMapping().getConversion(),
                    mapping.getNumericMapping().getBitMask());

            if (measValue != null) {
                logger.debug("Saw register value: " + mapping.getReadingId() + " - " + mapping.getIndex() + " - " + measValue);
                if (mapping.getTransform() != null) {
                    final MeasValue result = mapping.getTransform().transform(measValue);
                    if (result != null) {
                        readingUpdates.add(new ReadingMeasUpdate(mapping.getReadingId(), result));
                    }
                } else {
                    readingUpdates.add(new ReadingMeasUpdate(mapping.getReadingId(), measValue));
                }
            }

        }

        deviceObserver.publish(readingUpdates, keyUpdates);
    }

    private static MeasValue convert(Map<Integer, BytePair> valueMap, int index, Conversion conversion, Long bitMask) {
        if (conversion == Conversion.U_INT_16) {
            final BytePair p0 = valueMap.get(index);
            if (p0 != null) {
                final long v = toUInt16(p0);
                if (bitMask != null) {
                    return new MeasValue.MeasIntValue(v & bitMask);
                } else {
                    return new MeasValue.MeasIntValue(v);
                }
            } else {
                return null;
            }
        } else if (conversion == Conversion.S_INT_16) {
            final BytePair p0 = valueMap.get(index);
            if (p0 != null) {
                final long v = toSInt16(p0);
                if (bitMask != null) {
                    return new MeasValue.MeasIntValue(v & bitMask);
                } else {
                    return new MeasValue.MeasIntValue(v);
                }
            } else {
                return null;
            }
        } else if (conversion == Conversion.S_INT_32_BE) {
            final BytePair p0 = valueMap.get(index);
            final BytePair p1 = valueMap.get(index + 1);
            if (p0 != null && p1 != null) {
                final long v = toSInt32BE(p0, p1);
                if (bitMask != null) {
                    return new MeasValue.MeasIntValue(v & bitMask);
                } else {
                    return new MeasValue.MeasIntValue(v);
                }
            } else {
                return null;
            }
        } else if (conversion == Conversion.U_INT_32_BE) {
            final BytePair p0 = valueMap.get(index);
            final BytePair p1 = valueMap.get(index + 1);
            if (p0 != null && p1 != null) {
                final long v = toUInt32BE(p0, p1);
                if (bitMask != null) {
                    return new MeasValue.MeasIntValue(v & bitMask);
                } else {
                    return new MeasValue.MeasIntValue(v);
                }
            } else {
                return null;
            }
        } else if (conversion == Conversion.S_INT_32_LE) {
            final BytePair p0 = valueMap.get(index);
            final BytePair p1 = valueMap.get(index + 1);
            if (p0 != null && p1 != null) {
                final long v = toSInt32LE(p0, p1);
                if (bitMask != null) {
                    return new MeasValue.MeasIntValue(v & bitMask);
                } else {
                    return new MeasValue.MeasIntValue(v);
                }
            } else {
                return null;
            }
        } else if (conversion == Conversion.U_INT_32_LE) {
            final BytePair p0 = valueMap.get(index);
            final BytePair p1 = valueMap.get(index + 1);
            if (p0 != null && p1 != null) {
                final long v = toUInt32LE(p0, p1);
                if (bitMask != null) {
                    return new MeasValue.MeasIntValue(v & bitMask);
                } else {
                    return new MeasValue.MeasIntValue(v);
                }
            } else {
                return null;
            }
        } else if (conversion == Conversion.FLOAT_32_BE) {
            final BytePair p0 = valueMap.get(index);
            final BytePair p1 = valueMap.get(index + 1);
            if (p0 != null && p1 != null) {
                return new MeasValue.MeasFloatValue(toFloat32BE(p0, p1));
            } else {
                return null;
            }
        } else if (conversion == Conversion.FLOAT_32_LE) {
            final BytePair p0 = valueMap.get(index);
            final BytePair p1 = valueMap.get(index + 1);
            if (p0 != null && p1 != null) {
                return new MeasValue.MeasFloatValue(toFloat32LE(p0, p1));
            } else {
                return null;
            }
        } else if (conversion == Conversion.FLOAT_64_BE) {
            final BytePair p0 = valueMap.get(index);
            final BytePair p1 = valueMap.get(index + 1);
            final BytePair p2 = valueMap.get(index + 2);
            final BytePair p3 = valueMap.get(index + 3);
            if (p0 != null && p1 != null && p2 != null && p3 != null) {
                return new MeasValue.MeasFloatValue(toFloat64BE(p0, p1, p2, p3));
            } else {
                return null;
            }
        } else if (conversion == Conversion.FLOAT_64_LE) {
            final BytePair p0 = valueMap.get(index);
            final BytePair p1 = valueMap.get(index + 1);
            final BytePair p2 = valueMap.get(index + 2);
            final BytePair p3 = valueMap.get(index + 3);
            if (p0 != null && p1 != null && p2 != null && p3 != null) {
                return new MeasValue.MeasFloatValue(toFloat64LE(p0, p1, p2, p3));
            } else {
                return null;
            }
        }

        return null;
    }

    private static long toSInt16(final BytePair p) {
        return (p.getFirst() << 8) | (p.getSecond() & 0xFF);
    }
    private static long toUInt16(final BytePair p) {
        return ((p.getFirst() & 0xFF) << 8) | (p.getSecond() & 0xFF);
    }

    private static long toSInt32BE(final BytePair p0, final BytePair p1) {
        return toSInt16(p0) << 16 | toUInt16(p1);
    }
    private static long toUInt32BE(final BytePair p0, final BytePair p1) {
        return toUInt16(p0) << 16 | toUInt16(p1);
    }

    private static long toSInt32LE(final BytePair p0, final BytePair p1) {
        return toSInt32BE(p1, p0);
    }
    private static long toUInt32LE(final BytePair p0, final BytePair p1) {
        return toUInt32BE(p1, p0);
    }

    private static float toFloat32BE(final BytePair p0, final BytePair p1) {
        byte[] array = {p0.getFirst(), p0.getSecond(), p1.getFirst(), p1.getSecond()};
        return ByteBuffer.wrap(array).getFloat();
    }
    private static float toFloat32LE(final BytePair p0, final BytePair p1) {
        return toFloat32BE(p1, p0);
    }

    private static double toFloat64BE(final BytePair p0, final BytePair p1, final BytePair p2, final BytePair p3) {
        byte[] array = {p0.getFirst(), p0.getSecond(), p1.getFirst(), p1.getSecond(), p2.getFirst(), p2.getSecond(), p3.getFirst(), p3.getSecond()};
        return ByteBuffer.wrap(array).getDouble();
    }
    private static double toFloat64LE(final BytePair p0, final BytePair p1, final BytePair p2, final BytePair p3) {
        return toFloat64BE(p3, p2, p1, p0);
    }

    private static Map<Integer, Boolean> bitValuesToMap(List<ModbusBitValue> values) {
        final Map<Integer, Boolean> valueMap = new HashMap<Integer, Boolean>();
        for (ModbusBitValue value: values) {
            valueMap.put(value.getIndex(), value.isValue());
        }
        return valueMap;
    }

    private static Map<Integer, BytePair> regValuesToMap(List<ModbusRegisterValue> values) {
        final Map<Integer, BytePair> valueMap = new HashMap<Integer, BytePair>();
        for (ModbusRegisterValue value: values) {
            valueMap.put(value.getIndex(), value.getValue());
        }
        return valueMap;
    }
}
