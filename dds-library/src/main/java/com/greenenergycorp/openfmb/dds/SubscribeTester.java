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

import com.rti.dds.subscription.DataReader;
import com.rti.dds.subscription.Subscriber;
import com.rti.dds.topic.Topic;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserEventModule;
import com.greenenergycorp.openfmb.dds.handle.RecloserEventModuleHandle;

public class SubscribeTester {

    public static void main(String[] args) throws Exception {

        final boolean reliable = true;

        //final String topicName = "blah";

        DdsParticipant participant = DdsParticipant.create();

        /*final String typeName = RecloserStatusTypeSupport.get_type_name();

        RecloserStatusTypeSupport.register_type(participant.getParticipant(), typeName);*/

        final RecloserEventModuleHandle recloserStatusHandle = new RecloserEventModuleHandle();

        recloserStatusHandle.registerType(participant.getParticipant());

        final Topic messageTopic = participant.registerTopic(recloserStatusHandle.typeName(), recloserStatusHandle.typeName(), reliable);

        final Subscriber subscriber = participant.createSubscriber();

        final DataReader reader = participant.createReader(subscriber, messageTopic);

        final TypedTopicSubscription<RecloserEventModule> recloserStatusSub =
                new TypedTopicSubscription<RecloserEventModule>(reader, recloserStatusHandle);

        recloserStatusSub.subscribe(new SubscriptionHandler<RecloserEventModule>() {
            public void handle(ReadResult<RecloserEventModule> readResult) {
                System.out.println("Got read: " + readResult.getResults().size());
            }
        });

        System.in.read();

        participant.shutdown();
    }
}
