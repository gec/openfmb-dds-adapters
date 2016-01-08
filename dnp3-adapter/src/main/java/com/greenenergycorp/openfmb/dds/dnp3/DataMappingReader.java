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

import com.greenenergycorp.openfmb.dds.mapping.xml.*;
import com.greenenergycorp.openfmb.mapping.DeviceKeyId;
import com.greenenergycorp.openfmb.mapping.DeviceReadingId;
import com.greenenergycorp.openfmb.mapping.ReadingId;
import com.greenenergycorp.openfmb.mapping.transform.MeasTransform;
import com.greenenergycorp.openfmb.mapping.transform.TransformXmlLoader;
import com.greenenergycorp.openfmb.mapping.xml.CommonConversions;
import org.openfmb.model.dds.rti.openfmb.commonmodule.FlowDirectionKind;
import org.openfmb.model.dds.rti.openfmb.commonmodule.PhaseCodeKind;
import org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind;
import org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Loads data mapping configuration from XML.
 */
public class DataMappingReader {
    
    public static Dnp3DataMapping load(IndexMapping xml) {

        final Map<Long,Dnp3DataMapping.KeyEntry> binaryKeyMap = new HashMap<Long,Dnp3DataMapping.KeyEntry>();
        final Map<Long,Dnp3DataMapping.KeyEntry> analogKeyMap = new HashMap<Long,Dnp3DataMapping.KeyEntry>();
        final Map<Long,Dnp3DataMapping.KeyEntry> counterKeyMap = new HashMap<Long, Dnp3DataMapping.KeyEntry>();
        final Map<Long, Dnp3DataMapping.KeyEntry> controlStatusKeyMap = new HashMap<Long, Dnp3DataMapping.KeyEntry>();
        final Map<Long, Dnp3DataMapping.KeyEntry> setpointKeyMap = new HashMap<Long, Dnp3DataMapping.KeyEntry>();

        final Map<Long,Dnp3DataMapping.ReadingEntry> binaryReadingMap = new HashMap<Long, Dnp3DataMapping.ReadingEntry>();
        final Map<Long,Dnp3DataMapping.ReadingEntry> analogReadingMap = new HashMap<Long,Dnp3DataMapping.ReadingEntry>();
        final Map<Long,Dnp3DataMapping.ReadingEntry> counterReadingMap = new HashMap<Long,Dnp3DataMapping.ReadingEntry>();
        final Map<Long,Dnp3DataMapping.ReadingEntry> controlStatusReadingMap = new HashMap<Long,Dnp3DataMapping.ReadingEntry>();
        final Map<Long,Dnp3DataMapping.ReadingEntry> setpointReadingMap = new HashMap<Long,Dnp3DataMapping.ReadingEntry>();

        if (xml.getBinaries() != null && xml.getBinaries().getMapping() != null) {
            loadMappings(binaryKeyMap, binaryReadingMap, xml.getBinaries().getMapping());
        }

        if (xml.getAnalogs() != null && xml.getAnalogs().getMapping() != null) {
            loadMappings(analogKeyMap, analogReadingMap, xml.getAnalogs().getMapping());
        }

        if (xml.getCounters() != null && xml.getCounters().getMapping() != null) {
            loadMappings(counterKeyMap, counterReadingMap, xml.getCounters().getMapping());
        }

        if (xml.getControlStatuses() != null && xml.getControlStatuses().getMapping() != null) {
            loadMappings(controlStatusKeyMap, controlStatusReadingMap, xml.getControlStatuses().getMapping());
        }

        if (xml.getSetpointStatuses() != null && xml.getSetpointStatuses().getMapping() != null) {
            loadMappings(setpointKeyMap, setpointReadingMap, xml.getSetpointStatuses().getMapping());
        }

        return new Dnp3DataMapping(binaryKeyMap, analogKeyMap, counterKeyMap, controlStatusKeyMap, setpointKeyMap,
                binaryReadingMap, analogReadingMap, counterReadingMap, controlStatusReadingMap, setpointReadingMap);
    }

    private static void loadMappings(Map<Long,Dnp3DataMapping.KeyEntry> keyMap, Map<Long,Dnp3DataMapping.ReadingEntry> readMap, List<MappingSeq.Mapping> xmlList) {
        for (MappingSeq.Mapping mapping : xmlList) {

            MeasTransform transform = null;
            if (mapping.getTransform() != null) {
                transform = TransformXmlLoader.load(mapping.getTransform());
            }

            if (mapping.getAdapterName() != null && mapping.getIndex() != null) {
                if (mapping.getKey() != null) {

                    keyMap.put(mapping.getIndex(), new Dnp3DataMapping.KeyEntry(new DeviceKeyId(mapping.getAdapterName(), mapping.getKey()), transform));

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

                    readMap.put(mapping.getIndex(), new Dnp3DataMapping.ReadingEntry(new DeviceReadingId(mapping.getAdapterName(), readingId), transform));
                }
            } else {
                throw new IllegalArgumentException("Mapping must have adapter name and index");
            }
        }
    }
}
