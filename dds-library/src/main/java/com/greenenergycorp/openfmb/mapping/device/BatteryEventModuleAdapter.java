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
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryEventModule;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryEventModuleDataWriter;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryStatus;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystem;
import org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type;

import java.util.Map;

public class BatteryEventModuleAdapter implements DeviceAdapter {

    private final BatteryEventModuleDataWriter writer;
    private final String logicalDeviceId;
    private final BatterySystem deviceDescription;

    public final static String isChargingKey = "isCharging";
    public final static String isConnectedKey = "isConnected";
    public final static String modeKey = "mode";
    public final static String stateOfChargeKey = "stateOfCharge";

    public final static String[] keys = { isChargingKey, isConnectedKey, modeKey, stateOfChargeKey };

    public BatteryEventModuleAdapter(BatteryEventModuleDataWriter writer, String logicalDeviceId, BatterySystem deviceDescription) {
        this.writer = writer;
        this.logicalDeviceId = logicalDeviceId;
        this.deviceDescription = deviceDescription;
    }


    public void update(Map<ReadingId, MeasValue> readingValues, Map<String, MeasValue> keyValues) {

        final BatteryEventModule message = mapToStruct(readingValues, keyValues);
        if (message != null) {
            writer.write(message, InstanceHandle_t.HANDLE_NIL);
        }
    }


    public BatteryEventModule mapToStruct(Map<ReadingId, MeasValue> readingValues, Map<String, MeasValue> keyValues) {

        final BatteryEventModule module = new BatteryEventModule();

        final long now = System.currentTimeMillis();

        module.logicalDeviceID = logicalDeviceId;
        module.timestamp = now;

        module.batterySystem = deviceDescription;

        Boolean isCharging = keyValues.get(isChargingKey).asBoolean();
        if (isCharging == null) {
            return null;
        }
        Boolean isConnected = keyValues.get(isConnectedKey).asBoolean();
        if (isConnected == null) {
            return null;
        }
        String mode = keyValues.get(modeKey).asString();
        if (mode == null) {
            return null;
        }
        Double stateOfCharge = keyValues.get(stateOfChargeKey).asDouble();
        if (stateOfCharge == null) {
            return null;
        }

        final BatteryStatus batteryStatus = new BatteryStatus();
        batteryStatus.isCharging = isCharging;
        batteryStatus.isConnected = isConnected;
        batteryStatus.mode = mode;
        batteryStatus.stateOfCharge = (float)(double)stateOfCharge;

        batteryStatus.timestamp = now;
        batteryStatus.value = "";

        final HexBinary16Type quality = new HexBinary16Type();
        quality.data[0] = 0;
        quality.data[1] = 0;

        batteryStatus.qualityFlag = quality;

        module.batteryStatus = batteryStatus;

        return module;
    }

}
