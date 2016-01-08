
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.weathermodule;

import com.rti.dds.typecode.*;

public class  WeatherDataTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[8];

        sm[__i]=new  StructMember("interval", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),0 , false);__i++;
        sm[__i]=new  StructMember("source", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),1 , false);__i++;
        sm[__i]=new  StructMember("version", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),2 , false);__i++;
        sm[__i]=new  StructMember("versionDateTime", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeTypeTypeCode.VALUE,3 , false);__i++;
        sm[__i]=new  StructMember("humidity", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.weathermodule.HumidityTypeCode.VALUE,4 , false);__i++;
        sm[__i]=new  StructMember("sunRadiation", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.weathermodule.SunRadiationTypeCode.VALUE,5 , false);__i++;
        sm[__i]=new  StructMember("temperature", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.weathermodule.TemperatureTypeCode.VALUE,6 , false);__i++;
        sm[__i]=new  StructMember("wind", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.weathermodule.WindTypeCode.VALUE,7 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("openfmb::weathermodule::WeatherData",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);        
        return tc;
    }
}

