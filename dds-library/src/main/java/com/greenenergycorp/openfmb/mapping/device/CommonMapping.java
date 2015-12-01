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

import com.greenenergycorp.openfmb.mapping.Control;
import com.greenenergycorp.openfmb.mapping.MeasValue;
import com.greenenergycorp.openfmb.mapping.ReadingId;
import org.openfmb.model.dds.rti.openfmb.commonmodule.*;

public class CommonMapping {

    public static Reading buildReading(final ReadingId id, final MeasValue value, final long now) {
        final HexBinary16Type quality = new HexBinary16Type();
        quality.data[0] = 0;
        quality.data[1] = 0;

        final DateTimeInterval timeInterval = new DateTimeInterval();
        timeInterval.start = now;
        timeInterval.end = now;

        final ReadingType readingType = new ReadingType();

        readingType.unit = id.getUnit();
        readingType.multiplier = id.getMultiplier();
        readingType.flowDirection = id.getFlowDirection();
        readingType.phases = id.getPhases();
        readingType.name = id.getName();

        final Reading reading = new Reading();
        reading.qualityFlag = quality;
        reading.source = "";
        reading.timePeriod = timeInterval;
        reading.readingType = readingType;

        final Double readingValue = value.asDouble();

        if (readingValue != null) {
            reading.value = readingValue.floatValue();
            return reading;
        } else {
            return null;
        }
    }

    public static Control.EndDeviceControl buildControl(final String adapterName, final EndDeviceControlType controlType) {
        return new Control.EndDeviceControl(
                        adapterName,
                        controlType.action,
                        controlType.type);
    }
}
