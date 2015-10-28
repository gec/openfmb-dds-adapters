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

import com.rti.dds.infrastructure.InstanceHandle_t;
import com.rti.dds.publication.DataWriter;
import com.rti.dds.publication.Publisher;
import com.rti.dds.topic.Topic;
import org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.*;
import com.greenenergycorp.openfmb.dds.handle.RecloserEventModuleHandle;

import java.io.IOException;
import java.util.UUID;

public class Tester {

    public static void main(String[] args) throws Exception {

        final boolean reliable = true;

        DdsParticipant participant = DdsParticipant.create();

        final RecloserEventModuleHandle recloserStatusHandle = new RecloserEventModuleHandle();

        recloserStatusHandle.registerType(participant.getParticipant());

        final Topic messageTopic = participant.registerTopic(recloserStatusHandle.typeName(), recloserStatusHandle.typeName(), reliable);

        final Publisher publisher = participant.createPublisher();

        final DataWriter parentWriter = participant.createWriter(publisher, messageTopic);

        RecloserEventModuleDataWriter writer = (RecloserEventModuleDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create MarkerDataWriter");
        }

        final String uuid = UUID.randomUUID().toString();

        while (true) {

            final RecloserEventModule recloserEventModule = new RecloserEventModule();

            final long now = System.currentTimeMillis();

            recloserEventModule.logicalDeviceID = uuid;
            recloserEventModule.timestamp = now;

            final Recloser recloser = new Recloser();
            recloser.mRID = uuid;
            recloser.name = "Recloser01";
            recloser.description = "";
            recloser.normalOpen = false;

            recloserEventModule.recloser = recloser;

            final RecloserStatus recloserStatus = new RecloserStatus();

            recloserStatus.isBlocked = true;

            recloserStatus.switchStatus = SwitchStatusKind.Closed;
            recloserStatus.timestamp = now;
            recloserStatus.value = "";

            final HexBinary16Type quality = new HexBinary16Type();
            quality.data[0] = 0;
            quality.data[1] = 0;

            recloserStatus.qualityFlag = quality;

            recloserEventModule.recloserStatus = recloserStatus;

            writer.write(recloserEventModule, InstanceHandle_t.HANDLE_NIL);

            Thread.sleep(2000);
        }

        //participant.shutdown();
    }
}
