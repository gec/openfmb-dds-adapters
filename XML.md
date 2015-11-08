Adapter XML Configuration
==========================

Common Adapter Configuration
-------------

## Publishers

Example:

Common publisher attributes:

* `adapterName` - Used to identify this publisher instance in the data mappings. String value.
* `logicalDeviceId` - Defines the DDS key for the OpenFMB topics. String value.
* `mRID` - Defines the OpenFMB mRID field. String value.
* `name` - Defines the OpenFMB name field. String value.
* `description` - Defines the OpenFMB description field. String value.

Publisher types:

* RecloserEventModule
    * `normalOpen` - Defines the "normalOpen" field in the OpenFMB recloser description. Boolean value.
* RecloserReadingModule
    * `normalOpen` - Defines the "normalOpen" field in the OpenFMB recloser description. Boolean value.
* BatteryEventModule
* BatteryReadingModule

Example:

```xml
<Publishers>
    <fmb:BatteryReadingModule
            adapterName="Battery_Read"
            logicalDeviceId="NewOrleans.Microgrid.Battery"
            mRID="NewOrleans.Microgrid.Battery"
            name="Microgrid ESS"
            description="Microgrid ESS"/>
</Publishers>
```

## Subscribers

Common subscriber attributes:

* `adapterName` - Used to identify this publisher instance in the data mappings. String value.
* `logicalDeviceId` - Defines the DDS key for the OpenFMB topics. String value.

Subscriber types:

* RecloserControlModule
* BatteryControlModule

Example:

```xml
<Subscribers>
    <fmb:BatteryControlModule adapterName="Battery_Control" logicalDeviceId="NewOrleans.Microgrid.Battery"/>
</Subscribers>
```


Transforms
-------------

Transforms are embedded in mappings for data updates and controls. They provide the ability to do basic processing to
map device data formats to OpenFMB IDL structures.

### Scale

The scaling transform takes a multiplier and offset and performs the linear transform: x * multiplier + offset.

Attributes:

* `multiplier` - Floating-point multiplier value. Optional (defaults to 1).
* `offset` - Floating-point offset value. Optional (defaults to 0).

Example:

```xml
    <fmb:transform>
        <fmb:scale multiplier="3.0" offset="10.5"/>
    </fmb:transform>
```

### Greater Than

Takes a numeric value and produces a boolean `true` if greater than the `value`, otherwise `false`.

Attributes:

* `value` - Floating-point value to test against.

Example:

```xml
    <fmb:transform>
        <fmb:greaterThan value="0"/>
    </fmb:transform>
```

### Greater Than Or Equal

Takes a numeric value and produces a boolean `true` if greater than or equal to the `value`, otherwise `false`.

Attributes:

* `value` - Floating-point value to test against.

Example:

```xml
    <fmb:transform>
        <fmb:greaterThanOrEqual value="0"/>
    </fmb:transform>
```

### Less Than

Takes a numeric value and produces a boolean `true` if less than the `value`, otherwise `false`.

Attributes:

* `value` - Floating-point value to test against.

Example:

```xml
    <fmb:transform>
        <fmb:lessThan value="0"/>
    </fmb:transform>
```

### Less Than Or Equal

Takes a numeric value and produces a boolean `true` if less than or equal to the `value`, otherwise `false`.

Attributes:

* `value` - Floating-point value to test against.

Example:

```xml
    <fmb:transform>
        <fmb:lessThanOrEqual value="0"/>
    </fmb:transform>
```

### Match

The `match` element takes a sequence of `case` elements representing possible input values to match and resulting values
to output. Each `case` element should include one "match" attribute and one "to" attribute.

Attributes:

* `defaultBooleanValue` - Boolean value to use if no case matches. Only one default value should be provided.
* `defaultIntegerValue` - Boolean value to use if no case matches. Only one default value should be provided.
* `defaultStringValue` - Boolean value to use if no case matches. Only one default value should be provided.

Case attributes:

* `matchBooleanValue` - Specifies a boolean value to match against the input.
* `matchIntegerValue` - Specifies an integer value to match against the input.
* `matchStringValue` - Specifies a string value to match against the input.
* `toBooleanValue` - Specifies a boolean value to output when the input matches.
* `toIntegerValue` - Specifies an integer value to output when the input matches.
* `toStringValue` - Specifies a string value to to output when the input matches.

