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
import com.greenenergycorp.openfmb.dds.TypeHandle;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OpenFmbDeviceFactory {

    private final DdsParticipant participant;
    private final Publisher publisher;
    private final Subscriber subscriber;

    private final Map<String, Topic> topicMap = new HashMap<String, Topic>();
    private final Set<String> registeredTypes = new HashSet<String>();

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

    private <T> Topic getTopic(String topic, TypeHandle<T> handle) throws IOException {
        if (topicMap.containsKey(topic)) {
            return topicMap.get(topic);
        } else {
            if (!registeredTypes.contains(handle.typeName())) {
                handle.registerType(participant.getParticipant());
                registeredTypes.add(handle.typeName());
            }

            final Topic registered = participant.registerTopic(topic, handle.typeName(), true);
            topicMap.put(topic, registered);
            return registered;
        }
    }

    private <T> DataWriter getDataWriter(String topicName, TypeHandle<T> handle) throws IOException {

        final Topic topic = getTopic(topicName, handle);

        return participant.createWriter(publisher, topic);
    }

    public RecloserEventProfileDataWriter getRecloserEventProfileWriter(String topicName) throws IOException {

        final RecloserEventProfileHandle handle = new RecloserEventProfileHandle();

        final DataWriter parentWriter = getDataWriter(topicName, handle);

        RecloserEventProfileDataWriter writer = (RecloserEventProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create RecloserEventProfileDataWriter");
        }

        return writer;
    }

    public RecloserReadingProfileDataWriter getRecloserReadProfileWriter(String topicName) throws IOException {

        final RecloserReadingProfileHandle handle = new RecloserReadingProfileHandle();

        final DataWriter parentWriter = getDataWriter(topicName, handle);

        RecloserReadingProfileDataWriter writer = (RecloserReadingProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create RecloserReadingProfileDataWriter");
        }

        return writer;
    }

    public DataReader getRecloserControlProfileReader(String topicName) throws IOException {

        final RecloserControlProfileHandle handle = new RecloserControlProfileHandle();

        final Topic topic = getTopic(topicName, handle);

        return participant.createReader(subscriber, topic);
    }

    public BatteryEventProfileDataWriter getBatteryEventProfileWriter(String topicName) throws IOException {

        final BatteryEventProfileHandle handle = new BatteryEventProfileHandle();

        final DataWriter parentWriter = getDataWriter(topicName, handle);

        BatteryEventProfileDataWriter writer = (BatteryEventProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create BatteryEventProfileDataWriter");
        }

        return writer;
    }

    public BatteryReadingProfileDataWriter getBatteryReadProfileWriter(String topicName) throws IOException {

        final BatteryReadingProfileHandle handle = new BatteryReadingProfileHandle();

        final DataWriter parentWriter = getDataWriter(topicName, handle);

        BatteryReadingProfileDataWriter writer = (BatteryReadingProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create BatteryReadingProfileDataWriter");
        }

        return writer;
    }

    public DataReader getBatteryControlProfileReader(String topicName) throws IOException {

        final BatteryControlProfileHandle handle = new BatteryControlProfileHandle();

        final Topic topic = getTopic(topicName, handle);

        return participant.createReader(subscriber, topic);
    }

    public ResourceReadingProfileDataWriter getResourceReadProfileWriter(String topicName) throws IOException {

        final ResourceReadingProfileHandle handle = new ResourceReadingProfileHandle();

        final DataWriter parentWriter = getDataWriter(topicName, handle);

        ResourceReadingProfileDataWriter writer = (ResourceReadingProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create ResourceReadingProfileDataWriter");
        }

        return writer;
    }

    public LoadReadingProfileDataWriter getLoadReadProfileWriter(String topicName) throws IOException {

        final LoadReadingProfileHandle handle = new LoadReadingProfileHandle();

        final DataWriter parentWriter = getDataWriter(topicName, handle);

        LoadReadingProfileDataWriter writer = (LoadReadingProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create LoadReadingProfileDataWriter");
        }

        return writer;
    }

    public SolarReadingProfileDataWriter getSolarReadProfileWriter(String topicName) throws IOException {

        final SolarReadingProfileHandle handle = new SolarReadingProfileHandle();

        final DataWriter parentWriter = getDataWriter(topicName, handle);

        SolarReadingProfileDataWriter writer = (SolarReadingProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create SolarReadingProfileDataWriter");
        }

        return writer;
    }


    public SolarEventProfileDataWriter getSolarEventProfileWriter(String topicName) throws IOException {

        final SolarEventProfileHandle handle = new SolarEventProfileHandle();

        final DataWriter parentWriter = getDataWriter(topicName, handle);

        SolarEventProfileDataWriter writer = (SolarEventProfileDataWriter) parentWriter;
        if (writer == null) {
            throw new IOException("Could not create SolarEventProfileDataWriter");
        }

        return writer;
    }

}
