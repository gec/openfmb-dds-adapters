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

import com.greenenergycorp.openfmb.dds.mapping.xml.*;
import org.totalgrid.dnp3.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class XmlConfigReader {


    private static MasterConfig load(Master xml, int fragSize) {

        final MasterConfig cfg = new MasterConfig();
        cfg.setAllowTimeSync(xml.getMasterSettings().isAllowTimeSync());
        cfg.setTaskRetryRate(xml.getMasterSettings().getTaskRetryMS());
        cfg.setIntegrityRate(xml.getMasterSettings().getIntegrityPeriodMS());

        cfg.setDoUnsolOnStartup(xml.getUnsol().isDoTask());
        cfg.setEnableUnsol(xml.getUnsol().isEnable());

        int unsolClass = 0;
        if (xml.getUnsol().isClass1()) {
            unsolClass |= PointClass.PC_CLASS_1.swigValue();
        }
        if (xml.getUnsol().isClass2()) {
            unsolClass |= PointClass.PC_CLASS_2.swigValue();
        }
        if (xml.getUnsol().isClass3()) {
            unsolClass |= PointClass.PC_CLASS_3.swigValue();
        }
        cfg.setUnsolClassMask(unsolClass);

        cfg.setFragSize(fragSize);

        for (Master.ScanList.ExceptionScan scan: xml.getScanList().getExceptionScan()) {
            int pollClass = 0;
            if (scan.isClass1()) {
                pollClass |= PointClass.PC_CLASS_1.swigValue();
            }
            if (scan.isClass2()) {
                pollClass |= PointClass.PC_CLASS_2.swigValue();
            }
            if (scan.isClass3()) {
                pollClass |= PointClass.PC_CLASS_3.swigValue();
            }
            cfg.AddExceptionScan(pollClass, scan.getPeriodMS());
        }

        return cfg;
    }

    private static AppConfig load(AppLayer xml) {
        final AppConfig cfg = new AppConfig();
        cfg.setFragSize(xml.getMaxFragSize());
        cfg.setRspTimeout(xml.getTimeoutMS());
        return cfg;
    }

    private static LinkConfig load(LinkLayer xml) {
        final LinkConfig cfg = new LinkConfig(xml.isIsMaster(), xml.isUseConfirmations());
        cfg.setNumRetry(xml.getNumRetries());
        cfg.setRemoteAddr(xml.getRemoteAddress());
        cfg.setLocalAddr(xml.getLocalAddress());
        cfg.setTimeout(xml.getAckTimeoutMS());
        return cfg;
    }


    public static MasterStackConfig load(Master xml) {
        final MasterStackConfig cfg = new MasterStackConfig();
        cfg.setMaster(load(xml, xml.getStack().getAppLayer().getMaxFragSize()));
        cfg.setApp(load(xml.getStack().getAppLayer()));
        cfg.setLink(load(xml.getStack().getLinkLayer()));
        return cfg;
    }

    public static class DnpXmlMarshaller {

        //private final static Logger logger = LoggerFactory.getLogger(DnpXmlMarshaller.class);
        private final JAXBContext jaxbContext;

        private DnpXmlMarshaller(JAXBContext jaxbContext) {
            this.jaxbContext = jaxbContext;
        }

        public static DnpXmlMarshaller build() throws JAXBException {
            final JAXBContext jaxbContext = JAXBContext.newInstance(OpenFMBDNP3.class);
            return new DnpXmlMarshaller(jaxbContext);
        }
        
        public OpenFMBDNP3 unmarshal(InputStream is) throws JAXBException {
            //try {
                final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

                final Object obj = unmarshaller.unmarshal(is);

                return (OpenFMBDNP3)(obj);

            /*} catch (JAXBException e) {
                logger.error("Could not unmarshal DNP3 XML configuration: " + e);
                return null;
            }*/
        }
    }
}
