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
package com.greenenergycorp.openfmb.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Global mapping of OpenFMB DDS control IDs to multiple control handlers.
 *
 * There are three types of control IDs (key, device control, SetPoint) and there is a separate map
 * for each type.
 */
public class ControlMapping {

    private final Map<Control.KeyControlId, List<ControlHandler>> keyControlMap;
    private final Map<Control.EndDeviceControl, List<ControlHandler>> deviceControlMap;
    private final Map<Control.SetpointId, List<ControlHandler>> setpointControlMap;

    public ControlMapping(Map<Control.KeyControlId, List<ControlHandler>> keyControlMap, Map<Control.EndDeviceControl, List<ControlHandler>> deviceControlMap, Map<Control.SetpointId, List<ControlHandler>> setpointControlMap) {
        this.keyControlMap = keyControlMap;
        this.deviceControlMap = deviceControlMap;
        this.setpointControlMap = setpointControlMap;
    }

    /**
     * @return Mapping from OpenFMB control key IDs to control handlers.
     */
    public Map<Control.KeyControlId, List<ControlHandler>> getKeyControlMap() {
        return keyControlMap;
    }

    /**
     * @return Mapping from OpenFMB EndDeviceControl IDs to control handlers.
     */
    public Map<Control.EndDeviceControl, List<ControlHandler>> getDeviceControlMap() {
        return deviceControlMap;
    }

    /**
     * @return Mapping from OpenFMB SetPoint IDs to control handlers.
     */
    public Map<Control.SetpointId, List<ControlHandler>> getSetpointControlMap() {
        return setpointControlMap;
    }

    /**
     * Combine handler mappings from multiple protocol adapters into a map of one-to-many relationships.
     *
     * @param mappings Mappings between control IDs and control handlers.
     * @return Global mapping of OpenFMB DDS control IDs to multiple control handlers.
     */
    public static ControlMapping combine(List<ControlHandlerMapping> mappings) {

        final HashMap<Control.KeyControlId, List<ControlHandler>> keyMap = new HashMap<Control.KeyControlId, List<ControlHandler>>();
        final HashMap<Control.EndDeviceControl, List<ControlHandler>> deviceMap = new HashMap<Control.EndDeviceControl, List<ControlHandler>>();
        final HashMap<Control.SetpointId, List<ControlHandler>> setpointMap = new HashMap<Control.SetpointId, List<ControlHandler>>();

        for (ControlHandlerMapping mappingSet: mappings) {

            for (ControlHandlerMapping.KeyMapping m: mappingSet.getKeyMappings()) {
                load(m.getId(), m.getHandler(), keyMap);
            }
            for (ControlHandlerMapping.DeviceControlMapping m: mappingSet.getDeviceMappings()) {
                load(m.getId(), m.getHandler(), deviceMap);
            }
            for (ControlHandlerMapping.SetPointMapping m: mappingSet.getSetPointMappings()) {
                load(m.getId(), m.getHandler(), setpointMap);
            }

        }

        return new ControlMapping(keyMap, deviceMap, setpointMap);
    }

    private static <Id> void load(Id id, ControlHandler handler, Map<Id, List<ControlHandler>> map) {
        final List<ControlHandler> controlHandlers = map.get(id);
        if (controlHandlers == null) {
            final ArrayList<ControlHandler> createdList = new ArrayList<ControlHandler>();
            createdList.add(handler);
            map.put(id, createdList);
        } else {
            controlHandlers.add(handler);
        }
    }
}
