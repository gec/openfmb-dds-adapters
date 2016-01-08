
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.weathermodule;

import com.rti.dds.typecode.*;

public class  SunRadiationTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[3];

        sm[__i]=new  StructMember("multiplier", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKindTypeCode.VALUE,0 , false);__i++;
        sm[__i]=new  StructMember("unit", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKindTypeCode.VALUE,1 , false);__i++;
        sm[__i]=new  StructMember("sunRadiationData", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.weathermodule.SequenceOfSunRadiationDataTypeCode.VALUE,2 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("openfmb::weathermodule::SunRadiation",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);        
        return tc;
    }
}

