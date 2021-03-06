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

/**
 * Data update associated with a mapped device and key ID.
 */
public class KeyMeasUpdate {
    private final DeviceKeyId id;
    private final MeasValue value;

    /**
     *
     * @param id ID of an OpenFMB key field for a particular mapped device.
     * @param value Data update.
     */
    public KeyMeasUpdate(DeviceKeyId id, MeasValue value) {
        this.id = id;
        this.value = value;
    }

    /**
     * @return ID of an OpenFMB key field for a particular mapped device.
     */
    public DeviceKeyId getId() {
        return id;
    }

    /**
     * @return Data update.
     */
    public MeasValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "KeyMeasUpdate{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
