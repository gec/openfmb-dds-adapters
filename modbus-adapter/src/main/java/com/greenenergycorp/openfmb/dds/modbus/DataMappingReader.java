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
import com.greenenergycorp.openfmb.mapping.DeviceKeyId;
import com.greenenergycorp.openfmb.mapping.DeviceReadingId;
import com.greenenergycorp.openfmb.mapping.ReadingId;
import com.greenenergycorp.openfmb.mapping.transform.MeasTransform;
import com.greenenergycorp.openfmb.mapping.transform.TransformXmlLoader;
import com.greenenergycorp.openfmb.mapping.xml.CommonConversions;
import org.openfmb.model.dds.rti.openfmb.commonmodule.flowdirection.FlowDirectionKind;
import org.openfmb.model.dds.rti.openfmb.commonmodule.phasecode.PhaseCodeKind;
import org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind;
import org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind;

import java.util.ArrayList;
import java.util.List;

public class DataMappingReader {

    public static ModbusDataMapping load(final ModbusMaster xml) {

        final List<ModbusDataMapping.IndexKeyMapping> discreteInputKeyMap = new ArrayList<ModbusDataMapping.IndexKeyMapping>();
        final List<ModbusDataMapping.IndexKeyMapping> coilStatusKeyMap = new ArrayList<ModbusDataMapping.IndexKeyMapping>();

        final List<ModbusDataMapping.IndexNumericKeyMapping> inputRegisterKeyMap = new ArrayList<ModbusDataMapping.IndexNumericKeyMapping>();
        final List<ModbusDataMapping.IndexNumericKeyMapping> holdingRegisterKeyMap = new ArrayList<ModbusDataMapping.IndexNumericKeyMapping>();
        final List<ModbusDataMapping.IndexReadingMapping> inputRegisterReadingMap = new ArrayList<ModbusDataMapping.IndexReadingMapping>();
        final List<ModbusDataMapping.IndexReadingMapping> holdingRegisterReadingMap = new ArrayList<ModbusDataMapping.IndexReadingMapping>();

        if (xml.getDiscreteInputMap() != null && xml.getDiscreteInputMap().getMapping() != null) {
            for (DiscreteInputMap.Mapping mapping : xml.getDiscreteInputMap().getMapping()) {
                loadBoolean(mapping, discreteInputKeyMap);
            }
        }
        if (xml.getCoilStatusMap() != null && xml.getCoilStatusMap().getMapping() != null) {
            for (CoilStatusMap.Mapping mapping : xml.getCoilStatusMap().getMapping()) {
                loadBoolean(mapping, coilStatusKeyMap);
            }
        }


        if (xml.getInputRegisterMap() != null && xml.getInputRegisterMap().getMapping() != null) {
            for (InputRegisterMap.Mapping mapping : xml.getInputRegisterMap().getMapping()) {
                loadNumeric(mapping, inputRegisterKeyMap, inputRegisterReadingMap);
            }
        }
        if (xml.getHoldingRegisterMap() != null && xml.getHoldingRegisterMap().getMapping() != null) {
            for (HoldingRegisterMap.Mapping mapping : xml.getHoldingRegisterMap().getMapping()) {
                loadNumeric(mapping, holdingRegisterKeyMap, holdingRegisterReadingMap);
            }
        }


        return new ModbusDataMapping(discreteInputKeyMap, coilStatusKeyMap, inputRegisterKeyMap, holdingRegisterKeyMap, inputRegisterReadingMap, holdingRegisterReadingMap);
    }

    private static void loadBoolean(final BooleanMapping mapping, final List<ModbusDataMapping.IndexKeyMapping> keyMappings) {
        if (mapping.getIndex() == null) {
            throw new IllegalArgumentException("Mapping must have index");
        }
        if (mapping.getAdapterName() == null) {
            throw new IllegalArgumentException("Mapping must have adapterName");
        }

        MeasTransform transform = null;
        if (mapping.getTransform() != null) {
            transform = TransformXmlLoader.load(mapping.getTransform());
        }

        if (mapping.getKey() != null) {
            keyMappings.add(new ModbusDataMapping.IndexKeyMapping(mapping.getIndex().intValue(), new DeviceKeyId(mapping.getAdapterName(), mapping.getKey()), transform));
        } else {
            throw new IllegalArgumentException("Modbus boolean mappings must be key mappings");
        }
    }

