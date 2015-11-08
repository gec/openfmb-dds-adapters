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
package com.greenenergycorp.openfmb.mapping.transform;

import com.greenenergycorp.openfmb.mapping.MeasValue;

import java.util.List;

/**
 * Represents a sequence of transformations that result in an (optional) value.
 */
public class TransformChain implements MeasTransform {
    private final List<MeasTransform> transforms;

    /**
     * @param transforms Sequence of transforms to perform on input values.
     */
    public TransformChain(List<MeasTransform> transforms) {
        this.transforms = transforms;
    }

    /**
     * Transform an input value by iteratively passing it through the sequence of transformation steps.
     * @param value Input value.
     * @return Result value, null if no value is produced.
     */
    public MeasValue transform(MeasValue value) {

        MeasValue current = value;
        for (MeasTransform transform: transforms) {
            final MeasValue result = transform.transform(value);
            if (result != null) {
                current = result;
            } else {
                return null;
            }
        }

        return current;
    }


    public static class Scale implements MeasTransform {
        private final Double multiplier;
        private final Double offset;

        public Scale(Double multiplier, Double offset) {
            this.multiplier = multiplier;
            this.offset = offset;
        }

        public MeasValue transform(MeasValue value) {

            final Double v = value.asDouble();
            if (v != null) {
                double result = v;
                if (multiplier != null) {
                    result = result * multiplier;
                }
                if (offset != null) {
                    result = result + offset;
                }
                return new MeasValue.MeasFloatValue(result);

            } else {
                return null;
            }
        }
    }

    public static class Match implements MeasTransform {

        private final List<MatchPair> cases;
        private final MeasValue valueDefault;

        public Match(List<MatchPair> cases, MeasValue valueDefault) {
            this.cases = cases;
            this.valueDefault = valueDefault;
        }

        public MeasValue transform(MeasValue value) {
            for (MatchPair matchCase: cases) {
                final MeasValue result = matchCase.check(value);
                if (result != null) {
                    return result;
                }
            }
            return valueDefault;
        }

        public static class MatchPair {
            private final MeasValue match;
            private final MeasValue result;

            public MatchPair(MeasValue match, MeasValue result) {
                this.match = match;
                this.result = result;
            }

            public MeasValue check(MeasValue value) {
                if (value.equals(match)) {
                    return result;
                } else {
                    return null;
                }
            }
        }
    }

    public static class GreaterThan implements MeasTransform {
        private final double comparedValue;

        public GreaterThan(double comparedValue) {
            this.comparedValue = comparedValue;
        }

        public MeasValue transform(MeasValue value) {
            final Double v = value.asDouble();
            if (v != null) {
               return new MeasValue.MeasBoolValue(v > comparedValue);
            } else {
                return new MeasValue.MeasBoolValue(false);
            }
        }
    }

    public static class GreaterThanOrEqual implements MeasTransform {
        private final double comparedValue;

        public GreaterThanOrEqual(double comparedValue) {
            this.comparedValue = comparedValue;
        }

        public MeasValue transform(MeasValue value) {
            final Double v = value.asDouble();
            if (v != null) {
                return new MeasValue.MeasBoolValue(v >= comparedValue);
            } else {
                return new MeasValue.MeasBoolValue(false);
            }
        }
    }

    public static class LessThan implements MeasTransform {
        private final double comparedValue;

        public LessThan(double comparedValue) {
            this.comparedValue = comparedValue;
        }

        public MeasValue transform(MeasValue value) {
            final Double v = value.asDouble();
            if (v != null) {
                return new MeasValue.MeasBoolValue(v < comparedValue);
            } else {
                return new MeasValue.MeasBoolValue(false);
            }
        }
    }

    public static class LessThanOrEqual implements MeasTransform {
        private final double comparedValue;

        public LessThanOrEqual(double comparedValue) {
            this.comparedValue = comparedValue;
        }

        public MeasValue transform(MeasValue value) {
            final Double v = value.asDouble();
            if (v != null) {
                return new MeasValue.MeasBoolValue(v <= comparedValue);
            } else {
                return new MeasValue.MeasBoolValue(false);
            }
        }
    }
}
