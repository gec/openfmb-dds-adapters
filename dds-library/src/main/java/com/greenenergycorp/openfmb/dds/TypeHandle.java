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
package com.greenenergycorp.openfmb.dds;

import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.subscription.DataReader;

/**
 *  Generic interface for users perform common DDS actions without re-writing code for every type.
 *
 * @param <T> DDS data type
 */
public interface TypeHandle<T> {

    /**
     * @return Type name from the type support's get_type_name() method.
     */
    String typeName();

    /**
     * Register type with a DDS domain participant.
     *
     * @param participant DDS domain participant.
     */
    void registerType(DomainParticipant participant);

    /**
     *  Generic method to call take() on a DDS data reader.
     *
     * @param parentReader DataReader for the DDS data type.
     * @param maxSamples DDS "max_samples" parameter, see DDS documentation.
     * @param sampleStates DDS "sample_states" parameter, see DDS documentation.
     * @param viewStates DDS "view_states" parameter, see DDS documentation.
     * @param instanceStates DDS "instance_states" parameter, see DDS documentation.
     * @return Result containing DDS data type and sample info.
     */
    ReadResult<T> take(DataReader parentReader, int maxSamples, int sampleStates, int viewStates, int instanceStates);
}
