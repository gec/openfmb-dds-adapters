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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DeviceUpdateManager implements DeviceObserver {

    private final static Logger logger = LoggerFactory.getLogger(DeviceUpdateManager.class);

    private final Map<String, DeviceAdapter> adapterMap; // = new HashMap<String, DeviceAdapter>();

    private final Map<String, DeviceValueBuffer> deviceMap = new HashMap<String, DeviceValueBuffer>();

    public DeviceUpdateManager(Map<String, DeviceAdapter> adapterMap) {
        this.adapterMap = adapterMap;
    }

    public void publish(List<ReadingMeasUpdate> readingMeasUpdates, List<KeyMeasUpdate> keyMeasUpdates) {

        final HashSet<String> changedDevices = new HashSet<String>();

        logger.debug("Reading updates: " + readingMeasUpdates);
        logger.debug("Key updates: " + keyMeasUpdates);

        if (readingMeasUpdates != null) {
            for (ReadingMeasUpdate update: readingMeasUpdates) {
                final String deviceName = update.getId().getDeviceName();
                final DeviceValueBuffer buffer = deviceMap.get(deviceName);
                if (buffer != null) {
                    final boolean change = buffer.addReading(update);
                    if (change) {
                        changedDevices.add(deviceName);
                    }
                } else {
                    final DeviceValueBuffer created = new DeviceValueBuffer();
                    deviceMap.put(deviceName, created);
                    created.addReading(update);
                    changedDevices.add(deviceName);
                }
            }
        }

        if (keyMeasUpdates != null) {
            for (KeyMeasUpdate update: keyMeasUpdates) {
                final String deviceName = update.getId().getDeviceName();
                final DeviceValueBuffer buffer = deviceMap.get(deviceName);
                if (buffer != null) {
                    final boolean change = buffer.addKeyValue(update);
                    if (change) {
                        changedDevices.add(deviceName);
                    }
                } else {
                    final DeviceValueBuffer created = new DeviceValueBuffer();
                    deviceMap.put(deviceName, created);
                    created.addKeyValue(update);
                    changedDevices.add(deviceName);
                }
            }
        }

        logger.debug("Changed devices: " + changedDevices);

        for (String device: changedDevices) {
            final DeviceValueBuffer buffer = deviceMap.get(device);
            if (buffer != null) {
                final DeviceValueBuffer.ValuesSnapshot current = buffer.current();

                final DeviceAdapter deviceAdapter = adapterMap.get(device);
                if (deviceAdapter != null) {
                    deviceAdapter.update(current.getReadingValueMap(), current.getKeyValueMap());
                }
            }
        }
    }

    public void publishAll() {
        for (Map.Entry<String, DeviceAdapter> entry: adapterMap.entrySet()) {
            final String device = entry.getKey();
            final DeviceAdapter deviceAdapter = entry.getValue();
            final DeviceValueBuffer buffer = deviceMap.get(device);
            if (buffer != null) {
                final DeviceValueBuffer.ValuesSnapshot current = buffer.current();
                logger.debug("Heartbeating: " + device);
                deviceAdapter.update(current.getReadingValueMap(), current.getKeyValueMap());
            }
        }
    }


}
