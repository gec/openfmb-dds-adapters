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

import com.greenenergycorp.openfmb.dds.ReadResult;
import com.greenenergycorp.openfmb.dds.SubscriptionHandler;
import com.greenenergycorp.openfmb.dds.TypedTopicSubscription;
import com.greenenergycorp.openfmb.dds.handle.RecloserControlProfileHandle;
import com.greenenergycorp.openfmb.mapping.Control;
import com.greenenergycorp.openfmb.mapping.ControlAdapter;
import com.greenenergycorp.openfmb.mapping.ControlHandler;
import com.greenenergycorp.openfmb.mapping.ControlMapping;
import com.rti.dds.subscription.DataReader;
import org.openfmb.model.dds.rti.openfmb.commonmodule.SetPoint;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserControlProfile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class RecloserControlProfileAdapter implements ControlAdapter {
    private final TypedTopicSubscription<RecloserControlProfile> subscription;
    private final Map<String, String> deviceIdToAdapterName;
    private final ControlMapping handlerMap;

    public RecloserControlProfileAdapter(TypedTopicSubscription<RecloserControlProfile> subscription, Map<String, String> deviceIdToAdapterName, ControlMapping handlerMap) {
        this.subscription = subscription;
        this.deviceIdToAdapterName = deviceIdToAdapterName;
        this.handlerMap = handlerMap;
    }

    public static RecloserControlProfileAdapter build(final OpenFmbDeviceFactory factory, final Map<String, String> deviceIdToAdapterName, final ControlMapping handlerMap) throws IOException {

        final DataReader reader = factory.getRecloserControlProfileReader();

        final TypedTopicSubscription<RecloserControlProfile> subscription =
                new TypedTopicSubscription<RecloserControlProfile>(reader, new RecloserControlProfileHandle(), factory.getSubscriber());

        return new RecloserControlProfileAdapter(subscription, deviceIdToAdapterName, handlerMap);
    }

    public void start() throws IOException {

        subscription.subscribe(new SubscriptionHandler<RecloserControlProfile>() {
            public void handle(ReadResult<RecloserControlProfile> readResult) {

                for (RecloserControlProfile v : readResult.getResults()) {

                    final String adapterName = deviceIdToAdapterName.get(v.logicalDeviceID);

                    if (adapterName != null) {

                        if (!v.recloserControl.endDeviceControlType.action.equals("")) {

                            final Control.EndDeviceControl endDeviceControl =
                                    new Control.EndDeviceControl(
                                            adapterName,
                                            v.recloserControl.endDeviceControlType.action,
                                            v.recloserControl.endDeviceControlType.type);

                            final List<ControlHandler> controlHandlers = handlerMap.getDeviceControlMap().get(endDeviceControl);
                            if (controlHandlers != null) {
                                for (ControlHandler handler : controlHandlers) {
                                    handler.handle(endDeviceControl);
                                }
                            }

                        }

                        for (Object obj : v.recloserControl.setPoints.userData) {
                            SetPoint sp = (SetPoint) obj;

                            final Control.SetpointId setpointId = new Control.SetpointId(adapterName, sp.controlType, sp.unit, sp.multiplier);

                            final Control.SetpointControl setpointControl = new Control.SetpointControl(setpointId, sp.value);

                            final List<ControlHandler> controlHandlers = handlerMap.getSetpointControlMap().get(setpointId);
                            if (controlHandlers != null) {
                                for (ControlHandler handler : controlHandlers) {
                                    handler.handle(setpointControl);
                                }
                            }
                        }

                    }
                }
            }
        });
    }


    public void close() {
        subscription.close();
    }
}
