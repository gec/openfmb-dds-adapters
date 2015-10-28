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
package com.greenenergycorp.openfmb.dds.modbus;

import com.greenenergycorp.openfmb.dds.mapping.xml.Conversion;
import com.greenenergycorp.openfmb.mapping.DeviceKeyId;
import com.greenenergycorp.openfmb.mapping.DeviceReadingId;
import com.greenenergycorp.openfmb.mapping.transform.MeasTransform;

import java.util.List;

public class ModbusDataMapping {

    private final List<IndexKeyMapping> discreteInputKeyMap;
    private final List<IndexKeyMapping> coilStatusKeyMap;

    private final List<IndexNumericKeyMapping> inputRegisterKeyMap;
    private final List<IndexNumericKeyMapping> holdingRegisterKeyMap;
    private final List<IndexReadingMapping> inputRegisterReadingMap;
    private final List<IndexReadingMapping> holdingRegisterReadingMap;

    public ModbusDataMapping(List<IndexKeyMapping> discreteInputKeyMap, List<IndexKeyMapping> coilStatusKeyMap, List<IndexNumericKeyMapping> inputRegisterKeyMap, List<IndexNumericKeyMapping> holdingRegisterKeyMap, List<IndexReadingMapping> inputRegisterReadingMap, List<IndexReadingMapping> holdingRegisterReadingMap) {
        this.discreteInputKeyMap = discreteInputKeyMap;
        this.coilStatusKeyMap = coilStatusKeyMap;
        this.inputRegisterKeyMap = inputRegisterKeyMap;
        this.holdingRegisterKeyMap = holdingRegisterKeyMap;
        this.inputRegisterReadingMap = inputRegisterReadingMap;
        this.holdingRegisterReadingMap = holdingRegisterReadingMap;
    }

    public List<IndexKeyMapping> getDiscreteInputKeyMap() {
        return discreteInputKeyMap;
    }

    public List<IndexKeyMapping> getCoilStatusKeyMap() {
        return coilStatusKeyMap;
    }

    public List<IndexNumericKeyMapping> getInputRegisterKeyMap() {
        return inputRegisterKeyMap;
    }

    public List<IndexNumericKeyMapping> getHoldingRegisterKeyMap() {
        return holdingRegisterKeyMap;
    }

    public List<IndexReadingMapping> getInputRegisterReadingMap() {
        return inputRegisterReadingMap;
    }

    public List<IndexReadingMapping> getHoldingRegisterReadingMap() {
        return holdingRegisterReadingMap;
    }

    public static class NumericMapping {
        private final Conversion conversion;
        private final Long bitMask;

        public NumericMapping(Conversion conversion, Long bitMask) {
            this.conversion = conversion;
            this.bitMask = bitMask;
        }

        public Conversion getConversion() {
            return conversion;
        }

        public Long getBitMask() {
            return bitMask;
        }
    }

    public static class IndexKeyMapping {
        private final int index;
        private final DeviceKeyId keyId;
        private final MeasTransform transform;

        public IndexKeyMapping(int index, DeviceKeyId keyId, MeasTransform transform) {
            this.index = index;
            this.keyId = keyId;
            this.transform = transform;
        }

        public int getIndex() {
            return index;
        }

        public DeviceKeyId getKeyId() {
            return keyId;
        }

        public MeasTransform getTransform() {
            return transform;
        }
    }

    public static class IndexNumericKeyMapping {
        private final int index;
        private final NumericMapping numericMapping;
        private final DeviceKeyId keyId;
        private final MeasTransform transform;

        public IndexNumericKeyMapping(int index, NumericMapping numericMapping, DeviceKeyId keyId, MeasTransform transform) {
            this.index = index;
            this.numericMapping = numericMapping;
            this.keyId = keyId;
            this.transform = transform;
        }

        public int getIndex() {
            return index;
        }

        public NumericMapping getNumericMapping() {
            return numericMapping;
        }

        public DeviceKeyId getKeyId() {
            return keyId;
        }

        public MeasTransform getTransform() {
            return transform;
        }
    }

    public static class IndexReadingMapping {
        private final int index;
        private final NumericMapping numericMapping;
        private final DeviceReadingId readingId;
        private final MeasTransform transform;

        public IndexReadingMapping(int index, NumericMapping numericMapping, DeviceReadingId readingId, MeasTransform transform) {
            this.index = index;
            this.numericMapping = numericMapping;
            this.readingId = readingId;
            this.transform = transform;
        }

        public int getIndex() {
            return index;
        }

        public NumericMapping getNumericMapping() {
            return numericMapping;
        }

        public DeviceReadingId getReadingId() {
            return readingId;
        }

        public MeasTransform getTransform() {
            return transform;
        }
    }
}
