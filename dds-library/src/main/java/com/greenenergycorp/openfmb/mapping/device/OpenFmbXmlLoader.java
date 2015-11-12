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

import com.greenenergycorp.openfmb.dds.mapping.xml.*;
import com.greenenergycorp.openfmb.mapping.ControlAdapter;
import com.greenenergycorp.openfmb.mapping.ControlMapping;
import com.greenenergycorp.openfmb.mapping.DeviceAdapter;
import com.rti.dds.subscription.DataReader;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryEventProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryReadingProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystem;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.Recloser;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserEventProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserReadingProfileDataWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenFmbXmlLoader {

    public static Map<String, DeviceAdapter> loadPublishers(final PublishersType xml, final OpenFmbDeviceFactory factory) throws IOException {

        final HashMap<String, DeviceAdapter> map = new HashMap<String, DeviceAdapter>();

        if (xml.getElements() != null) {
            for (Object elem: xml.getElements()) {

                if (elem instanceof RecloserEventProfile) {
                    final RecloserEventProfile entry = (RecloserEventProfile)elem;
                    final String name = "RecloserEventProfile";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }
                    final Recloser description = getRecloserDescription(entry, name);

                    final RecloserEventProfileDataWriter writer = factory.getRecloserEventProfileWriter();

                    final RecloserEventProfileAdapter recloserEventProfileAdapter =
                            new RecloserEventProfileAdapter(writer, entry.getLogicalDeviceId(), description);

                    map.put(entry.getAdapterName(), recloserEventProfileAdapter);

                } else if (elem instanceof RecloserReadingProfile) {
                    final RecloserReadingProfile entry = (RecloserReadingProfile) elem;
                    final String name = "RecloserReadingProfile";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }
                    final Recloser description = getRecloserDescription(entry, name);

                    final RecloserReadingProfileDataWriter writer = factory.getRecloserReadProfileWriter();

                    final RecloserReadingProfileAdapter recloserReadingProfileAdapter =
                            new RecloserReadingProfileAdapter(writer, entry.getLogicalDeviceId(), description);

                    map.put(entry.getAdapterName(), recloserReadingProfileAdapter);
                    
                } else if (elem instanceof BatteryEventProfile) {
                    final BatteryEventProfile entry = (BatteryEventProfile)elem;
                    final String name = "BatteryEventProfile";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }
                    final BatterySystem description = getBatteryDescription(entry, name);

                    final BatteryEventProfileDataWriter writer = factory.getBatteryEventProfileWriter();

                    final BatteryEventProfileAdapter eventProfileAdapter =
                            new BatteryEventProfileAdapter(writer, entry.getLogicalDeviceId(), description);

                    map.put(entry.getAdapterName(), eventProfileAdapter);

                } else if (elem instanceof BatteryReadingProfile) {
                    final BatteryReadingProfile entry = (BatteryReadingProfile) elem;
                    final String name = "BatteryReadingProfile";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }
                    final BatterySystem description = getBatteryDescription(entry, name);

                    final BatteryReadingProfileDataWriter writer = factory.getBatteryReadProfileWriter();

                    final BatteryReadingProfileAdapter readingProfileAdapter =
                            new BatteryReadingProfileAdapter(writer, entry.getLogicalDeviceId(), description);

                    map.put(entry.getAdapterName(), readingProfileAdapter);
                }

            }
        }

        return map;
    }

    public static void loadSubscribers(List<ControlAdapter> controlAdapters, final Map<String, String> logicalIdToAdapterName, final SubscribersType xml, final OpenFmbDeviceFactory factory, final ControlMapping controlMapping) throws IOException {

        if (xml.getElements() != null) {

            for (Object elem: xml.getElements()) {
                if (elem instanceof BaseIdentified) {
                    final BaseIdentified entry = (BaseIdentified) elem;
                    final String name = elem.getClass().getSimpleName();

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }

                    logicalIdToAdapterName.put(entry.getLogicalDeviceId(), entry.getAdapterName());
                } else {
                    throw new IllegalArgumentException("Element " + elem + " could not be identified");
                }
            }

            for (Object elem: xml.getElements()) {

                if (elem instanceof RecloserControlProfile) {
                    final RecloserControlProfile entry = (RecloserControlProfile) elem;
                    final String name = "RecloserControlProfile";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }

                    final DataReader reader = factory.getRecloserControlProfileReader();

                    final RecloserControlProfileAdapter adapter = RecloserControlProfileAdapter.build(reader, logicalIdToAdapterName, controlMapping);
                    controlAdapters.add(adapter);
                    
                } else if (elem instanceof BatteryControlProfile) {
                    final BatteryControlProfile entry = (BatteryControlProfile) elem;
                    final String name = "BatteryControlProfile";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }

                    final DataReader reader = factory.getBatteryControlProfileReader();

                    final BatteryControlProfileAdapter adapter = BatteryControlProfileAdapter.build(reader, logicalIdToAdapterName, controlMapping);
                    controlAdapters.add(adapter);
                }
            }
        }
    }

    private static Recloser getRecloserDescription(RecloserDescription entry, String name) {
        if (entry.getMRID() == null) {
            throw new IllegalArgumentException(name + " must have mRID");
        }
        if (entry.getName() == null) {
            throw new IllegalArgumentException(name + " must have name");
        }
        if (entry.getDescription() == null) {
            throw new IllegalArgumentException(name + " must have description");
        }
        if (entry.getNormalOpen() == null) {
            throw new IllegalArgumentException(name + " must have normalOpen");
        }

        final Recloser recloser = new Recloser();
        recloser.mRID = entry.getMRID();
        recloser.name = entry.getName();
        recloser.description = entry.getDescription();
        recloser.normalOpen = entry.getNormalOpen();
        return recloser;
    }

    private static BatterySystem getBatteryDescription(BaseDescribedDevice entry, String name) {
        if (entry.getMRID() == null) {
            throw new IllegalArgumentException(name + " must have mRID");
        }
        if (entry.getName() == null) {
            throw new IllegalArgumentException(name + " must have name");
        }
        if (entry.getDescription() == null) {
            throw new IllegalArgumentException(name + " must have description");
        }

        final BatterySystem battery = new BatterySystem();
        battery.mRID = entry.getMRID();
        battery.name = entry.getName();
        battery.description = entry.getDescription();
        return battery;
    }
}
