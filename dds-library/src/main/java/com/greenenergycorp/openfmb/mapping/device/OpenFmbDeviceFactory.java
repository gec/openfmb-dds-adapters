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
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryEventModuleDataWriter;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryReadingModuleDataWriter;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserEventModuleDataWriter;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserReadingModuleDataWriter;

import java.io.IOException;

public class OpenFmbDeviceFactory {

    private final DdsParticipant participant;
    private final Publisher publisher;
    private final Subscriber subscriber;

    private Topic recloserEventModuleTopic;
    private Topic recloserReaderModuleTopic;
    private Topic recloserControlModuleTopic;

    public OpenFmbDeviceFactory(DdsParticipant participant, Publisher publisher, Subscriber subscriber) {
        this.participant = participant;
        this.publisher = publisher;
        this.subscriber = subscriber;
    }

    public RecloserEventModuleDataWriter getRecloserEventModuleWriter() throws IOException {

        final RecloserEventModuleHandle handle = new RecloserEventModuleHandle();

        if (recloserEventModuleTopic == null) {
            handle.registerType(participant.getParticipant());
            recloserEventModuleTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, recloserEventModuleTopic);

        RecloserEventModuleDataWriter writer = (RecloserEventModuleDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create RecloserEventModuleDataWriter");
        }

        return writer;
    }

    public RecloserReadingModuleDataWriter getRecloserReadModuleWriter() throws IOException {

        final RecloserReadingModuleHandle handle = new RecloserReadingModuleHandle();

        if (recloserReaderModuleTopic == null) {
            handle.registerType(participant.getParticipant());
            recloserReaderModuleTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, recloserReaderModuleTopic);

        RecloserReadingModuleDataWriter writer = (RecloserReadingModuleDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create RecloserReadingModuleDataWriter");
        }

        return writer;
    }

    public DataReader getRecloserControlModuleReader() throws IOException {

        final RecloserControlModuleHandle handle = new RecloserControlModuleHandle();

        if (recloserControlModuleTopic == null) {
            handle.registerType(participant.getParticipant());
            recloserControlModuleTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        return participant.createReader(subscriber, recloserControlModuleTopic);
    }

    public BatteryEventModuleDataWriter getBatteryEventModuleWriter() throws IOException {

        final BatteryEventModuleHandle handle = new BatteryEventModuleHandle();

        if (recloserEventModuleTopic == null) {
            handle.registerType(participant.getParticipant());
            recloserEventModuleTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, recloserEventModuleTopic);

        BatteryEventModuleDataWriter writer = (BatteryEventModuleDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create BatteryEventModuleDataWriter");
        }

        return writer;
    }

    public BatteryReadingModuleDataWriter getBatteryReadModuleWriter() throws IOException {

        final BatteryReadingModuleHandle handle = new BatteryReadingModuleHandle();

        if (recloserReaderModuleTopic == null) {
            handle.registerType(participant.getParticipant());
            recloserReaderModuleTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, recloserReaderModuleTopic);

        BatteryReadingModuleDataWriter writer = (BatteryReadingModuleDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create BatteryReadingModuleDataWriter");
        }

        return writer;
    }

    public DataReader getBatteryControlModuleReader() throws IOException {

        final BatteryControlModuleHandle handle = new BatteryControlModuleHandle();

        if (recloserControlModuleTopic == null) {
            handle.registerType(participant.getParticipant());
            recloserControlModuleTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        return participant.createReader(subscriber, recloserControlModuleTopic);
    }

}
