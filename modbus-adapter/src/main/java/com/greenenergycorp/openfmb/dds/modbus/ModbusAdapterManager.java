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

import com.greenenergycorp.openfmb.dds.mapping.xml.ModbusMaster;
import com.greenenergycorp.openfmb.dds.mapping.xml.ProtocolType;
import com.greenenergycorp.openfmb.mapping.ControlHandlerMapping;
import com.greenenergycorp.openfmb.mapping.DeviceObserver;
import org.totalgrid.modbus.japi.*;

import java.util.List;

public class ModbusAdapterManager {
    private final DeviceObserver observer;

    private final ModbusManager modbusManager = new ModbusManager();

    public ModbusAdapterManager(DeviceObserver observer) {
        this.observer = observer;
    }

    ControlHandlerMapping addMaster(final ModbusMaster xml) {

        if (xml.getTCPClient() == null) {
            throw new IllegalArgumentException("TCP client configuration must be present");
        }

        if (xml.getTCPClient().getAddress() == null) {
            throw new IllegalArgumentException("TCP client address configuration must be present");
        }

        final String address = xml.getTCPClient().getAddress();
        final int port = xml.getTCPClient().getPort();

        if (xml.getProtocol() == null || xml.getProtocol().getType() == null) {
            throw new IllegalArgumentException("Protocol configuration must be present");
        }
        final ProtocolType protocolType = xml.getProtocol().getType();

        final ModbusDataMapping dataMapping = DataMappingReader.load(xml);

        final DataObserverAdapter adapter = new DataObserverAdapter(observer, dataMapping);

        CommsObserver commsObserver = new CommsObserver() {
            public void onCommSuccess() {
            }
            public void onCommFailure() {
            }
        };

        ChannelObserver channelObserver = new ChannelObserver() {
            public void onChannelOpening() {
            }

            public void onChannelOnline() {
            }

            public void onChannelOffline() {
            }
        };

        final List<ModbusPoll> modbusPolls = XmlConfigReader.loadPolls(xml);


        if (protocolType == ProtocolType.RTU) {
            if (xml.getStack() == null || xml.getStack().getAddress() == null) {
                throw new IllegalArgumentException("Stack address configuration must be present");
            }
            final Short modbusAddress = xml.getStack().getAddress();

            final MasterHandle masterHandle = modbusManager.addRtuMaster(address, port, modbusAddress.byteValue(), adapter, commsObserver, channelObserver, modbusPolls);

            return ControlMappingReader.load(xml, masterHandle.getCommandHandler());

        } else if (protocolType == ProtocolType.TCPIP) {
            if (xml.getStack() == null || xml.getStack().getAddress() == null) {
                throw new IllegalArgumentException("Stack address configuration must be present");
            }

            final Short modbusAddress = xml.getStack().getAddress();

            final MasterHandle masterHandle = modbusManager.addTcpMaster(address, port, modbusAddress.byteValue(), adapter, commsObserver, channelObserver, modbusPolls);

            return ControlMappingReader.load(xml, masterHandle.getCommandHandler());

        } else {
            throw new IllegalArgumentException("Could not handle the protocol type");
        }
    }

    void shutdown() {
        modbusManager.shutdown();
    }
}
