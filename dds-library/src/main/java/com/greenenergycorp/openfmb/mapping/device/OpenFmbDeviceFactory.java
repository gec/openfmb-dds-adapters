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
package com.greenenergycorp.openfmb.mapping.device;

import com.greenenergycorp.openfmb.dds.handle.*;
import com.rti.dds.publication.DataWriter;
import com.rti.dds.publication.Publisher;
import com.rti.dds.subscription.DataReader;
import com.rti.dds.subscription.Subscriber;
import com.rti.dds.topic.Topic;
import com.greenenergycorp.openfmb.dds.DdsParticipant;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryEventProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryReadingProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserEventProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserReadingProfileDataWriter;

import java.io.IOException;

public class OpenFmbDeviceFactory {

    private final DdsParticipant participant;
    private final Publisher publisher;
    private final Subscriber subscriber;

    private Topic recloserEventProfileTopic;
    private Topic recloserReaderProfileTopic;
    private Topic recloserControlProfileTopic;

    public OpenFmbDeviceFactory(DdsParticipant participant, Publisher publisher, Subscriber subscriber) {
        this.participant = participant;
        this.publisher = publisher;
        this.subscriber = subscriber;
    }

    public RecloserEventProfileDataWriter getRecloserEventProfileWriter() throws IOException {

        final RecloserEventProfileHandle handle = new RecloserEventProfileHandle();

        if (recloserEventProfileTopic == null) {
            handle.registerType(participant.getParticipant());
            recloserEventProfileTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, recloserEventProfileTopic);

        RecloserEventProfileDataWriter writer = (RecloserEventProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create RecloserEventProfileDataWriter");
        }

        return writer;
    }

    public RecloserReadingProfileDataWriter getRecloserReadProfileWriter() throws IOException {

        final RecloserReadingProfileHandle handle = new RecloserReadingProfileHandle();

        if (recloserReaderProfileTopic == null) {
            handle.registerType(participant.getParticipant());
            recloserReaderProfileTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, recloserReaderProfileTopic);

        RecloserReadingProfileDataWriter writer = (RecloserReadingProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create RecloserReadingProfileDataWriter");
        }

        return writer;
    }

    public DataReader getRecloserControlProfileReader() throws IOException {

        final RecloserControlProfileHandle handle = new RecloserControlProfileHandle();

        if (recloserControlProfileTopic == null) {
            handle.registerType(participant.getParticipant());
            recloserControlProfileTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        return participant.createReader(subscriber, recloserControlProfileTopic);
    }

    public BatteryEventProfileDataWriter getBatteryEventProfileWriter() throws IOException {

        final BatteryEventProfileHandle handle = new BatteryEventProfileHandle();

        if (recloserEventProfileTopic == null) {
            handle.registerType(participant.getParticipant());
            recloserEventProfileTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, recloserEventProfileTopic);

        BatteryEventProfileDataWriter writer = (BatteryEventProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create BatteryEventProfileDataWriter");
        }

        return writer;
    }

    public BatteryReadingProfileDataWriter getBatteryReadProfileWriter() throws IOException {

        final BatteryReadingProfileHandle handle = new BatteryReadingProfileHandle();

        if (recloserReaderProfileTopic == null) {
            handle.registerType(participant.getParticipant());
            recloserReaderProfileTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, recloserReaderProfileTopic);

        BatteryReadingProfileDataWriter writer = (BatteryReadingProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create BatteryReadingProfileDataWriter");
        }

        return writer;
    }

    public DataReader getBatteryControlProfileReader() throws IOException {

        final BatteryControlProfileHandle handle = new BatteryControlProfileHandle();

        if (recloserControlProfileTopic == null) {
            handle.registerType(participant.getParticipant());
            recloserControlProfileTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        return participant.createReader(subscriber, recloserControlProfileTopic);
    }

}
