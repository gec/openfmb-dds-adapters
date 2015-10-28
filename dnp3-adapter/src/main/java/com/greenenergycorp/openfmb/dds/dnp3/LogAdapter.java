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

import com.greenenergycorp.openfmb.dds.mapping.xml.LogLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.totalgrid.dnp3.FilterLevel;
import org.totalgrid.dnp3.ILogBase;
import org.totalgrid.dnp3.LogEntry;

public class LogAdapter extends ILogBase {

    private final static Logger logger = LoggerFactory.getLogger(Dnp3AdapterManager.class);

    @Override
    public void SetVar(String aSource, String aVarName, int aValue) {
    }

    private static String buildMessage(LogEntry arEntry) {
        return arEntry.GetFilterLevel().toString() + " - " + arEntry.GetDeviceName() + " - " + arEntry.GetMessage();
    }

    @Override
    public void Log(LogEntry arEntry) {

        // we need to upgrade all of the messages up to a usable logging level, we let the
        // filter settings we pass into the stack determine how much info we see
        if (arEntry.GetFilterLevel() == FilterLevel.LEV_COMM) {
            logger.info(buildMessage(arEntry));
        } else if (arEntry.GetFilterLevel() == FilterLevel.LEV_DEBUG) {
            logger.info(buildMessage(arEntry));
        } else if (arEntry.GetFilterLevel() == FilterLevel.LEV_ERROR) {
            logger.error(buildMessage(arEntry));
        } else if (arEntry.GetFilterLevel() == FilterLevel.LEV_EVENT) {
            logger.info(buildMessage(arEntry));
        } else if (arEntry.GetFilterLevel() == FilterLevel.LEV_INFO) {
            logger.info(buildMessage(arEntry));
        } else if (arEntry.GetFilterLevel() == FilterLevel.LEV_INTERPRET) {
            logger.info(buildMessage(arEntry));
        } else if (arEntry.GetFilterLevel() == FilterLevel.LEV_WARNING) {
            logger.warn(buildMessage(arEntry));
        }
    }

    public static FilterLevel translateLogLevel(LogLevel xmlLevel) {
        if(xmlLevel == LogLevel.LOG_EVENT) {
            return FilterLevel.LEV_EVENT;
        } else if(xmlLevel == LogLevel.LOG_ERROR) {
            return FilterLevel.LEV_ERROR;
        } else if(xmlLevel == LogLevel.LOG_WARNING) {
            return FilterLevel.LEV_WARNING;
        } else if(xmlLevel == LogLevel.LOG_INFO) {
            return FilterLevel.LEV_INFO;
        } else if(xmlLevel == LogLevel.LOG_INTERPRET) {
            return FilterLevel.LEV_INTERPRET;
        } else if(xmlLevel == LogLevel.LOG_COMM) {
            return FilterLevel.LEV_COMM;
        } else if(xmlLevel == LogLevel.LOG_DEBUG) {
            return FilterLevel.LEV_DEBUG;
        } else {
            return FilterLevel.LEV_WARNING;
        }
    }
}
