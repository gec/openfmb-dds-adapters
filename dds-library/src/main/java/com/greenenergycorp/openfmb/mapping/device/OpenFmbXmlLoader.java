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
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryEventModuleDataWriter;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatteryReadingModuleDataWriter;
import org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystem;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.Recloser;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserEventModuleDataWriter;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserReadingModuleDataWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenFmbXmlLoader {

    public static Map<String, DeviceAdapter> loadPublishers(final PublishersType xml, final OpenFmbDeviceFactory factory) throws IOException {

        final HashMap<String, DeviceAdapter> map = new HashMap<String, DeviceAdapter>();

        if (xml.getElements() != null) {
            for (Object elem: xml.getElements()) {

                if (elem instanceof RecloserEventModule) {
                    final RecloserEventModule entry = (RecloserEventModule)elem;
                    final String name = "RecloserEventModule";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }
                    final Recloser description = getRecloserDescription(entry, name);

                    final RecloserEventModuleDataWriter writer = factory.getRecloserEventModuleWriter();

                    final RecloserEventModuleAdapter recloserEventModuleAdapter =
                            new RecloserEventModuleAdapter(writer, entry.getLogicalDeviceId(), description);

                    map.put(entry.getAdapterName(), recloserEventModuleAdapter);

                } else if (elem instanceof RecloserReadingModule) {
                    final RecloserReadingModule entry = (RecloserReadingModule) elem;
                    final String name = "RecloserReadingModule";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }
                    final Recloser description = getRecloserDescription(entry, name);

                    final RecloserReadingModuleDataWriter writer = factory.getRecloserReadModuleWriter();

                    final RecloserReadingModuleAdapter recloserReadingModuleAdapter =
                            new RecloserReadingModuleAdapter(writer, entry.getLogicalDeviceId(), description);

                    map.put(entry.getAdapterName(), recloserReadingModuleAdapter);
                    
                } else if (elem instanceof BatteryEventModule) {
                    final BatteryEventModule entry = (BatteryEventModule)elem;
                    final String name = "BatteryEventModule";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }
                    final BatterySystem description = getBatteryDescription(entry, name);

                    final BatteryEventModuleDataWriter writer = factory.getBatteryEventModuleWriter();

                    final BatteryEventModuleAdapter eventModuleAdapter =
                            new BatteryEventModuleAdapter(writer, entry.getLogicalDeviceId(), description);

                    map.put(entry.getAdapterName(), eventModuleAdapter);

                } else if (elem instanceof BatteryReadingModule) {
                    final BatteryReadingModule entry = (BatteryReadingModule) elem;
                    final String name = "BatteryReadingModule";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }
                    final BatterySystem description = getBatteryDescription(entry, name);

                    final BatteryReadingModuleDataWriter writer = factory.getBatteryReadModuleWriter();

                    final BatteryReadingModuleAdapter readingModuleAdapter =
                            new BatteryReadingModuleAdapter(writer, entry.getLogicalDeviceId(), description);

                    map.put(entry.getAdapterName(), readingModuleAdapter);
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

                if (elem instanceof RecloserControlModule) {
                    final RecloserControlModule entry = (RecloserControlModule) elem;
                    final String name = "RecloserControlModule";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }

                    final DataReader reader = factory.getRecloserControlModuleReader();

                    final RecloserControlModuleAdapter adapter = RecloserControlModuleAdapter.build(reader, logicalIdToAdapterName, controlMapping);
                    controlAdapters.add(adapter);
                    
                } else if (elem instanceof BatteryControlModule) {
                    final BatteryControlModule entry = (BatteryControlModule) elem;
                    final String name = "BatteryControlModule";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }

                    final DataReader reader = factory.getBatteryControlModuleReader();

                    final BatteryControlModuleAdapter adapter = BatteryControlModuleAdapter.build(reader, logicalIdToAdapterName, controlMapping);
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
