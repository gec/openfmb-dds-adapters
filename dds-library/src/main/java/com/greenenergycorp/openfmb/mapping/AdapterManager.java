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

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AdapterManager {
    private final static Logger logger = LoggerFactory.getLogger(AdapterManager.class);

    private final DeviceUpdateManager updateManager;

    private final BlockingQueue<UpdateSet> updateQueue = new LinkedBlockingQueue<UpdateSet>();

    public AdapterManager(DeviceUpdateManager updateManager) {
        this.updateManager = updateManager;
    }

    public void run() {

        long next = System.currentTimeMillis() + 1000;

        while(true) {

            try {
                final long now = System.currentTimeMillis();
                if (now > next) {
                    next = now + 1000;
                    updateManager.publishAll();
                }

                final UpdateSet set = updateQueue.poll(next - now, TimeUnit.MILLISECONDS);
                if (set != null) {
                    logger.debug("Update set: " + set);
                    updateManager.publish(set.getReadingMeasUpdates(), set.getKeyMeasUpdates());
                }

            } catch (InterruptedException e) {
                System.err.println("interrupted... " + e);
            }

        }

    }

    public DeviceObserver getObserver() {
        return new DeviceObserver() {
            public void publish(List<ReadingMeasUpdate> readingMeasUpdates, List<KeyMeasUpdate> keyMeasUpdates) {
                updateQueue.add(new UpdateSet(readingMeasUpdates, keyMeasUpdates));
            }
        };
    }

    private static class UpdateSet {
        private final List<ReadingMeasUpdate> readingMeasUpdates;
        private final List<KeyMeasUpdate> keyMeasUpdates;

        public UpdateSet(List<ReadingMeasUpdate> readingMeasUpdates, List<KeyMeasUpdate> keyMeasUpdates) {
            this.readingMeasUpdates = readingMeasUpdates;
            this.keyMeasUpdates = keyMeasUpdates;
        }

        public List<ReadingMeasUpdate> getReadingMeasUpdates() {
            return readingMeasUpdates;
        }

        public List<KeyMeasUpdate> getKeyMeasUpdates() {
            return keyMeasUpdates;
        }

        @Override
        public String toString() {
            return "UpdateSet{" +
                    "readingMeasUpdates=" + readingMeasUpdates +
                    ", keyMeasUpdates=" + keyMeasUpdates +
                    '}';
        }
    }
}
