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

import com.greenenergycorp.openfmb.dds.mapping.xml.*;
import com.greenenergycorp.openfmb.mapping.transform.MeasTransform;
import com.greenenergycorp.openfmb.mapping.transform.TransformXmlLoader;
import com.greenenergycorp.openfmb.mapping.xml.CommonConversions;
import org.openfmb.model.dds.rti.openfmb.commonmodule.flowdirection.FlowDirectionKind;
import org.openfmb.model.dds.rti.openfmb.commonmodule.phasecode.PhaseCodeKind;
import org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind;
import org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.Map;

public class NamedDataMappingLoader {

    public static void loadDataMapping(Map<String, KeyUpdateMapping> keyIdMap, Map<String, ReadingUpdateMapping> readingIdMap, OpenFMBMapping xml) {

        if (xml.getDataMapping() != null && xml.getDataMapping().getMapping() != null) {

            for (OpenFMBMapping.DataMapping.Mapping map: xml.getDataMapping().getMapping()) {

                if (map.getMapFrom() == null) {
                    throw new IllegalArgumentException("Mapping must include name of source point");
                }
                final String measName = map.getMapFrom();

                if (map.getAdapterName() == null) {
                    throw new IllegalArgumentException("Mapping must have adapter name");
                }
                final String adapterName = map.getAdapterName();

                MeasTransform transform = null;
                if (map.getTransform() != null) {
                    transform = TransformXmlLoader.load(map.getTransform());
                }

                if (map.getKey() != null) {

                    keyIdMap.put(measName, new KeyUpdateMapping(new DeviceKeyId(adapterName, map.getKey()), transform));

                } else {
                    final ReadingId readingId = loadReadingId(map);

                    readingIdMap.put(measName, new ReadingUpdateMapping(new DeviceReadingId(adapterName, readingId), transform));
                }
            }
        }
    }

    public static class KeyUpdateMapping {
        private final DeviceKeyId id;
        private final MeasTransform transform;

        public KeyUpdateMapping(DeviceKeyId id, MeasTransform transform) {
            this.id = id;
            this.transform = transform;
        }

        public DeviceKeyId getId() {
            return id;
        }

        public MeasTransform getTransform() {
            return transform;
        }
    }

    public static class ReadingUpdateMapping {
        private final DeviceReadingId id;
        private final MeasTransform transform;

        public ReadingUpdateMapping(DeviceReadingId id, MeasTransform transform) {
            this.id = id;
            this.transform = transform;
        }

        public DeviceReadingId getId() {
            return id;
        }

        public MeasTransform getTransform() {
            return transform;
        }
    }

    public static ReadingId loadReadingId(ReadingDesc mapping) {

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

        return new ReadingId(unit, multiplier, flowDirection, phases, "");
    }

    public static class NamedXmlMarshaller {

        private final JAXBContext jaxbContext;

        private NamedXmlMarshaller(JAXBContext jaxbContext) {
            this.jaxbContext = jaxbContext;
        }

        public static NamedXmlMarshaller build() throws JAXBException {
            final JAXBContext jaxbContext = JAXBContext.newInstance(OpenFMBMapping.class);
            return new NamedXmlMarshaller(jaxbContext);
        }

        public OpenFMBMapping unmarshal(InputStream is) throws JAXBException {
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            final Object obj = unmarshaller.unmarshal(is);

            return (OpenFMBMapping)(obj);
        }
    }
}
