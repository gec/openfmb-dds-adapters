
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.interchangemodule;

import com.rti.dds.typecode.*;

public class  InterchangeScheduleTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        ValueMember sm[]=new ValueMember[5];

        sm[__i]=new  ValueMember("directionType", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.InterTieDirectionKindTypeCode.VALUE,13 , false);__i++;
        sm[__i]=new  ValueMember("energyType", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.MarketProductTypeKindTypeCode.VALUE,14 , false);__i++;
        sm[__i]=new  ValueMember("intervalLength", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) TypeCode.TC_LONG,15 , false);__i++;
        sm[__i]=new  ValueMember("scheduleType", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.EnergyProductTypeKindTypeCode.VALUE,16 , false);__i++;
        sm[__i]=new  ValueMember("optimizedMicroGridMarket", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.interchangemodule.OptimizedMicroGridMarketTypeCode.VALUE,17 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_value_tc("openfmb::interchangemodule::InterchangeSchedule",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY, VM_NONE.VALUE,org.openfmb.model.dds.rti.openfmb.commonmodule.CurveTypeCode.VALUE, sm);        
        return tc;
    }
}

