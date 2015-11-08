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

import com.greenenergycorp.openfmb.dds.mapping.xml.Transform;
import com.greenenergycorp.openfmb.mapping.MeasValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Loads a sequence of transformations from an XML Transform element.
 */
public class TransformXmlLoader {

    public static MeasTransform load(final Transform xml) {
        final List<MeasTransform> results = new ArrayList<MeasTransform>();

        if (xml.getElements() != null) {
            for (Object elem: xml.getElements()) {

                if (elem instanceof Transform.Scale) {
                    final Transform.Scale entry = (Transform.Scale)elem;
                    if (entry.getMultiplier() != null || entry.getOffset() != null) {
                        results.add(new TransformChain.Scale(entry.getMultiplier(), entry.getOffset()));
                    } else {
                        throw new IllegalArgumentException("Scale transform must have one or both of multiplier or offset");
                    }
                } else if (elem instanceof Transform.Match) {
                    final Transform.Match entry = (Transform.Match)elem;
                    if (entry.getCase() != null && entry.getCase().size() > 0) {

                        MeasValue defaultValue;
                        if (entry.getDefaultBooleanValue() != null) {
                            defaultValue = new MeasValue.MeasBoolValue(entry.getDefaultBooleanValue());
                        } else if (entry.getDefaultIntegerValue() != null) {
                            defaultValue = new MeasValue.MeasIntValue(entry.getDefaultIntegerValue());
                        } else if (entry.getDefaultStringValue() != null) {
                            defaultValue = new MeasValue.MeasStringValue(entry.getDefaultStringValue());
                        } else {
                            throw new IllegalArgumentException("Match transform must include default value");
                        }

                        final ArrayList<TransformChain.Match.MatchPair> matchPairs = new ArrayList<TransformChain.Match.MatchPair>();

                        for (Transform.Match.Case xmlCase: entry.getCase()) {

                            MeasValue matchValue;
                            if (xmlCase.getMatchBooleanValue() != null) {
                                matchValue = new MeasValue.MeasBoolValue(xmlCase.getMatchBooleanValue());
                            } else if (xmlCase.getMatchIntegerValue() != null) {
                                matchValue = new MeasValue.MeasIntValue(xmlCase.getMatchIntegerValue());
                            } else if (xmlCase.getMatchStringValue() != null) {
                                matchValue = new MeasValue.MeasStringValue(xmlCase.getMatchStringValue());
                            } else {
                                throw new IllegalArgumentException("Match case must include a value to match");
                            }

                            MeasValue resultValue;
                            if (xmlCase.getToBooleanValue() != null) {
                                resultValue = new MeasValue.MeasBoolValue(xmlCase.getToBooleanValue());
                            } else if (xmlCase.getToIntegerValue() != null) {
                                resultValue = new MeasValue.MeasIntValue(xmlCase.getToIntegerValue());
                            } else if (xmlCase.getToStringValue() != null) {
                                resultValue = new MeasValue.MeasStringValue(xmlCase.getToStringValue());
                            } else {
                                throw new IllegalArgumentException("Match case must include a result value");
                            }

                            matchPairs.add(new TransformChain.Match.MatchPair(matchValue, resultValue));
                        }

                        results.add(new TransformChain.Match(matchPairs, defaultValue));

                    } else {
                        throw new IllegalArgumentException("Match transform must include at least one case");
                    }

                } else if (elem instanceof Transform.GreaterThan) {
                    final Transform.GreaterThan entry = (Transform.GreaterThan)elem;

                    if (entry.getValue() != null) {
                        results.add(new TransformChain.GreaterThan(entry.getValue()));
                    } else {
                        throw new IllegalArgumentException("GreaterThan transform must include value");
                    }
                } else if (elem instanceof Transform.GreaterThanOrEqual) {
                    final Transform.GreaterThanOrEqual entry = (Transform.GreaterThanOrEqual)elem;

                    if (entry.getValue() != null) {
                        results.add(new TransformChain.GreaterThanOrEqual(entry.getValue()));
                    } else {
                        throw new IllegalArgumentException("GreaterThanOrEqual transform must include value");
                    }
                } else if (elem instanceof Transform.LessThan) {
                    final Transform.LessThan entry = (Transform.LessThan)elem;

                    if (entry.getValue() != null) {
                        results.add(new TransformChain.LessThan(entry.getValue()));
                    } else {
                        throw new IllegalArgumentException("LessThan transform must include value");
                    }
                } else if (elem instanceof Transform.LessThanOrEqual) {
                    final Transform.LessThanOrEqual entry = (Transform.LessThanOrEqual)elem;

                    if (entry.getValue() != null) {
                        results.add(new TransformChain.LessThanOrEqual(entry.getValue()));
                    } else {
                        throw new IllegalArgumentException("LessThanOrEqual transform must include value");
                    }
                } else {

                    throw new IllegalArgumentException("Did not recognize transform step");
                }
            }
        }

        return new TransformChain(results);
    }
}
