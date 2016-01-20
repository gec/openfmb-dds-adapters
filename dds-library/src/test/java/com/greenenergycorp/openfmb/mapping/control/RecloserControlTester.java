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
package com.greenenergycorp.openfmb.mapping.control;

import com.greenenergycorp.openfmb.dds.DdsParticipant;
import com.greenenergycorp.openfmb.dds.handle.RecloserControlProfileHandle;
import com.rti.dds.infrastructure.InstanceHandle_t;
import com.rti.dds.publication.DataWriter;
import com.rti.dds.publication.Publisher;
import com.rti.dds.topic.Topic;
import org.openfmb.model.dds.rti.openfmb.commonmodule.*;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.Recloser;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserControl;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserControlProfile;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserControlProfileDataWriter;

import java.io.IOException;

public class RecloserControlTester {


    public static void main(String[] args) throws Exception {

        final boolean reliable = false;

        DdsParticipant participant = DdsParticipant.create();

        final RecloserControlProfileHandle recloserControlHandle = new RecloserControlProfileHandle();

        recloserControlHandle.registerType(participant.getParticipant());

        final Topic messageTopic = participant.registerTopic(recloserControlHandle.typeName(), recloserControlHandle.typeName(), reliable);

        final Publisher publisher = participant.createPublisher();

        final DataWriter parentWriter = participant.createWriter(publisher, messageTopic);

        RecloserControlProfileDataWriter writer = (RecloserControlProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create MarkerDataWriter");
        }

        //final String uuid = UUID.randomUUID().toString();
        final String uuid = "uuid01";

        while (true) {

            final RecloserControlProfile recloserControlProfile = new RecloserControlProfile();

            final long now = System.currentTimeMillis();

            recloserControlProfile.logicalDeviceID = "Recloser01";
            recloserControlProfile.timestamp = now;

            final Recloser recloser = new Recloser();
            recloser.mRID = uuid;
            recloser.name =
            recloser.description = "";
            recloser.normalOpen = false;

            recloserControlProfile.recloser = recloser;

            final EndDeviceControlType endDeviceControl = new EndDeviceControlType();
            endDeviceControl.action = "action1";
            endDeviceControl.type = "type1";

            final SetPoint setPoint = new SetPoint();
            setPoint.controlType = "type1";
            setPoint.unit = UnitSymbolKind.Amp;
            setPoint.multiplier = UnitMultiplierKind.milli;
            setPoint.value = 100.5f;

            final SequenceOfEndDeviceControlSetPoints setPoints = new SequenceOfEndDeviceControlSetPoints();
            setPoints.userData.add(setPoint);

            final DateTimeInterval dateTimeInterval = new DateTimeInterval();
            dateTimeInterval.start = now;
            dateTimeInterval.end = now;

            final RecloserControl recloserControl = new RecloserControl();

            recloserControl.issueID = "issueID";
            recloserControl.name = "name";
            recloserControl.endDeviceControlType = endDeviceControl;
            recloserControl.scheduledInterval = dateTimeInterval;
            recloserControl.setPoints = setPoints;

            recloserControlProfile.recloserControl = recloserControl;

            writer.write(recloserControlProfile, InstanceHandle_t.HANDLE_NIL);

            Thread.sleep(5000);
        }
    }
}
