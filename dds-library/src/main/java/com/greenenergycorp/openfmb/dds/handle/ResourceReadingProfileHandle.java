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
package com.greenenergycorp.openfmb.dds.handle;

import com.greenenergycorp.openfmb.dds.ReadResult;
import com.greenenergycorp.openfmb.dds.TypeHandle;
import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.subscription.DataReader;
import com.rti.dds.subscription.SampleInfo;
import com.rti.dds.subscription.SampleInfoSeq;
import org.openfmb.model.dds.rti.openfmb.resourcemodule.ResourceReadingProfile;
import org.openfmb.model.dds.rti.openfmb.resourcemodule.ResourceReadingProfileDataReader;
import org.openfmb.model.dds.rti.openfmb.resourcemodule.ResourceReadingProfileSeq;
import org.openfmb.model.dds.rti.openfmb.resourcemodule.ResourceReadingProfileTypeSupport;

import java.util.ArrayList;

public class ResourceReadingProfileHandle implements TypeHandle<ResourceReadingProfile> {

    public String typeName() {
        return ResourceReadingProfileTypeSupport.get_type_name();
    }

    public void registerType(DomainParticipant participant) {
        ResourceReadingProfileTypeSupport.register_type(participant, typeName());
    }

    public ReadResult<ResourceReadingProfile> take(DataReader parentReader, int maxSamples, int sampleStates, int viewStates, int instanceStates) {
        final ResourceReadingProfileDataReader reader = (ResourceReadingProfileDataReader) parentReader;

        final ResourceReadingProfileSeq structSeq = new ResourceReadingProfileSeq();
        final SampleInfoSeq infoSeq = new SampleInfoSeq();

        reader.take(structSeq, infoSeq, maxSamples, sampleStates, viewStates, instanceStates);

        final ArrayList<ResourceReadingProfile> recloserStatuses = new ArrayList<ResourceReadingProfile>(structSeq.size());
        for (int i = 0; i < structSeq.size(); i++) {
            recloserStatuses.add((ResourceReadingProfile) structSeq.get(i));
        }

        final ArrayList<SampleInfo> sampleInfos = new ArrayList<SampleInfo>(infoSeq.size());
        for (int i = 0; i < infoSeq.size(); i++) {
            sampleInfos.add((SampleInfo) infoSeq.get(i));
        }

        reader.return_loan(structSeq, infoSeq);

        return new ReadResult<ResourceReadingProfile>(recloserStatuses, sampleInfos);
    }
}