    private static void loadNumeric(final NumericMapping mapping, final List<ModbusDataMapping.IndexNumericKeyMapping> keyMappings, final List<ModbusDataMapping.IndexReadingMapping> readingMappings) {
        if (mapping.getIndex() == null) {
            throw new IllegalArgumentException("Mapping must have index");
        }
        if (mapping.getAdapterName() == null) {
            throw new IllegalArgumentException("Mapping must have adapterName");
        }

        MeasTransform transform = null;
        if (mapping.getTransform() != null) {
            transform = TransformXmlLoader.load(mapping.getTransform());
        }

        if (mapping.getKey() != null) {

            if (mapping.getType() == null) {
                throw new IllegalArgumentException("Numeric mapping must have conversion type");
            }
            Long bitMask = null;
            if (mapping.getBitMask() != null) {
                final String trimmed = mapping.getBitMask().trim();
                if (trimmed.startsWith("0x")) {
                    bitMask = Long.parseLong(trimmed.substring(2), 16);
                } else {
                    bitMask = Long.parseLong(trimmed);
                }
            }

            final ModbusDataMapping.NumericMapping numericMapping = new ModbusDataMapping.NumericMapping(mapping.getType(), bitMask);

            keyMappings.add(
                    new ModbusDataMapping.IndexNumericKeyMapping(mapping.getIndex().intValue(),
                            numericMapping,
                            new DeviceKeyId(mapping.getAdapterName(), mapping.getKey()),
                            transform));

        } else {
            final UnitSymbol unitXml = mapping.getUnit();
            if (unitXml == null) {
                throw new IllegalArgumentException("Mapping must have key or all of unit, multiplier, flowDirection, and phases");
            }
            final UnitSymbolKind unit = CommonConversions.convertFromXml(unitXml);
            if (unit == null) {
                throw new IllegalArgumentException("Unit mapping " + unitXml + " did not match DDS enum");
            }

            final UnitMultiplier multiplierXml = mapping.getMultiplier();
            if (multiplierXml == null) {
                throw new IllegalArgumentException("Mapping must have key or all of unit, multiplier, flowDirection, and phases");
            }
            final UnitMultiplierKind multiplier = CommonConversions.convertFromXml(multiplierXml);
            if (multiplier == null) {
                throw new IllegalArgumentException("Unit multiplier mapping " + multiplierXml + " did not match DDS enum");
            }

            final com.greenenergycorp.openfmb.dds.mapping.xml.FlowDirection flowDirectionXml = mapping.getFlowDirection();
            if (flowDirectionXml == null) {
                throw new IllegalArgumentException("Mapping must have key or all of unit, multiplier, flowDirection, and phases");
            }
            final FlowDirectionKind flowDirection = CommonConversions.convertFromXml(flowDirectionXml);
            if (flowDirection == null) {
                throw new IllegalArgumentException("Flow direction mapping " + flowDirectionXml + " did not match DDS enum");
            }

            final PhaseCode phasesXml = mapping.getPhases();
            if (phasesXml == null) {
                throw new IllegalArgumentException("Mapping must have key or all of unit, multiplier, flowDirection, and phases");
            }
            final PhaseCodeKind phases = CommonConversions.convertFromXml(phasesXml);
            if (phases == null) {
                throw new IllegalArgumentException("Phase code mapping " + flowDirectionXml + " did not match DDS enum");
            }

            final ReadingId readingId = new ReadingId(unit, multiplier, flowDirection, phases, "");

            if (mapping.getType() == null) {
                throw new IllegalArgumentException("Numeric mapping must have conversion type");
            }
            Long bitMask = null;
            if (mapping.getBitMask() != null) {
                final String trimmed = mapping.getBitMask().trim();
                if (trimmed.startsWith("0x")) {
                    bitMask = Long.parseLong(trimmed.substring(2), 16);
                } else {
                    bitMask = Long.parseLong(trimmed);
                }
            }

            final ModbusDataMapping.NumericMapping numericMapping = new ModbusDataMapping.NumericMapping(mapping.getType(), bitMask);
            final DeviceReadingId deviceReadingId = new DeviceReadingId(mapping.getAdapterName(), readingId);

            final ModbusDataMapping.IndexReadingMapping indexReadingMapping = new ModbusDataMapping.IndexReadingMapping(mapping.getIndex().intValue(), numericMapping, deviceReadingId, transform);

            readingMappings.add(indexReadingMapping);
        }
    }
}
