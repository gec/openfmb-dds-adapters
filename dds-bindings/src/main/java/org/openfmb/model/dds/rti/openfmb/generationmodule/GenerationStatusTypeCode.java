
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.generationmodule;

import com.rti.dds.typecode.*;

public class  GenerationStatusTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        ValueMember sm[]=new ValueMember[2];

        sm[__i]=new  ValueMember("isAutoOn", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) TypeCode.TC_BOOLEAN,3 , false);__i++;
        sm[__i]=new  ValueMember("isConnected", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) TypeCode.TC_BOOLEAN,4 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_value_tc("openfmb::generationmodule::GenerationStatus",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY, VM_NONE.VALUE,org.openfmb.model.dds.rti.openfmb.commonmodule.StatusTypeCode.VALUE, sm);        
        return tc;
    }
}