Example:

```xml
<fmb:transform>
    <fmb:match defaultStringValue="unknown">
        <fmb:case matchIntegerValue="0" toStringValue="Standby"/>
        <fmb:case matchIntegerValue="1" toStringValue="Firm"/>
    </fmb:match>
</fmb:transform>
```


Modbus Adapter Configuration
--------------------

Basic structure:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<OpenFMBModbus xmlns:fmb="org.openfmb.microgrid.config.xml" xmlns="org.openfmb.microgrid.modbus.xml">
    <Publishers>
        <!-- List of instances of DDS event/reading data types to publish -->
    </Publishers>
    <Subscribers>
        <!-- List of instances of DDS control data types to subscribe to -->
    </Subscribers>
    <ModbusMasters>
        <ModbusMaster>
            <!-- mapping for a Modbus device -->
        </ModbusMaster>
        <ModbusMaster>
            <!-- mapping for a Modbus device -->
        </ModbusMaster>
    </ModbusMasters>
</OpenFMBModbus>
```

## Modbus Master Configuration

### TCPClient Element

Specifies TCP address of Modbus device.

Attributes:

* `Address` - IP address of device.
* `Port` - IP port of device.

Example:

```xml
<TCPClient Address="127.0.0.1" Port="502"/>
```

### Protocol Type

Specifies the framing protocol for the Modbus connection. The "RTU" protocol tunnels the Modbus serial
protocol over TCP/IP. The "TCPIP" protocol uses the Modbus TCP/IP headers.

Attributes:

* `Type` - Values are "RTU" or "TCPIP".

Example:

```xml
<Protocol Type="TCPIP"/>
```

### Stack Address

Specifies the Modbus address for the device.

Attributes:

* `Address` - Integer value of Modbus device.

Example:

```xml
<Stack Address="3"/>
```

### Poll List

Specifies a schedule of polls to retrieve data.

Poll attributes:

* `Type` - Type of Modbus data to poll for. Options:
    * DiscreteInput
    * CoilStatus
    * InputRegister
    * HoldingRegister
* `Start` - First index in the range to be read
* `Count` - Number of indexes, from the start index, to be read
* `IntervalMs` - Time in milliseconds between polls.
* `TimeoutMs` - Time in milliseconds to wait for a response until a request is considered a failure.

Example:

```xml
<Polls>
    <Poll Type="DiscreteInput" Start="0" Count="20" IntervalMs="1000" TimeoutMs="2000"/>
    <Poll Type="InputRegister" Start="0" Count="20" IntervalMs="1000" TimeoutMs="2000"/>
