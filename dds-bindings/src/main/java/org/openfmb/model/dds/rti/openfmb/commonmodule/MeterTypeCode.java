
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.commonmodule;

import com.rti.dds.typecode.*;

public class  MeterTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        ValueMember sm[]=new ValueMember[1];

        sm[__i]=new  ValueMember("powerSystemResource", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.PowerSystemResourceTypeCode.VALUE,3 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_value_tc("openfmb::commonmodule::Meter",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY, VM_NONE.VALUE,org.openfmb.model.dds.rti.openfmb.commonmodule.IdentifiedObjectTypeCode.VALUE, sm);        
        return tc;
    }
}

