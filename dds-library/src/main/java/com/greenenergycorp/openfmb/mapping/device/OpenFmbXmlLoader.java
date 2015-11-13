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
import org.openfmb.model.dds.rti.openfmb.commonmodule.PowerSystemResource;
import org.openfmb.model.dds.rti.openfmb.loadmodule.EnergyConsumer;
import org.openfmb.model.dds.rti.openfmb.loadmodule.LoadReadingProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.Recloser;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserEventProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.reclosermodule.RecloserReadingProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.resourcemodule.Meter;
import org.openfmb.model.dds.rti.openfmb.resourcemodule.ResourceReadingProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.solarmodule.SolarEventProfileDataWriter;
import org.openfmb.model.dds.rti.openfmb.solarmodule.SolarInverter;
import org.openfmb.model.dds.rti.openfmb.solarmodule.SolarReadingProfileDataWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenFmbXmlLoader {

    public static Map<String, DeviceAdapter> loadPublishers(final PublishersType xml, final OpenFmbDeviceFactory factory) throws IOException {

        final HashMap<String, DeviceAdapter> map = new HashMap<String, DeviceAdapter>();

        if (xml != null && xml.getElements() != null) {
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
                    
                } else if (elem instanceof LoadReadingProfile) {
                    final LoadReadingProfile entry = (LoadReadingProfile) elem;
                    final String name = "LoadReadingProfile";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }
                    final EnergyConsumer description = getLoadDescription(entry, name);

                    final LoadReadingProfileDataWriter writer = factory.getLoadReadProfileWriter();

                    final LoadReadingProfileAdapter readingProfileAdapter =
                            new LoadReadingProfileAdapter(writer, entry.getLogicalDeviceId(), description);

                    map.put(entry.getAdapterName(), readingProfileAdapter);
                    
                } else if (elem instanceof ResourceReadingProfile) {
                    final ResourceReadingProfile entry = (ResourceReadingProfile) elem;
                    final String name = "ResourceReadingProfile";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }
                    final Meter description = getResourceDescription(entry, name);

                    final ResourceReadingProfileDataWriter writer = factory.getResourceReadProfileWriter();

                    final ResourceReadingProfileAdapter readingProfileAdapter =
                            new ResourceReadingProfileAdapter(writer, entry.getLogicalDeviceId(), description);

                    map.put(entry.getAdapterName(), readingProfileAdapter);

                } else if (elem instanceof SolarReadingProfile) {
                    final SolarReadingProfile entry = (SolarReadingProfile) elem;
                    final String name = "SolarReadingProfile";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }
                    final SolarInverter description = getSolarDescription(entry, name);

                    final SolarReadingProfileDataWriter writer = factory.getSolarReadProfileWriter();

                    final SolarReadingProfileAdapter readingProfileAdapter =
                            new SolarReadingProfileAdapter(writer, entry.getLogicalDeviceId(), description);

                    map.put(entry.getAdapterName(), readingProfileAdapter);

                } else if (elem instanceof SolarEventProfile) {
                    final SolarEventProfile entry = (SolarEventProfile) elem;
                    final String name = "SolarEventProfile";

                    if (entry.getAdapterName() == null) {
                        throw new IllegalArgumentException(name + " must have adapterName");
                    }
                    if (entry.getLogicalDeviceId() == null) {
                        throw new IllegalArgumentException(name + " must have logicalDeviceId");
                    }
                    final SolarInverter description = getSolarDescription(entry, name);

                    final SolarEventProfileDataWriter writer = factory.getSolarEventProfileWriter();

                    final SolarEventProfileAdapter eventProfileAdapter =
                            new SolarEventProfileAdapter(writer, entry.getLogicalDeviceId(), description);

                    map.put(entry.getAdapterName(), eventProfileAdapter);

                }

            }
        }

        return map;
    }

    public static void loadSubscribers(List<ControlAdapter> controlAdapters, final Map<String, String> logicalIdToAdapterName, final SubscribersType xml, final OpenFmbDeviceFactory factory, final ControlMapping controlMapping) throws IOException {

        if (xml != null && xml.getElements() != null) {

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

                    final RecloserControlProfileAdapter adapter = RecloserControlProfileAdapter.build(factory, logicalIdToAdapterName, controlMapping);
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

                    final BatteryControlProfileAdapter adapter = BatteryControlProfileAdapter.build(factory, logicalIdToAdapterName, controlMapping);
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

    private static EnergyConsumer getLoadDescription(LoadReadingProfile entry, String name) {
        if (entry.getMRID() == null) {
            throw new IllegalArgumentException(name + " must have mRID");
        }
        if (entry.getName() == null) {
            throw new IllegalArgumentException(name + " must have name");
        }
        if (entry.getDescription() == null) {
            throw new IllegalArgumentException(name + " must have description");
        }
        if (entry.getOperatingLimit() == null) {
            throw new IllegalArgumentException(name + " must have operating limit");
        }

        final EnergyConsumer device = new EnergyConsumer();
        device.mRID = entry.getMRID();
        device.name = entry.getName();
        device.description = entry.getDescription();
        device.operatingLimit = entry.getOperatingLimit();
        return device;
    }


    private static Meter getResourceDescription(ResourceReadingProfile entry, String name) {
        if (entry.getMRID() == null) {
            throw new IllegalArgumentException(name + " must have mRID");
        }
        if (entry.getName() == null) {
            throw new IllegalArgumentException(name + " must have name");
        }
        if (entry.getDescription() == null) {
            throw new IllegalArgumentException(name + " must have description");
        }

        if (entry.getPowerSystemResource() == null) {
            throw new IllegalArgumentException(name + " must have PowerSystemResource");
        }

        if (entry.getPowerSystemResource().getMRID() == null) {
            throw new IllegalArgumentException(name + " must have PowerSystemResource mRID");
        }
        if (entry.getPowerSystemResource().getName() == null) {
            throw new IllegalArgumentException(name + " must have PowerSystemResource name");
        }
        if (entry.getPowerSystemResource().getDescription() == null) {
            throw new IllegalArgumentException(name + " must have PowerSystemResource description");
        }

        final org.openfmb.model.dds.rti.openfmb.commonmodule.PowerSystemResource powerSystemResource = new PowerSystemResource();
        powerSystemResource.mRID = entry.getPowerSystemResource().getMRID();
        powerSystemResource.name = entry.getPowerSystemResource().getName();
        powerSystemResource.description = entry.getPowerSystemResource().getDescription();
        
        final Meter device = new Meter();
        device.mRID = entry.getMRID();
        device.name = entry.getName();
        device.description = entry.getDescription();

        device.powerSystemResource = powerSystemResource;

        return device;
    }
    
    private static SolarInverter getSolarDescription(BaseDescribedDevice entry, String name) {
        if (entry.getMRID() == null) {
            throw new IllegalArgumentException(name + " must have mRID");
        }
        if (entry.getName() == null) {
            throw new IllegalArgumentException(name + " must have name");
        }
        if (entry.getDescription() == null) {
            throw new IllegalArgumentException(name + " must have description");
        }

        final SolarInverter solar = new SolarInverter();
        solar.mRID = entry.getMRID();
        solar.name = entry.getName();
        solar.description = entry.getDescription();
        return solar;
    }
}
