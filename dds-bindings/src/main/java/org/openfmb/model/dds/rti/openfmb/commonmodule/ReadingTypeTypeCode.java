
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.commonmodule;

import com.rti.dds.typecode.*;

public class  ReadingTypeTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[5];

        sm[__i]=new  StructMember("multiplier", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKindTypeCode.VALUE,0 , false);__i++;
        sm[__i]=new  StructMember("name", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),1 , false);__i++;
        sm[__i]=new  StructMember("unit", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKindTypeCode.VALUE,2 , false);__i++;
        sm[__i]=new  StructMember("flowDirection", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.FlowDirectionKindTypeCode.VALUE,3 , false);__i++;
        sm[__i]=new  StructMember("phases", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.PhaseCodeKindTypeCode.VALUE,4 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("openfmb::commonmodule::ReadingType",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);        
        return tc;
    }
}

