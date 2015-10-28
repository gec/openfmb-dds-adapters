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

import com.greenenergycorp.openfmb.dds.mapping.xml.DNP3Master;
import com.greenenergycorp.openfmb.mapping.ControlHandlerMapping;
import com.greenenergycorp.openfmb.mapping.DeviceObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.totalgrid.dnp3.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Dnp3AdapterManager {

    private final static Logger logger = LoggerFactory.getLogger(Dnp3AdapterManager.class);

    private final StackManager stackManager = new StackManager();
    private final LogAdapter logAdapter = new LogAdapter();

    private final Map<String, AdapterRecord> map = new ConcurrentHashMap<String, AdapterRecord>();

    private final DeviceObserver observer;

    public Dnp3AdapterManager(DeviceObserver observer) {
        this.observer = observer;
        stackManager.AddLogHook(logAdapter);
    }

    ControlHandlerMapping addAdapter(final DNP3Master xmlConfig) {

        if (xmlConfig.getTCPClient() == null) {
            throw new IllegalArgumentException("TCP client configuration must be present");
        }
        if (xmlConfig.getTCPClient().getAddress() == null) {
            throw new IllegalArgumentException("TCP client configuration must include address");
        }

        final String tcpName = xmlConfig.getTCPClient().getAddress() + ":" + xmlConfig.getTCPClient().getPort();

        if (xmlConfig.getLog() == null || xmlConfig.getLog().getFilter() == null) {
            throw new IllegalArgumentException("Log configuration must be present");
        }

        final FilterLevel logLevel = LogAdapter.translateLogLevel(xmlConfig.getLog().getFilter());
        final PhysLayerSettings physLayerSettings = new PhysLayerSettings(logLevel, xmlConfig.getTCPClient().getOpenRetryMS());

        stackManager.AddTCPClient(tcpName, physLayerSettings, xmlConfig.getTCPClient().getAddress(), xmlConfig.getTCPClient().getPort());

        if (xmlConfig.getIndexMapping() == null) {
            throw new IllegalArgumentException("Must include index mapping");
        }

        final Dnp3DataMapping dataMapping = DataMappingReader.load(xmlConfig.getIndexMapping());

        final UpdateAdapter updateAdapter = new UpdateAdapter(tcpName, dataMapping, observer);

        final MasterStackConfig masterStackConfig = XmlConfigReader.load(xmlConfig.getMaster());

        final String stackName = "DNP-" + tcpName;

        final ICommandAcceptor commandAcceptor = stackManager.AddMaster(tcpName, stackName, logLevel, updateAdapter, masterStackConfig);

        final ControlHandlerMapping controlHandlerMapping = ControlMappingReader.load(xmlConfig, commandAcceptor);

        map.put(stackName, new AdapterRecord(stackName, tcpName, commandAcceptor, updateAdapter));

        return controlHandlerMapping;
    }

    public void shutdown() {
        stackManager.Shutdown();
        map.clear();
    }

    private static class AdapterRecord {
        private final String stackName;
        private final String portName;
        private final ICommandAcceptor commandAcceptor;
        private final UpdateAdapter updateAdapter;

        public AdapterRecord(String stackName, String portName, ICommandAcceptor commandAcceptor, UpdateAdapter updateAdapter) {
            this.stackName = stackName;
            this.portName = portName;
            this.commandAcceptor = commandAcceptor;
            this.updateAdapter = updateAdapter;
        }

        public String getStackName() {
            return stackName;
        }

        public String getPortName() {
            return portName;
        }

        public ICommandAcceptor getCommandAcceptor() {
            return commandAcceptor;
        }

        public UpdateAdapter getUpdateAdapter() {
            return updateAdapter;
        }
    }
}