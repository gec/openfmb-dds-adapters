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
import com.rti.dds.domain.DomainParticipantFactory;
import com.rti.dds.infrastructure.DurabilityQosPolicyKind;
import com.rti.dds.infrastructure.HistoryQosPolicyKind;
import com.rti.dds.infrastructure.ReliabilityQosPolicyKind;
import com.rti.dds.infrastructure.StatusKind;
import com.rti.dds.publication.DataWriter;
import com.rti.dds.publication.DataWriterQos;
import com.rti.dds.publication.Publisher;
import com.rti.dds.subscription.DataReader;
import com.rti.dds.subscription.Subscriber;
import com.rti.dds.topic.Topic;
import com.rti.dds.topic.TopicQos;

import java.io.IOException;

/**
 * Wrapper for OpenSplice DDS that contains most of the common initialization
 */
public class DdsParticipant {

    private final DomainParticipant participant;

    public DdsParticipant(DomainParticipant participant) {
        this.participant = participant;
    }

    /**
     * Factory that handles static initialization of DomainParticipant
     *
     * @return participant instance
     * @throws IOException
     */
    public static DdsParticipant create() throws IOException {

        DomainParticipantFactory dpf = DomainParticipantFactory.get_instance();

        if (dpf == null) {
            throw new IOException("Could not create DomainParticipantFactory");
        }

        DomainParticipant participant =
                dpf.create_participant(0, DomainParticipantFactory.PARTICIPANT_QOS_DEFAULT, null, StatusKind.STATUS_MASK_NONE);

        if (participant == null) {
            throw new IOException("Could not create DomainParticipantFactory");
        }

        return new DdsParticipant(participant);
    }

    public DomainParticipant getParticipant() {
        return participant;
    }

    /**
     * Registers topic with QoS for test cases
     *
     * @param name     topic name
     * @param typeName type for topic
     * @param reliable reliable (true) or best effort (false) QoS
     * @return DDS topic object
     * @throws IOException
     */
    public Topic registerTopic(final String name, final String typeName, final boolean reliable) throws IOException {
        TopicQos reliableTopicQos = new TopicQos();

        participant.get_default_topic_qos(reliableTopicQos);

        if (reliable) {
            reliableTopicQos.reliability.kind = ReliabilityQosPolicyKind.RELIABLE_RELIABILITY_QOS;
        } else {
            reliableTopicQos.reliability.kind = ReliabilityQosPolicyKind.BEST_EFFORT_RELIABILITY_QOS;
        }

        reliableTopicQos.history.kind = HistoryQosPolicyKind.KEEP_ALL_HISTORY_QOS;

        reliableTopicQos.resource_limits.max_samples = 50000;

        reliableTopicQos.durability.kind = DurabilityQosPolicyKind.VOLATILE_DURABILITY_QOS;

        participant.set_default_topic_qos(reliableTopicQos);

        Topic topic = participant.create_topic(name, typeName, reliableTopicQos, null, StatusKind.STATUS_MASK_NONE);

        if (topic == null) {
            throw new IOException("Could not create Topic");
        }

        return topic;
    }

    /**
     * Create publisher using default QoS
     *
     * @return DDS publisher
     * @throws IOException
     */
    public Publisher createPublisher() throws IOException {

        final Publisher publisher = participant.create_publisher(DomainParticipant.PUBLISHER_QOS_DEFAULT, null, StatusKind.STATUS_MASK_NONE);

        if (publisher == null) {
            throw new IOException("Could not create Publisher");
        }
        return publisher;
    }

    /**
     * Create abstract data writer and check for errors
     *
     * @param publisher Publisher to build data writer from
     * @param topic     Topic to write to
     * @return DDS DataWriter
     * @throws IOException
     */
    public DataWriter createWriter(final Publisher publisher, final Topic topic) throws IOException {

        DataWriterQos dataWriterQos;

        if (System.getProperty("dds.batch") != null) {

            int batchMicros = Integer.parseInt(System.getProperty("dds.batch"));

            dataWriterQos = new DataWriterQos();

            participant.get_default_datawriter_qos(dataWriterQos);

            dataWriterQos.batch.enable = true;

            dataWriterQos.batch.max_flush_delay.sec = 0; //= new Duration_t(0, 5000000);
            dataWriterQos.batch.max_flush_delay.nanosec = batchMicros * 1000;

            if (System.getProperty("dds.batch.data") != null) {
                dataWriterQos.batch.max_data_bytes = Integer.parseInt(System.getProperty("dds.batch.data"));
            }
            if (System.getProperty("dds.batch.samples") != null) {
                dataWriterQos.batch.max_samples = Integer.parseInt(System.getProperty("dds.batch.samples"));
            }

            dataWriterQos.history.kind = HistoryQosPolicyKind.KEEP_ALL_HISTORY_QOS;

            System.err.println("Flush delay: " + dataWriterQos.batch.max_flush_delay);

        } else {

            dataWriterQos = Publisher.DATAWRITER_QOS_USE_TOPIC_QOS;

        }


        final DataWriter parentWriter = publisher.create_datawriter(topic, dataWriterQos, null, StatusKind.STATUS_MASK_NONE);

        if (parentWriter == null) {
            throw new IOException("Could not create DataWriter");
        }

        return parentWriter;
    }

    /**
     * Create subscriber with default QoS
     *
     * @return DDS Subscriber
     * @throws IOException
     */
    public Subscriber createSubscriber() throws IOException {

        final Subscriber subscriber = participant.create_subscriber(DomainParticipant.SUBSCRIBER_QOS_DEFAULT, null, StatusKind.STATUS_MASK_NONE);

        if (subscriber == null) {
            throw new IOException("Could not create Subscriber");
        }

        return subscriber;
    }

    /**
     * Creates abstract DataReader for subscriber and topic
     *
     * @param subscriber DDS subscriber to attach reader
     * @param topic      Topic to read from
     * @return DDS DataReader
     * @throws IOException
     */
    public DataReader createReader(final Subscriber subscriber, final Topic topic) throws IOException {
        final DataReader parentReader =
                subscriber.create_datareader(topic, Subscriber.DATAREADER_QOS_USE_TOPIC_QOS, null, StatusKind.STATUS_MASK_NONE);

        if (parentReader == null) {
            throw new IOException("Could not create DataReader");
        }

        return parentReader;
    }

    /**
     * Delete all entities, letting peers know you are disconnecting
     */
    public void shutdown() {
        participant.delete_contained_entities();
    }

}
