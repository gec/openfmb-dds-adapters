
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.interchangemodule;

import com.rti.dds.typecode.*;

public class  MarketTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        ValueMember sm[]=new ValueMember[12];

        sm[__i]=new  ValueMember("actualEnd", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeTypeTypeCode.VALUE,3 , false);__i++;
        sm[__i]=new  ValueMember("actualStart", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeTypeTypeCode.VALUE,4 , false);__i++;
        sm[__i]=new  ValueMember("dst", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) TypeCode.TC_BOOLEAN,5 , false);__i++;
        sm[__i]=new  ValueMember("end", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeTypeTypeCode.VALUE,6 , false);__i++;
        sm[__i]=new  ValueMember("localTimeZone", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) new TypeCode(TCKind.TK_STRING,255),7 , false);__i++;
        sm[__i]=new  ValueMember("start", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeTypeTypeCode.VALUE,8 , false);__i++;
        sm[__i]=new  ValueMember("status", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) new TypeCode(TCKind.TK_STRING,255),9 , false);__i++;
        sm[__i]=new  ValueMember("timeIntervalLength", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) TypeCode.TC_FLOAT,10 , false);__i++;
        sm[__i]=new  ValueMember("tradingDay", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeTypeTypeCode.VALUE,11 , false);__i++;
        sm[__i]=new  ValueMember("tradingPeriod", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) new TypeCode(TCKind.TK_STRING,255),12 , false);__i++;
        sm[__i]=new  ValueMember("marketFactors", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.interchangemodule.SequenceOfMarketFactorsTypeCode.VALUE,13 , false);__i++;
        sm[__i]=new  ValueMember("marketRuns", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.interchangemodule.SequenceOfMarketRunsTypeCode.VALUE,14 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_value_tc("openfmb::interchangemodule::Market",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY, VM_NONE.VALUE,org.openfmb.model.dds.rti.openfmb.commonmodule.IdentifiedObjectTypeCode.VALUE, sm);        
        return tc;
    }
}

