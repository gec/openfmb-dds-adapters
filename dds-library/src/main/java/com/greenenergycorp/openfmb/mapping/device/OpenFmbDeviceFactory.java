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

import com.greenenergycorp.openfmb.dds.DdsParticipant;
import com.greenenergycorp.openfmb.dds.handle.*;
import com.rti.dds.publication.DataWriter;
import com.rti.dds.publication.Publisher;
import com.rti.dds.subscription.DataReader;
import com.rti.dds.subscription.Subscriber;
import com.rti.dds.topic.Topic;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryEventProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryReadingProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.loadmodule.LoadReadingProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserEventProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserReadingProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.resourcemodule.ResourceReadingProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.solarmodule.SolarEventProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.solarmodule.SolarReadingProfileDataWriter;

import java.io.IOException;

public class OpenFmbDeviceFactory {

    private final DdsParticipant participant;
    private final Publisher publisher;
    private final Subscriber subscriber;

    private Topic recloserEventProfileTopic;
    private Topic recloserReaderProfileTopic;
    private Topic recloserControlProfileTopic;
    private Topic batteryEventProfileTopic;
    private Topic batteryReaderProfileTopic;
    private Topic batteryControlProfileTopic;

    private Topic solarReaderProfileTopic;
    private Topic solarEventProfileTopic;
    private Topic loadReaderProfileTopic;
    private Topic resourceReaderProfileTopic;

    public OpenFmbDeviceFactory(DdsParticipant participant, Publisher publisher, Subscriber subscriber) {
        this.participant = participant;
        this.publisher = publisher;
        this.subscriber = subscriber;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Subscriber getSubscriber() {
        return subscriber;
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

        if (batteryEventProfileTopic == null) {
            handle.registerType(participant.getParticipant());
            batteryEventProfileTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, batteryEventProfileTopic);

        BatteryEventProfileDataWriter writer = (BatteryEventProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create BatteryEventProfileDataWriter");
        }

        return writer;
    }

    public BatteryReadingProfileDataWriter getBatteryReadProfileWriter() throws IOException {

        final BatteryReadingProfileHandle handle = new BatteryReadingProfileHandle();

        if (batteryReaderProfileTopic == null) {
            handle.registerType(participant.getParticipant());
            batteryReaderProfileTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, batteryReaderProfileTopic);

        BatteryReadingProfileDataWriter writer = (BatteryReadingProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create BatteryReadingProfileDataWriter");
        }

        return writer;
    }

    public DataReader getBatteryControlProfileReader() throws IOException {

        final BatteryControlProfileHandle handle = new BatteryControlProfileHandle();

        if (batteryControlProfileTopic == null) {
            handle.registerType(participant.getParticipant());
            batteryControlProfileTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        return participant.createReader(subscriber, batteryControlProfileTopic);
    }

    public ResourceReadingProfileDataWriter getResourceReadProfileWriter() throws IOException {

        final ResourceReadingProfileHandle handle = new ResourceReadingProfileHandle();

        if (resourceReaderProfileTopic == null) {
            handle.registerType(participant.getParticipant());
            resourceReaderProfileTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, resourceReaderProfileTopic);

        ResourceReadingProfileDataWriter writer = (ResourceReadingProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create ResourceReadingProfileDataWriter");
        }

        return writer;
    }

    public LoadReadingProfileDataWriter getLoadReadProfileWriter() throws IOException {

        final LoadReadingProfileHandle handle = new LoadReadingProfileHandle();

        if (loadReaderProfileTopic == null) {
            handle.registerType(participant.getParticipant());
            loadReaderProfileTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, loadReaderProfileTopic);

        LoadReadingProfileDataWriter writer = (LoadReadingProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create LoadReadingProfileDataWriter");
        }

        return writer;
    }

    public SolarReadingProfileDataWriter getSolarReadProfileWriter() throws IOException {

        final SolarReadingProfileHandle handle = new SolarReadingProfileHandle();

        if (solarReaderProfileTopic == null) {
            handle.registerType(participant.getParticipant());
            solarReaderProfileTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, solarReaderProfileTopic);

        SolarReadingProfileDataWriter writer = (SolarReadingProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create SolarReadingProfileDataWriter");
        }

        return writer;
    }


    public SolarEventProfileDataWriter getSolarEventProfileWriter() throws IOException {

        final SolarEventProfileHandle handle = new SolarEventProfileHandle();

        if (solarEventProfileTopic == null) {
            handle.registerType(participant.getParticipant());
            solarEventProfileTopic = participant.registerTopic(handle.typeName(), handle.typeName(), true);
        }

        final DataWriter parentWriter = participant.createWriter(publisher, solarReaderProfileTopic);

        SolarEventProfileDataWriter writer = (SolarEventProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create SolarEventProfileDataWriter");
        }

        return writer;
    }

}
