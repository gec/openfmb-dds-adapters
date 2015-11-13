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
package com.greenenergycorp.openfmb.mapping.device;

import com.greenenergycorp.openfmb.mapping.DeviceAdapter;
import com.greenenergycorp.openfmb.mapping.MeasValue;
import com.greenenergycorp.openfmb.mapping.ReadingId;
import com.rti.dds.infrastructure.InstanceHandle_t;
import org.openfmb.model.dds.rti.openfmb.solarmodule.*;
import org.openfmb.model.dds.rti.openfmb.solarmodule.SolarInverterStatus;
import org.openfmb.model.dds.rti.openfmb.solarmodule.SolarInverter;
import org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type;
import org.openfmb.model.dds.rti.openfmb.solarmodule.SolarEventProfileDataWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class SolarEventProfileAdapter implements DeviceAdapter {

    private final static Logger logger = LoggerFactory.getLogger(SolarEventProfileAdapter.class);

    private final SolarEventProfileDataWriter writer;
    private final String logicalDeviceId;
    private final SolarInverter deviceDescription;

    public final static String isConnectedKey = "isConnected";

    public final static String[] keys = { isConnectedKey };

    public SolarEventProfileAdapter(SolarEventProfileDataWriter writer, String logicalDeviceId, SolarInverter deviceDescription) {
        this.writer = writer;
        this.logicalDeviceId = logicalDeviceId;
        this.deviceDescription = deviceDescription;
    }


    public void update(Map<ReadingId, MeasValue> readingValues, Map<String, MeasValue> keyValues) {

        final SolarEventProfile message = mapToStruct(readingValues, keyValues);
        if (message != null) {
            writer.write(message, InstanceHandle_t.HANDLE_NIL);
        }
    }


    public SolarEventProfile mapToStruct(Map<ReadingId, MeasValue> readingValues, Map<String, MeasValue> keyValues) {

        for (String key: keys) {
            if (!keyValues.containsKey(key)) {
                return null;
            }
        }

        final SolarEventProfile module = new SolarEventProfile();

        final long now = System.currentTimeMillis();

        module.logicalDeviceID = logicalDeviceId;
        module.timestamp = now;

        module.solarInverter = deviceDescription;

        Boolean isConnected = keyValues.get(isConnectedKey).asBoolean();
        if (isConnected == null) {
            return null;
        }

        final SolarInverterStatus solarStatus = new SolarInverterStatus();
        solarStatus.isConnected = isConnected;

        solarStatus.timestamp = now;
        solarStatus.value = "";

        final HexBinary16Type quality = new HexBinary16Type();
        quality.data[0] = 0;
        quality.data[1] = 0;

        solarStatus.qualityFlag = quality;

        module.solarInverterStatus = solarStatus;

        return module;
    }

}
