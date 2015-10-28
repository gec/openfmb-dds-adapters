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

public abstract class MeasValue {

    public abstract Boolean asBoolean();
    public abstract Long asLong();
    public abstract Double asDouble();
    public abstract String asString();

    public static class MeasBoolValue extends MeasValue {
        private final boolean value;

        public MeasBoolValue(boolean value) {
            this.value = value;
        }

        public boolean getValue() {
            return value;
        }

        @Override
        public Boolean asBoolean() {
            return value;
        }

        @Override
        public Long asLong() {
            return (long)(value ? 1 : 0);
        }

        @Override
        public Double asDouble() {
            return (double)(value ? 1 : 0);
        }

        @Override
        public String asString() {
            return String.valueOf(value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MeasBoolValue that = (MeasBoolValue) o;

            return value == that.value;

        }

        @Override
        public int hashCode() {
            return (value ? 1 : 0);
        }

        @Override
        public String toString() {
            return "MeasBoolValue(" + value + ")";
        }
    }

    public static class MeasIntValue extends MeasValue {
        private final long value;

        public MeasIntValue(long value) {
            this.value = value;
        }

        public long getValue() {
            return value;
        }

        @Override
        public Boolean asBoolean() {
            return value != 0;
        }

        @Override
        public Long asLong() {
            return value;
        }

        @Override
        public Double asDouble() {
            return (double)value;
        }

        @Override
        public String asString() {
            return String.valueOf(value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MeasIntValue that = (MeasIntValue) o;

            return value == that.value;

        }

        @Override
        public int hashCode() {
            return (int) (value ^ (value >>> 32));
        }

        @Override
        public String toString() {
            return "MeasIntValue(" + value + ")";
        }
    }

    public static class MeasFloatValue extends MeasValue {
        private final double value;

        public MeasFloatValue(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public Boolean asBoolean() {
            return value != 0d;
        }

        @Override
        public Long asLong() {
            return (long)value;
        }

        @Override
        public Double asDouble() {
            return value;
        }

        @Override
        public String asString() {
            return String.valueOf(value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MeasFloatValue that = (MeasFloatValue) o;

            return Double.compare(that.value, value) == 0;

        }

        @Override
        public int hashCode() {
            long temp = Double.doubleToLongBits(value);
            return (int) (temp ^ (temp >>> 32));
        }

        @Override
        public String toString() {
            return "MeasFloatValue(" + value + ")";
        }
    }

    public static class MeasStringValue extends MeasValue {
        private final String value;

        public MeasStringValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public Boolean asBoolean() {
            return null;
        }

        @Override
        public Long asLong() {
            return null;
        }

        @Override
        public Double asDouble() {
            return null;
        }

        @Override
        public String asString() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MeasStringValue that = (MeasStringValue) o;

            return !(value != null ? !value.equals(that.value) : that.value != null);

        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "MeasStringValue(" + value + ")";
        }
    }

}