</Polls>
```

### Data Mappings

The data mappings consist of sequences of `<Mapping>` elements corresponding to each Modbus data type:

* `DiscreteInputMap` - Collection of mappings for Modbus discrete inputs.
* `CoilStatusMap` - Collection of mappings for Modbus coil statuses.
* `InputRegisterMap` - Collection of mappings for Modbus input registers.
* `HoldingRegisterMap` - Collection of mappings for Modbus holding registers.

#### Data Conversion

Indexes into the input registers and holding registers refer to 16-bit (2 byte) blocks of data. Depending
on the device description, these values may need to be interpreted as signed or unsigned integers or floating
points of varying lengths. Mapping entries with conversion types greater than 16-bits are assumed to extend
into the next highest registers (i.e. a UInt32BE at index 2 is stored in 2 and 3, the next distinct value is
then at index 4).

The endian-ness of conversions describes in what order multiple registers are combined. All 16-bit blocks are
assumed to be big-endian (the first, lower, index refers to the most significant byte of the register).

The following enumeration determines how values are interpreted by the Modbus adapter:

* `SInt16` - the single register is interpreted as a signed integer value.
* `UInt16` - the single register is interpreted as an unsigned integer value.
* `SInt32LE` - the two registers are combined with the least significant in the lower index, and interpreted as a signed integer value.
* `UInt32LE` - the two registers are combined with the least significant in the lower index, and interpreted as an unsigned integer value.
* `SInt32BE` - the two registers are combined with the most significant in the lower index, and interpreted as a signed integer value.
* `UInt32BE` - the two registers are combined with the most significant in the lower index, and interpreted as an unsigned integer value.
* `Float32LE` - the two registers are combined with the least significant in the lower index, and interpreted as a 32-bit floating-point value.
* `Float32BE` - the two registers are combined with the most significant in the lower index, and interpreted as a 32-bit floating-point value.
* `Float64LE` - the next four registers are combined in order from least significant to most, and interpreted as a 64-bit floating-point value.
* `Float64BE` - the next four registers are combined in order from most significant to least, and interpreted as a 64-bit floating-point value.

#### Other Attributes

On the DDS side, data can be mapped to "keys" or "readings". Keys correspond to the names of explicit fields in OpenFMB
DDS data types. Readings correspond to members of OpenFMB DDS reading arrays. If the `key` attribute is present, the Modbus
data maps to a key field. If not, the `unit`, `multiplier`, `phases` and `flowDirection` are all used to identify the
OpenFMB reading.

Attributes:

* `index` - Modbus index, 0-based, of the reading.
* `type` - Conversion type for the data at the Modbus index. See the list of conversions for possible values.
* `adapterName` - Name of the adapter, corresponding to an entry in the list of publishers.
* `key` - Specifies that the data maps to a field in a DDS struct. See the OpenFMB IDL for the field names.
* `unit` - Specifies the unit attribute of OpenFMB DDS readings. See the OpenFMB IDL for possible values.
* `multiplier` - Specifies the multiplier attribute of OpenFMB DDS readings. See the OpenFMB IDL for possible values.
* `phases` - Specifies the phases attribute of OpenFMB DDS readings. See the OpenFMB IDL for possible values.
* `flowDirection` - Specifies the flowDirection attribute of OpenFMB DDS readings. See the OpenFMB IDL for possible values.

#### Transforms

The `Mapping` elements can contain a `<fmb:transform>` element that defines data transformations applied before the
data update is given to the DDS adapters. See the common transform documentation for how to configure these elements.

#### Examples:

```xml
<Mapping index="30" type="SInt16" adapterName="Battery_Event" key="stateOfCharge"/>

<Mapping index="48" type="SInt32BE" adapterName="Battery_Read" unit="W" multiplier="kilo" phases="ABC" flowDirection="total">
    <fmb:transform>
        <fmb:scale multiplier="0.001"/>
    </fmb:transform>
</Mapping>
```

### Control Mappings

OpenFMB DDS control topics are mapped to Modbus controls. The OpenFMB controls can take the form of key fields, the OpenFMB
EndDeviceControl structures, and OpenFMB SetPoint structures. These are mapped to Modbus write coil functions and Modbus
write register functions.

Mappings are contained in sequences for each valid pair of Modbus outputs and OpenFMB inputs.

#### Mappings in `WriteCoilFromKeyMappings`

Writes Modbus coils from OpenFMB control key fields.

Attributes:

* `index` - Modbus index, 0-based, of the control.
* `adapterName` - Name of the adapter, corresponding to an entry in the list of subscribers.
* `key` - Specifies a field in an OpenFMB DDS struct that provides the value for the control.

Example:

```xml
<WriteCoilFromKeyMappings>
    <Mapping index="0" adapterName="Battery_Control" key="isIslanded"/>
</WriteCoilFromKeyMappings>
```

#### Mappings in `WriteCoilFromEndDeviceControlMappings`

Writes Modbus coils from OpenFMB EndDeviceControl structures.

Attributes:

* `index` - Modbus index, 0-based, of the control.
* `adapterName` - Name of the adapter, corresponding to an entry in the list of subscribers.
* `action` - Corresponds to the action field in the OpenFMB EndDeviceControl type.
* `type` - Corresponds to the type field in the OpenFMB EndDeviceControl type.
* `writeBoolValue` - Specifies a constant value to write to the coil as a result of the end device control.

Example:

```xml
<WriteCoilFromEndDeviceControlMappings>
    <Mapping index="0" adapterName="Battery_Control" action="trip" type="standard" writeBoolValue="true"/>
</WriteCoilFromEndDeviceControlMappings>
```

#### Mappings in `WriteRegisterFromKeyMappings`

Writes Modbus registers from OpenFMB key fields.

Attributes:

* `index` - Modbus index, 0-based, of the control.
* `adapterName` - Name of the adapter, corresponding to an entry in the list of subscribers.
* `matchBoolValue` - Optional. Specifies a boolean value to match the input against. If they do not match, the register will not be written.
* `constIntValue` - Optional. Specifies a constant integer value to set the register to when the `matchBoolValue` test succeeds.

Example:

```xml
<WriteRegisterFromKeyMappings>
    <Mapping index="0" adapterName="Battery_Control" key="isIslanded" matchBoolValue="true" constIntValue="13"/>
