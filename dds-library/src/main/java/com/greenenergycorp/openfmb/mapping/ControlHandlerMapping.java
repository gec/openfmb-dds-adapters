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

import java.util.List;

public class ControlHandlerMapping {

    private final List<KeyMapping> keyMappings;
    private final List<DeviceControlMapping> deviceMappings;
    private final List<SetPointMapping> setPointMappings;

    public ControlHandlerMapping(List<KeyMapping> keyMappings, List<DeviceControlMapping> deviceMappings, List<SetPointMapping> setPointMappings) {
        this.keyMappings = keyMappings;
        this.deviceMappings = deviceMappings;
        this.setPointMappings = setPointMappings;
    }

    public List<KeyMapping> getKeyMappings() {
        return keyMappings;
    }

    public List<DeviceControlMapping> getDeviceMappings() {
        return deviceMappings;
    }

    public List<SetPointMapping> getSetPointMappings() {
        return setPointMappings;
    }

    public static class KeyMapping {
        private final Control.KeyControlId id;
        private final ControlHandler handler;

        public KeyMapping(Control.KeyControlId id, ControlHandler handler) {
            this.id = id;
            this.handler = handler;
        }

        public Control.KeyControlId getId() {
            return id;
        }

        public ControlHandler getHandler() {
            return handler;
        }
    }

    public static class DeviceControlMapping {
        private final Control.EndDeviceControl id;
        private final ControlHandler handler;

        public DeviceControlMapping(Control.EndDeviceControl id, ControlHandler handler) {
            this.id = id;
            this.handler = handler;
        }

        public Control.EndDeviceControl getId() {
            return id;
        }

        public ControlHandler getHandler() {
            return handler;
        }
    }

    public static class SetPointMapping {
        private final Control.SetpointId id;
        private final ControlHandler handler;

        public SetPointMapping(Control.SetpointId id, ControlHandler handler) {
            this.id = id;
            this.handler = handler;
        }

        public Control.SetpointId getId() {
            return id;
        }

        public ControlHandler getHandler() {
            return handler;
        }
    }
}
