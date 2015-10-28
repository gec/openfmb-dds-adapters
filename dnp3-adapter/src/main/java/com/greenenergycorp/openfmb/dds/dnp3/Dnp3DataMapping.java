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

import com.greenenergycorp.openfmb.mapping.DeviceKeyId;
import com.greenenergycorp.openfmb.mapping.DeviceReadingId;
import com.greenenergycorp.openfmb.mapping.transform.MeasTransform;

import java.util.Map;

public class Dnp3DataMapping {

    private final Map<Long, KeyEntry> statusKeyMap;
    private final Map<Long, KeyEntry> analogKeyMap;
    private final Map<Long, KeyEntry> counterKeyMap;
    private final Map<Long, KeyEntry> controlStatusKeyMap;
    private final Map<Long, KeyEntry> setpointStatusKeyMap;
    
    private final Map<Long, ReadingEntry> statusReadingMap;
    private final Map<Long, ReadingEntry> analogReadingMap;
    private final Map<Long, ReadingEntry> counterReadingMap;
    private final Map<Long, ReadingEntry> controlStatusReadingMap;
    private final Map<Long, ReadingEntry> setpointStatusReadingMap;

    public Dnp3DataMapping(Map<Long, KeyEntry> statusKeyMap, Map<Long, KeyEntry> analogKeyMap, Map<Long, KeyEntry> counterKeyMap, Map<Long, KeyEntry> controlStatusKeyMap, Map<Long, KeyEntry> setpointStatusKeyMap, Map<Long, ReadingEntry> statusReadingMap, Map<Long, ReadingEntry> analogReadingMap, Map<Long, ReadingEntry> counterReadingMap, Map<Long, ReadingEntry> controlStatusReadingMap, Map<Long, ReadingEntry> setpointStatusReadingMap) {
        this.statusKeyMap = statusKeyMap;
        this.analogKeyMap = analogKeyMap;
        this.counterKeyMap = counterKeyMap;
        this.controlStatusKeyMap = controlStatusKeyMap;
        this.setpointStatusKeyMap = setpointStatusKeyMap;
        this.statusReadingMap = statusReadingMap;
        this.analogReadingMap = analogReadingMap;
        this.counterReadingMap = counterReadingMap;
        this.controlStatusReadingMap = controlStatusReadingMap;
        this.setpointStatusReadingMap = setpointStatusReadingMap;
    }

    public Map<Long, KeyEntry> getStatusKeyMap() {
        return statusKeyMap;
    }

    public Map<Long, KeyEntry> getAnalogKeyMap() {
        return analogKeyMap;
    }

    public Map<Long, KeyEntry> getCounterKeyMap() {
        return counterKeyMap;
    }

    public Map<Long, KeyEntry> getControlStatusKeyMap() {
        return controlStatusKeyMap;
    }

    public Map<Long, KeyEntry> getSetpointStatusKeyMap() {
        return setpointStatusKeyMap;
    }

    public Map<Long, ReadingEntry> getStatusReadingMap() {
        return statusReadingMap;
    }

    public Map<Long, ReadingEntry> getAnalogReadingMap() {
        return analogReadingMap;
    }

    public Map<Long, ReadingEntry> getCounterReadingMap() {
        return counterReadingMap;
    }

    public Map<Long, ReadingEntry> getControlStatusReadingMap() {
        return controlStatusReadingMap;
    }

    public Map<Long, ReadingEntry> getSetpointStatusReadingMap() {
        return setpointStatusReadingMap;
    }

    public static class KeyEntry {
        private final DeviceKeyId deviceKeyId;
        private final MeasTransform transform;

        public KeyEntry(DeviceKeyId deviceKeyId, MeasTransform transform) {
            this.deviceKeyId = deviceKeyId;
            this.transform = transform;
        }

        public DeviceKeyId getDeviceKeyId() {
            return deviceKeyId;
        }

        public MeasTransform getTransform() {
            return transform;
        }
    }

    public static class ReadingEntry {
        private final DeviceReadingId deviceReadingId;
        private final MeasTransform transform;

        public ReadingEntry(DeviceReadingId deviceReadingId, MeasTransform transform) {
            this.deviceReadingId = deviceReadingId;
            this.transform = transform;
        }

        public DeviceReadingId getDeviceReadingId() {
            return deviceReadingId;
        }

        public MeasTransform getTransform() {
            return transform;
        }
    }
}