</WriteRegisterFromKeyMappings>
```

#### Mappings in `WriteRegisterFromSetPointMappings`

Writes Modbus registers from OpenFMB SetPoint structures.

Attributes:

* `index` - Modbus index, 0-based, of the control.
* `adapterName` - Name of the adapter, corresponding to an entry in the list of subscribers.
* `controlType` - Corresponds to the controlType field in the OpenFMB SetPoint structure.
* `unit` - Corresponds to the unit field in the OpenFMB SetPoint structure. See OpenFMB IDL for possible values.
* `multiplier` - Corresponds to the unit multiplier field in the OpenFMB SetPoint structure. See OpenFMB IDL for possible values.

Example:

```xml
<WriteRegisterFromSetPointMappings>
    <Mapping index="0" adapterName="Battery_Control" controlType="SetMode" unit="none" multiplier="none"/>
</WriteRegisterFromSetPointMappings>
```

DNP3 Adapter Configuration
--------------------

Basic structure:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<OpenFMBDNP3 xmlns:dnp3="APLXML.DNP" xmlns:apl="APLXML.Base"
             xmlns:fmb="org.openfmb.microgrid.config.xml"
             xmlns="org.openfmb.microgrid.dnp3.xml">
    <Publishers>
        <!-- List of instances of DDS event/reading data types to publish -->
    </Publishers>
    <Subscribers>
        <!-- List of instances of DDS control data types to subscribe to -->
    </Subscribers>
    <DNP3Masters>
        <DNP3Master>
            <!-- mapping for a DNP3 device -->
        </DNP3Master>
        <DNP3Master>
            <!-- mapping for a DNP3 device -->
        </DNP3Master>
    </DNP3Masters>
</OpenFMBDNP3>
```

## DNP3 Master Configuration

This section defines the DNP3-specific parameters for a master protocol adapter.

Example of a DNP3 master configuration:

```xml
<dnp3:Master>
    <dnp3:Stack>
        <dnp3:LinkLayer RemoteBuffFullTimeoutMS="0" NumRetries="3" AckTimeoutMS="1000" UseConfirmations="false" RemoteAddress="2" LocalAddress="1" IsMaster="true"/>
        <dnp3:AppLayer NumRetries="0" MaxFragSize="2048" TimeoutMS="5000"/>
    </dnp3:Stack>
    <dnp3:MasterSettings IntegrityPeriodMS="300000" TaskRetryMS="5000" AllowTimeSync="true"/>
    <dnp3:ScanList>
        <dnp3:ExceptionScan PeriodMS="2000" Class3="true" Class2="true" Class1="true"/>
    </dnp3:ScanList>
    <dnp3:Unsol Class3="true" Class2="true" Class1="true" Enable="false" DoTask="false"/>
</dnp3:Master>
```

### Stack

Configuration parameters for the layers of the DNP3 stack. Contains the link layer and application layer elements.

### LinkLayer

Configuration parameters for the DNP3 link layer.

Attributes:

* `IsMaster` -  Whether the link layer identifies itself as a master device. Should always be 'true'.
* `LocalAddress` -  Master (local) DNP3 link layer address.
* `RemoteAddress` -  Slave (remote) DNP3 link layer address.
* `NumRetries` -  Retries for link layer packets before they are considered a failure. Integer value.
* `AckTimeoutMS` -  Timeout for waiting for link layer acknowledgements. In milliseconds.
* `UseConfirmations` -  Whether to use DNP3 link layer confirmations.

### AppLayer

Configuration parameters for the DNP3 application layer.

Attributes:

* `NumRetries` -  Number of DNP3 application layer retries before a transaction is considered a failure.
* `MaxFragSize` -  Maximum fragment size in bytes for outgoing application layer fragments.
* `TimeoutMS` -  Timeout in milliseconds for application layer transactions.

### MasterSettings

Configuration parameters for the DNP3 master user layer.

Attributes:

* `IntegrityPeriodMS` -  Period in milliseconds between integrity (class 0) polls.
* `TaskRetryMS` -  Period in milliseconds between retries of failed DNP3 requests.
* `AllowTimeSync` -  If true, the master will do time syncs when it sees the time IIN bit from the slave.

