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

public class ReadingMeasUpdate {
    private final DeviceReadingId id;
    private final MeasValue value;

    public ReadingMeasUpdate(DeviceReadingId id, MeasValue value) {
        this.id = id;
        this.value = value;
    }

    public DeviceReadingId getId() {
        return id;
    }

    public MeasValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ReadingMeasUpdate{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}