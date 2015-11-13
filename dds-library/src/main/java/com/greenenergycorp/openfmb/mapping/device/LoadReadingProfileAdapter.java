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
import org.openfmb.model.dds.rti.openfmb.commonmodule.Reading;
import org.openfmb.model.dds.rti.openfmb.loadmodule.EnergyConsumer;
import org.openfmb.model.dds.rti.openfmb.loadmodule.LoadReadingProfile;
import org.openfmb.model.dds.rti.openfmb.loadmodule.LoadReadingProfileDataWriter;

import java.util.Map;

public class LoadReadingProfileAdapter implements DeviceAdapter {

    private final LoadReadingProfileDataWriter writer;
    private final String messageId;
    private final EnergyConsumer deviceDescription;

    public LoadReadingProfileAdapter(LoadReadingProfileDataWriter writer, String messageId, EnergyConsumer deviceDescription) {
        this.writer = writer;
        this.messageId = messageId;
        this.deviceDescription = deviceDescription;
    }


    public void update(Map<ReadingId, MeasValue> readingValues, Map<String, MeasValue> keyValues) {

        final LoadReadingProfile message = mapToStruct(readingValues, keyValues);
        if (message != null) {
            writer.write(message, InstanceHandle_t.HANDLE_NIL);
        }
    }

    public LoadReadingProfile mapToStruct(Map<ReadingId, MeasValue> readingValues, Map<String, MeasValue> keyValues) {

        if (readingValues != null && !readingValues.isEmpty()) {

            final LoadReadingProfile module = new LoadReadingProfile();

            final long now = System.currentTimeMillis();

            module.logicalDeviceID = messageId;
            module.timestamp = now;

            module.energyConsumer = deviceDescription;

            for (Map.Entry<ReadingId, MeasValue> entry : readingValues.entrySet()) {

                final Reading reading = CommonMapping.buildReading(entry.getKey(), entry.getValue(), now);
                if (reading != null) {
                    module.readings.userData.add(reading);
                }
            }

            return module;

        } else {
            return null;
        }

    }
}
