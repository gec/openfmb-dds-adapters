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

import com.greenenergycorp.openfmb.dds.mapping.xml.DataType;
import com.greenenergycorp.openfmb.dds.mapping.xml.ModbusMaster;
import com.greenenergycorp.openfmb.dds.mapping.xml.OpenFMBModbus;
import com.greenenergycorp.openfmb.dds.mapping.xml.Polls;
import org.totalgrid.modbus.japi.ModbusPoll;
import org.totalgrid.modbus.japi.PollType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Load Modbus configuration from XML.
 */
public class XmlConfigReader {

    public static List<ModbusPoll> loadPolls(ModbusMaster xml) {
        final List<ModbusPoll> polls = new ArrayList<ModbusPoll>();

        if (xml.getPolls() != null && xml.getPolls().getPoll() != null) {
            for (Polls.Poll poll: xml.getPolls().getPoll()) {
                if (poll.getType() == null) {
                    throw new IllegalArgumentException("Poll must include type");
                }

                PollType pollType;
                if (poll.getType() == DataType.DISCRETE_INPUT) {
                    pollType = PollType.DiscreteInput;
                } else if (poll.getType() == DataType.COIL_STATUS) {
                    pollType = PollType.CoilStatus;
                } else if (poll.getType() == DataType.INPUT_REGISTER) {
                    pollType = PollType.InputRegister;
                } else if (poll.getType() == DataType.HOLDING_REGISTER) {
                    pollType = PollType.HoldingRegister;
                } else {
                    throw new IllegalArgumentException("Unrecognized poll type");
                }

                polls.add(new ModbusPoll(pollType, poll.getStart(), poll.getCount(), poll.getIntervalMs(), poll.getTimeoutMs()));
            }
        }

        return polls;
    }

    public static class ModbusXmlMarshaller {

        private final JAXBContext jaxbContext;

        private ModbusXmlMarshaller(JAXBContext jaxbContext) {
            this.jaxbContext = jaxbContext;
        }

        public static ModbusXmlMarshaller build() throws JAXBException {
            final JAXBContext jaxbContext = JAXBContext.newInstance(OpenFMBModbus.class);
            return new ModbusXmlMarshaller(jaxbContext);
        }

        public OpenFMBModbus unmarshal(InputStream is) throws JAXBException {
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            final Object obj = unmarshaller.unmarshal(is);

            return (OpenFMBModbus)(obj);
        }
    }
}
