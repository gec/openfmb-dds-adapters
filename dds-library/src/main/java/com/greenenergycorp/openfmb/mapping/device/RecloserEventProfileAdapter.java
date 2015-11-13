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

import com.rti.dds.infrastructure.InstanceHandle_t;
import org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.*;
import com.greenenergycorp.openfmb.mapping.DeviceAdapter;
import com.greenenergycorp.openfmb.mapping.MeasValue;
import com.greenenergycorp.openfmb.mapping.ReadingId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RecloserEventProfileAdapter implements DeviceAdapter {

    private final static Logger logger = LoggerFactory.getLogger(RecloserEventProfileAdapter.class);

    private final RecloserEventProfileDataWriter writer;

    private final String logicalDeviceId;
    private final Recloser deviceDescription;

    public final static String isBlockedKey = "isBlocked";
    public final static String switchStatusKey = "SwitchStatus";

    public final static String[] keys = { isBlockedKey, switchStatusKey };

    public RecloserEventProfileAdapter(RecloserEventProfileDataWriter writer, String logicalDeviceId, Recloser deviceDescription) {
        this.writer = writer;
        this.logicalDeviceId = logicalDeviceId;
        this.deviceDescription = deviceDescription;
    }

    public void update(Map<ReadingId, MeasValue> readingValues, Map<String, MeasValue> keyValues) {

        final RecloserEventProfile message = mapToStruct(readingValues, keyValues);
        if (message != null) {
            writer.write(message, InstanceHandle_t.HANDLE_NIL);
        }
    }


    public RecloserEventProfile mapToStruct(Map<ReadingId, MeasValue> readingValues, Map<String, MeasValue> keyValues) {

        for (String key: keys) {
            if (!keyValues.containsKey(key)) {
                return null;
            }
        }

        Boolean isBlocked = keyValues.get(isBlockedKey).asBoolean();
        if (isBlocked == null) {
            logger.warn("RecloserEventProfile adapter could not interpret " + isBlockedKey);
            return null;
        }

        final Long switchStatusInt = keyValues.get(switchStatusKey).asLong();
        if (switchStatusInt == null) {
            return null;
        }
        final SwitchStatusKind statusEnum = SwitchStatusKind.valueOf(switchStatusInt.intValue());
        if (statusEnum == null) {
            logger.warn("RecloserEventProfile adapter could not interpret " + switchStatusKey);
            return null;
        }

        final RecloserEventProfile recloserEventProfile = new RecloserEventProfile();

        final long now = System.currentTimeMillis();

        recloserEventProfile.logicalDeviceID = logicalDeviceId;
        recloserEventProfile.timestamp = now;

        recloserEventProfile.recloser = deviceDescription;

        final RecloserStatus recloserStatus = new RecloserStatus();

        recloserStatus.isBlocked = isBlocked;
        recloserStatus.switchStatus = statusEnum;

        recloserStatus.timestamp = now;
        recloserStatus.value = "";

        final HexBinary16Type quality = new HexBinary16Type();
        quality.data[0] = 0;
        quality.data[1] = 0;

        recloserStatus.qualityFlag = quality;

        recloserEventProfile.recloserStatus = recloserStatus;

        return recloserEventProfile;
    }

}