### ScanList

Configures as list of exception scans to pull data from the DNP3 slave. Can be left empty to not use exception scans.

### ExceptionScan

Configuration of a DNP3 exception scan. Multiple DNP3 classes can be polled at once.

Attributes:

* `PeriodMS` -  Time in milliseconds between scans.
* `Class1` -  Whether the scan polls for class 1 events.
* `Class2` -  Whether the scan polls for class 1 events.
* `Class3` -  Whether the scan polls for class 1 events.

### Unsol

Configuration of DNP3 unsolicited data.

Attributes:

* `DoTask` -  If true, the master will enable/disable unsol on startup
* `Enable` -  If the task is enabled, this will determine whether the master sets the unsol enabled bit for the slave.
* `Class1` -  Whether unsolicited updates are enabled for class 1 objects.
* `Class2` -  Whether unsolicited updates are enabled for class 1 objects.
* `Class3` -  Whether unsolicited updates are enabled for class 1 objects.

## TCPClient

Parameters for TCP client connection to DNP3 device.

Attributes:

* `Address` -  hostname/IP address
* `Port` -  IP port

Example:

```xml
<apl:TCPClient Address="127.0.0.1" Port="20000"/>
```

## Log

Parameter for the log level of the underlying DNP3 stack. All logs from the stack that are at or above the log level
are logged in Java at "INFO".

Attributes:

* `Filter` - Defines the log level for the underlying DNP3 stack.

Valid log levels:

- LOG_DEBUG
- LOG_COMM
- LOG_INTERPRET
- LOG_INFO
- LOG_WARNING
- LOG_ERROR
- LOG_EVENT

Example:

```xml
<apl:Log Filter="LOG_INFO"/>
```

## Data Mappings

The data mappings consist of sequences of `<Mapping>` elements corresponding to each DNP3 data type:

* `Binaries` - Collection of mappings for DNP3 binary inputs.
* `Analogs` - Collection of mappings for DNP3 analog inputs.
* `Counters` - Collection of mappings for DNP3 counters.
* `ControlStatuses` - Collection of mappings for DNP3 binary output statuses.
* `SetpointStatuses` - Collection of mappings for DNP3 analog output statuses.

On the DDS side, data can be mapped to "keys" or "readings". Keys correspond to the names of explicit fields in OpenFMB
DDS data types. Readings correspond to members of OpenFMB DDS reading arrays. If the `key` attribute is present, the DNP3
data maps to a key field. If not, the `unit`, `multiplier`, `phases` and `flowDirection` are all used to identify the
OpenFMB reading.

Attributes:

* `index` - DNP3 index, 0-based, of the data.
* `adapterName` - Name of the adapter, corresponding to an entry in the list of publishers.
* `key` - Specifies that the data maps to a field in a DDS struct. See the OpenFMB IDL for the field names.
* `unit` - Specifies the unit attribute of OpenFMB DDS readings. See the OpenFMB IDL for possible values.
* `multiplier` - Specifies the multiplier attribute of OpenFMB DDS readings. See the OpenFMB IDL for possible values.
* `phases` - Specifies the phases attribute of OpenFMB DDS readings. See the OpenFMB IDL for possible values.
* `flowDirection` - Specifies the flowDirection attribute of OpenFMB DDS readings. See the OpenFMB IDL for possible values.

### Transforms

The `Mapping` elements can contain a `<fmb:transform>` element that defines data transformations applied before the
data update is given to the DDS adapters. See the common transform documentation for how to configure these elements.

### Examples:

```xml
<Binaries>
    <Mapping index="0" adapterName="Recloser_Event" key="SwitchStatus">
        <fmb:transform>
            <fmb:match defaultBooleanValue="false">
                <fmb:case matchBooleanValue="false" toBooleanValue="true"/>
                <fmb:case matchBooleanValue="true" toBooleanValue="false"/>
            </fmb:match>
        </fmb:transform>
    </Mapping>
</Binaries>
<Analogs>
    <Mapping index="0" adapterName="Recloser_Read" unit="W" multiplier="kilo" phases="ABC" flowDirection="total" />
</Analogs>
```

## Control Mappings

