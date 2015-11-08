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
package com.greenenergycorp.openfmb.dds.modbus;

import com.greenenergycorp.openfmb.dds.DdsParticipant;
import com.greenenergycorp.openfmb.dds.mapping.xml.ModbusMaster;
import com.greenenergycorp.openfmb.dds.mapping.xml.OpenFMBModbus;
import com.greenenergycorp.openfmb.mapping.*;
import com.greenenergycorp.openfmb.mapping.device.OpenFmbDeviceFactory;
import com.greenenergycorp.openfmb.mapping.device.OpenFmbXmlLoader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenFmbModbusAdapter {

    public static void main(String[] args) throws Throwable {

        if (args.length < 1) {
            System.err.println("Must include input file");
            System.exit(1);
        }

        final String filename = args[0];

        // Build the xml marshaller.
        final XmlConfigReader.ModbusXmlMarshaller xmlMarshaller = XmlConfigReader.ModbusXmlMarshaller.build();

        // Parse the XML into a JAXB object.
        final OpenFMBModbus xmlConfig = xmlMarshaller.unmarshal(new FileInputStream(filename));

        // DDS managing object.
        DdsParticipant participant = DdsParticipant.create();

        // Factory for OpenFMB device adapters.
        final OpenFmbDeviceFactory deviceFactory = new OpenFmbDeviceFactory(participant, participant.createPublisher(), participant.createSubscriber());

        // Map of OpenFMB device adapters from XML configuration.
        final Map<String, DeviceAdapter> adapterMap = OpenFmbXmlLoader.loadPublishers(xmlConfig.getPublishers(), deviceFactory);

        // Update manager that takes data and pushes to DDS adapters.
        final DeviceUpdateManager updateManager = new DeviceUpdateManager(adapterMap);

        // Threading model manager for data updates.
        final AdapterManager adapterManager = new AdapterManager(updateManager);

        // Manager for instances of Modbus masters.
        final ModbusAdapterManager modbusAdapterManager = new ModbusAdapterManager(adapterManager.getObserver());

        final List<ControlHandlerMapping> controlHandlerMappings = new ArrayList<ControlHandlerMapping>();

        if (xmlConfig.getModbusMasters() != null && xmlConfig.getModbusMasters().getModbusMaster() != null) {

            // Add a Modbus master for every entry in the XML configuration, and collect the control handler mapping.
            for (ModbusMaster masterXml: xmlConfig.getModbusMasters().getModbusMaster()) {
                final ControlHandlerMapping controlHandlerMapping = modbusAdapterManager.addMaster(masterXml);
                controlHandlerMappings.add(controlHandlerMapping);
            }

            // Combine all control handler mappings to a global map.
            final ControlMapping controlMapping = ControlMapping.combine(controlHandlerMappings);

            // Load OpenFMB DDS control adapters (subscribers) from XML.
            final List<ControlAdapter> controlAdapters = new ArrayList<ControlAdapter>();
            final Map<String, String> logicalIdToAdapterName = new HashMap<String, String>();
            OpenFmbXmlLoader.loadSubscribers(controlAdapters, logicalIdToAdapterName, xmlConfig.getSubscribers(), deviceFactory, controlMapping);

            // Start all control subscriptions.
            for (ControlAdapter adapter: controlAdapters) {
                adapter.start();
            }

            // Start pushing updates to DDS.
            adapterManager.run();

            System.out.println("Shutting down...");
            modbusAdapterManager.shutdown();

        }

    }
}
