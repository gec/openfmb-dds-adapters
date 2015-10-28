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
package com.greenenergycorp.openfmb.dds.dnp3;

import com.greenenergycorp.openfmb.dds.DdsParticipant;
import com.greenenergycorp.openfmb.dds.mapping.xml.DNP3Master;
import com.greenenergycorp.openfmb.dds.mapping.xml.OpenFMBDNP3;
import com.greenenergycorp.openfmb.mapping.*;
import com.greenenergycorp.openfmb.mapping.device.OpenFmbDeviceFactory;
import com.greenenergycorp.openfmb.mapping.device.OpenFmbXmlLoader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenFmbDnpAdapter {

    public static void main(String[] args) throws Throwable {

        if (args.length < 1) {
            System.err.println("Must include input file");
            System.exit(1);
        }

        final String filename = args[0];

        final XmlConfigReader.DnpXmlMarshaller marshaller = XmlConfigReader.DnpXmlMarshaller.build();

        final OpenFMBDNP3 xmlConfig = marshaller.unmarshal(new FileInputStream(filename));

        DdsParticipant participant = DdsParticipant.create();

        final OpenFmbDeviceFactory deviceFactory = new OpenFmbDeviceFactory(participant, participant.createPublisher(), participant.createSubscriber());

        final Map<String, DeviceAdapter> adapterMap = OpenFmbXmlLoader.loadPublishers(xmlConfig.getPublishers(), deviceFactory);

        final DeviceUpdateManager updateManager = new DeviceUpdateManager(adapterMap);

        final AdapterManager adapterManager = new AdapterManager(updateManager);

        final Dnp3AdapterManager manager = new Dnp3AdapterManager(adapterManager.getObserver());

        final List<ControlHandlerMapping> controlHandlerMappings = new ArrayList<ControlHandlerMapping>();

        for (DNP3Master masterXml : xmlConfig.getDNP3Masters().getDNP3Master()) {
            final ControlHandlerMapping controlHandlerMapping = manager.addAdapter(masterXml);
            controlHandlerMappings.add(controlHandlerMapping);
        }

        final ControlMapping controlMapping = ControlMapping.combine(controlHandlerMappings);

        final List<ControlAdapter> controlAdapters = new ArrayList<ControlAdapter>();
        final Map<String, String> logicalIdToAdapterName = new HashMap<String, String>();
        OpenFmbXmlLoader.loadSubscribers(controlAdapters, logicalIdToAdapterName, xmlConfig.getSubscribers(), deviceFactory, controlMapping);

        for (ControlAdapter adapter: controlAdapters) {
            adapter.start();
        }

        adapterManager.run();

        System.out.println("Shutting down...");
        manager.shutdown();

    }
}