OpenFMB DDS control topics are mapped to DNP3 controls. The OpenFMB controls can take the form of key fields, the OpenFMB
EndDeviceControl structures, and OpenFMB SetPoint structures. These are mapped to DNP3 controls and setpoints.

Mappings are contained in sequences for each valid pair of DNP3 outputs and OpenFMB inputs.

#### Mappings in `ControlFromKeyMappings`

Issues DNP3 controls from OpenFMB control key fields.

Attributes:

* `index` - DNP3 index, 0-based, of the control.
* `adapterName` - Name of the adapter, corresponding to an entry in the list of subscribers.
* `key` - Specifies a field in an OpenFMB DDS struct that provides the value for the control.

Example:

```xml
<ControlFromKeyMappings>
    <Mapping index="0" adapterName="Battery_Control" key="isIslanded"/>
</ControlFromKeyMappings>
```

The mapping element may also contain a control options element that defines the DNP3 control relay block.

Attributes:
* `type` - Possible values are
    * `PULSE`
    * `PULSE_CLOSE`
    * `PULSE_TRIP`
    * `LATCH_ON`
    * `LATCH_OFF`
 * `onTime` - Time, in milliseconds, output is active
 * `offTime` - Time, in milliseconds, output is non-active
 * `count` - Number of times outstation should execute the operation. 0-255 are valid. Defaults to 1.

Count must be 1 or greater to have an effect. 'onTime' / 'offTime' will be ignored if they do not apply to the control type.

Example:

```xml
<ControlOptions type="LATCH_ON" count="1"/>
```

#### Mappings in `ControlFromEndDeviceControlMappings`

Issues DNP3 controls from OpenFMB EndDeviceControl structures.

Attributes:

* `index` - DNP3 index, 0-based, of the control.
* `adapterName` - Name of the adapter, corresponding to an entry in the list of subscribers.
* `action` - Corresponds to the action field in the OpenFMB EndDeviceControl type.
* `type` - Corresponds to the type field in the OpenFMB EndDeviceControl type.

Example:

```xml
<ControlFromEndDeviceControlMappings>
    <Mapping index="0" adapterName="Battery_Control" action="trip" type="standard"/>
</ControlFromEndDeviceControlMappings>
```

The mapping element may also contain a control options element that defines the DNP3 control relay block.

Attributes:
* `type` - Possible values are
    * `PULSE`
    * `PULSE_CLOSE`
    * `PULSE_TRIP`
    * `LATCH_ON`
    * `LATCH_OFF`
* `onTime` - Time, in milliseconds, output is active
* `offTime` - Time, in milliseconds, output is non-active
* `count` - Number of times outstation should execute the operation. 0-255 are valid. Defaults to 1.

Count must be 1 or greater to have an effect. 'onTime' / 'offTime' will be ignored if they do not apply to the control type.

Example:

```xml
<ControlOptions type="LATCH_ON" count="1"/>
```

#### Mappings in `SetpointFromKeyMappings`

Issues DNP3 setpoints from OpenFMB key fields.

Attributes:

* `index` - DNP3 index, 0-based, of the control.
* `adapterName` - Name of the adapter, corresponding to an entry in the list of subscribers.

The mapping element can also contain a transform.

Example:

```xml
<SetpointFromKeyMappings>
    <Mapping index="0" adapterName="Battery_Control" key="example_key"/>
</SetpointFromKeyMappings>
```

#### Mappings in `SetpointFromSetPointMappings`

Issues DNP3 setpoints from OpenFMB SetPoint structures.

Attributes:

* `index` - Modbus index, 0-based, of the control.
* `adapterName` - Name of the adapter, corresponding to an entry in the list of subscribers.
* `controlType` - Corresponds to the controlType field in the OpenFMB SetPoint structure.
* `unit` - Corresponds to the unit field in the OpenFMB SetPoint structure. See OpenFMB IDL for possible values.
* `multiplier` - Corresponds to the unit multiplier field in the OpenFMB SetPoint structure. See OpenFMB IDL for possible values.

The mapping element can also contain a transform.

Example:

```xml
<SetpointFromSetPointMappings>
    <Mapping index="1" adapterName="PowerHub_Control" controlType="SetRealPower" unit="W" multiplier="kilo">
        <fmb:transform>
            <fmb:scale multiplier="1000" offset="0.0"/>
        </fmb:transform>
    </Mapping>
</SetpointFromSetPointMappings>
```