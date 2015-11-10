OpenFMB DDS Adapters
==========================

Adapters to bridge Modbus and DNP3 devices to the OpenFMB DDS data model.

Running the Adapters
---------------

The default Maven build creates self-contained JAR files for both the Modbus and DNP3 adapters. Each adapter takes an
XML file as a program parameter.

For the Modbus adapter:

    java -cp openfmb-dds-modbus-adapter-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.greenenergycorp.openfmb.dds.modbus.OpenFmbModbusAdapter modbus_config.xml

For the DNP3 adapter:

    java -cp openfmb-dds-dnp3-adapter-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.greenenergycorp.openfmb.dds.dnp3.OpenFmbDnpAdapter dnp3_config.xml


Project Layout
---------------

* **idl/** - Contains the OpenFMB DDS IDL file used to generate DDS bindings.
* **dds-bindings** - Contains the generated Java code for the OpenFMB DDS IDL.
* **adapter-xml** - Contains the XSDs used to configure the Modbus and DNP3 adapters plus the JAXB generated code for that XML.
* **dds-library** - Contains common code for utilizing DDS, mapping data updates to OpenFMB DDS structures, transforming data values, as well as the library of OpenFMB DDS adapters.
* **modbus-adapter** - Entry point for converting data and controls between Modbus masters and OpenFMB DDS adapters.
* **dnp3-adapter** - Entry point for converting data and controls between DNP3 masters and OpenFMB DDS adapters.

SGIP Demo Configuration
---------------

XML configuration from the 2015 SGIP Conference is included as samples:

- openfmb_dnp3_dds.xml
- openfmb_modbus_dds.xml


Maven for RTI Connext DDS
---------------

To use the RTI Connext DDS Java library from the Maven, the DDS Java library must be installed in the local Maven
repository. The *mvn-deploy-rti.sh* shell script will install the library when given the path to the JAR files in
the RTI installation directory.

Example:

    JARPATH=/home/user/rti_connext_dds-5.2.0/lib/java/ ./mvn-deploy-rti.sh


Rebuilding DDS Bindings From IDL
------------------

The *idl_rebuild.sh* shell script will regenerate Java bindings for the OpenFMB schema based on updates to the IDL.
To use it, the path to the *rtiddsgen* utility in the RTI installation directory must be provided.

Example:

    export RTIDDSGEN=/home/user/rti_connext_dds-5.2.0/bin/rtiddsgen
    ./idl_rebuild.sh


External Dependencies
-------------------

[Modbus library](http://github.com/gec/modbus-library)

[OpenDNP3](http://github.com/gec/dnp3) - Note that DNP3 must be built and installed with the Java JNI bindings.