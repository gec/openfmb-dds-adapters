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

import java.util.HashMap;
import java.util.Map;

/**
 *  Buffer for tracking updates to key and reading values for a particular mapped device. Keeps the latest value
 *  and informs the user on updates whether the add represents a change.
 */
public class DeviceValueBuffer {

    private Map<String, MeasValue> keyValueMap = new HashMap<String, MeasValue>();
    private Map<ReadingId, MeasValue> readingValueMap = new HashMap<ReadingId, MeasValue>();

    /**
     * Add reading data update.
     *
     * @param update Data update for an OpenFMB reading.
     * @return Whether the buffer is changed as a result of the update (the update was not a duplicate).
     */
    public boolean addReading(ReadingMeasUpdate update) {
        final ReadingId id = update.getId().getReadingId();
        final MeasValue prevValue = readingValueMap.get(id);
        readingValueMap.put(id, update.getValue());
        return prevValue == null || !prevValue.equals(update.getValue());
    }

    /**
     * Add key data update.
     *
     * @param update Data update for a key field.
     * @return Whether the buffer is changed as a result of the update (the update was not a duplicate).
     */
    public boolean addKeyValue(KeyMeasUpdate update) {
        final String key = update.getId().getKey();
        final MeasValue prevValue = keyValueMap.get(key);
        keyValueMap.put(key, update.getValue());
        return prevValue == null || !prevValue.equals(update.getValue());
    }

    /**
     * Gets a snapshot of the current values in the buffer.
     *
     * @return Snapshot of the current values in the buffer.
     */
    public ValuesSnapshot current() {
        return new ValuesSnapshot(keyValueMap, readingValueMap);
    }

    /**
     * Snapshot of the current values in the buffer.
     */
    public static class ValuesSnapshot {
        private final Map<String, MeasValue> keyValueMap;
        private final Map<ReadingId, MeasValue> readingValueMap;

        /**
         * @param keyValueMap Map of data updates for key fields.
         * @param readingValueMap Map of data updates for OpenFMB readings.
         */
        public ValuesSnapshot(Map<String, MeasValue> keyValueMap, Map<ReadingId, MeasValue> readingValueMap) {
            this.keyValueMap = keyValueMap;
            this.readingValueMap = readingValueMap;
        }

        /**
         * @return Map of data updates for key fields.
         */
        public Map<String, MeasValue> getKeyValueMap() {
            return keyValueMap;
        }

        /**
         * @return Map of data updates for OpenFMB readings.
         */
        public Map<ReadingId, MeasValue> getReadingValueMap() {
            return readingValueMap;
        }
    }
}
