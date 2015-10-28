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

import com.greenenergycorp.openfmb.mapping.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.totalgrid.dnp3.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UpdateAdapter extends IDataObserver {

    private final static Logger logger = LoggerFactory.getLogger(UpdateAdapter.class);

    private final String adapterLogId;
    private final Dnp3DataMapping mapping;
    private final DeviceObserver deviceObserver;

    private List<KeyMeasUpdate> keyUpdates = new ArrayList<KeyMeasUpdate>();
    private List<ReadingMeasUpdate> readingUpdates = new ArrayList<ReadingMeasUpdate>();

    public UpdateAdapter(String adapterLogId, Dnp3DataMapping mapping, DeviceObserver deviceObserver) {
        this.adapterLogId = adapterLogId;
        this.mapping = mapping;
        this.deviceObserver = deviceObserver;
    }

    @Override
    protected void _Start() {
    }

    @Override
    protected void _End() {
        try {
            if (keyUpdates.size() > 0 || readingUpdates.size() > 0) {
                logger.debug("Saw readingUpdates: " + readingUpdates);
                logger.debug("Saw keyUpdates: " + keyUpdates);
                deviceObserver.publish(readingUpdates, keyUpdates);
            }
        } catch (Throwable ex) {
            logger.error("Adapter for " + adapterLogId + " had exception thrown on publish: " + ex.getMessage());
        } finally {
            keyUpdates = new ArrayList<KeyMeasUpdate>();
            readingUpdates = new ArrayList<ReadingMeasUpdate>();
        }
    }

    private void handleUpdate(long index, Map<Long, Dnp3DataMapping.KeyEntry> keyIdMap, Map<Long, Dnp3DataMapping.ReadingEntry> readingIdMap, MeasValue value) {
        logger.trace("Update: " + index + ", value: " + value);
        final Dnp3DataMapping.KeyEntry id = keyIdMap.get(index);
        if (id != null) {

            if (id.getTransform() != null) {
                final MeasValue result = id.getTransform().transform(value);
                if (result != null) {
                    keyUpdates.add(new KeyMeasUpdate(id.getDeviceKeyId(), result));
                } else {
                    logger.debug("Transform returned null value: Update: " + index + ", value: " + value);
                }
            } else {
                keyUpdates.add(new KeyMeasUpdate(id.getDeviceKeyId(), value));
            }

        } else {
            final Dnp3DataMapping.ReadingEntry readingId = readingIdMap.get(index);
            if (readingId != null) {
                if (readingId.getTransform() != null) {
                    final MeasValue result = readingId.getTransform().transform(value);
                    if (result != null) {
                        readingUpdates.add(new ReadingMeasUpdate(readingId.getDeviceReadingId(), result));
                    } else {
                        logger.debug("Transform returned null value: Update: " + index + ", value: " + value);
                    }
                } else {
                    readingUpdates.add(new ReadingMeasUpdate(readingId.getDeviceReadingId(), value));
                }
            }
        }
    }

    @Override
    protected void _Update(Binary arPoint, long index) {
        try {
            handleUpdate(index, mapping.getStatusKeyMap(), mapping.getStatusReadingMap(), new MeasValue.MeasBoolValue(arPoint.GetValue()));
        } catch (Throwable ex) {
            onMiss("Status", index);
        }
    }

    @Override
    protected void _Update(Analog arPoint, long index) {
        try {
            handleUpdate(index, mapping.getAnalogKeyMap(), mapping.getAnalogReadingMap(), new MeasValue.MeasFloatValue(arPoint.GetValue()));
        } catch (Throwable ex) {
            onMiss("Analog", index);
        }
    }

    @Override
    protected void _Update(Counter arPoint, long index) {
        try {
            handleUpdate(index, mapping.getCounterKeyMap(), mapping.getCounterReadingMap(), new MeasValue.MeasIntValue(arPoint.GetValue()));
        } catch (Throwable ex) {
            onMiss("Counter", index);
        }
    }

    @Override
    protected void _Update(ControlStatus arPoint, long index) {
        try {
            handleUpdate(index, mapping.getControlStatusKeyMap(), mapping.getControlStatusReadingMap(), new MeasValue.MeasBoolValue(arPoint.GetValue()));
        } catch (Throwable ex) {
            onMiss("ControlStatus", index);
        }
    }

    @Override
    protected void _Update(SetpointStatus arPoint, long index) {
        try {
            handleUpdate(index, mapping.getSetpointStatusKeyMap(), mapping.getSetpointStatusReadingMap(), new MeasValue.MeasFloatValue(arPoint.GetValue()));
        } catch (Throwable ex) {
            onMiss("SetpointStatus", index);
        }
    }

    private void onMiss(String type, long index) {
        logger.debug(adapterLogId + " had unknown update: " + type + " " + index);
    }

}
