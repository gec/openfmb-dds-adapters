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
import com.greenenergycorp.openfmb.dds.handle.BatteryControlProfileHandle;
import com.greenenergycorp.openfmb.mapping.*;
import com.rti.dds.subscription.DataReader;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryControlProfile;
import org.openfmb.model.dds.rti.openfmb.commonmodule.SetPoint;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BatteryControlProfileAdapter implements ControlAdapter {
    private final TypedTopicSubscription<BatteryControlProfile> subscription;
    private final Map<String, String> deviceIdToAdapterName;
    private final ControlMapping handlerMap;

    public BatteryControlProfileAdapter(TypedTopicSubscription<BatteryControlProfile> subscription, final Map<String, String> deviceIdToAdapterName, ControlMapping handlerMap) {
        this.subscription = subscription;
        this.deviceIdToAdapterName = deviceIdToAdapterName;
        this.handlerMap = handlerMap;
    }

    public static BatteryControlProfileAdapter build(final OpenFmbDeviceFactory factory, final String topicName, final Map<String, String> deviceIdToAdapterName, final ControlMapping handlerMap) throws IOException {

        final DataReader reader = factory.getBatteryControlProfileReader(topicName);

        final TypedTopicSubscription<BatteryControlProfile> subscription =
                new TypedTopicSubscription<BatteryControlProfile>(reader, new BatteryControlProfileHandle(), factory.getSubscriber());

        return new BatteryControlProfileAdapter(subscription, deviceIdToAdapterName, handlerMap);
    }

    public void start() throws IOException {

        subscription.subscribe(new SubscriptionHandler<BatteryControlProfile>() {
            public void handle(ReadResult<BatteryControlProfile> readResult) {

                for (BatteryControlProfile v : readResult.getResults()) {

                    final String adapterName = deviceIdToAdapterName.get(v.logicalDeviceID);

                    if (adapterName != null) {

                        final Control.KeyControlId islandedId = new Control.KeyControlId(adapterName, "isIslanded");
                        final Control.KeyControl keyControl = new Control.KeyControl(islandedId, new MeasValue.MeasBoolValue(v.batterySystemControl.isIslanded));

                        final List<ControlHandler> isIslandedHandlers = handlerMap.getKeyControlMap().get(islandedId);
                        if (isIslandedHandlers != null) {
                            for (ControlHandler handler : isIslandedHandlers) {
                                handler.handle(keyControl);
                            }
                        }


                        if (!v.batterySystemControl.endDeviceControlType.action.equals("")) {

                            final Control.EndDeviceControl endDeviceControl =
                                    CommonMapping.buildControl(adapterName, v.batterySystemControl.endDeviceControlType);

                            final List<ControlHandler> controlHandlers = handlerMap.getDeviceControlMap().get(endDeviceControl);
                            if (controlHandlers != null) {
                                for (ControlHandler handler : controlHandlers) {
                                    handler.handle(endDeviceControl);
                                }
                            }

                        }

                        for (Object obj : v.batterySystemControl.setPoints.userData) {
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
