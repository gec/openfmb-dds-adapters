
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.marketmodule;

import com.rti.dds.typecode.*;

public class  OptimizedMicroGridMarketTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[15];

        sm[__i]=new  StructMember("mRID", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UuidTypeTypeCode.VALUE,0 , false);__i++;
        sm[__i]=new  StructMember("actualEnd", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeTypeTypeCode.VALUE,1 , false);__i++;
        sm[__i]=new  StructMember("actualStart", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeTypeTypeCode.VALUE,2 , false);__i++;
        sm[__i]=new  StructMember("description", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),3 , false);__i++;
        sm[__i]=new  StructMember("dst", false, (short)-1,  false,(TypeCode) TypeCode.TC_BOOLEAN,4 , false);__i++;
        sm[__i]=new  StructMember("end", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeTypeTypeCode.VALUE,5 , false);__i++;
        sm[__i]=new  StructMember("localTimeZone", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),6 , false);__i++;
        sm[__i]=new  StructMember("name", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),7 , false);__i++;
        sm[__i]=new  StructMember("start", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeTypeTypeCode.VALUE,8 , false);__i++;
        sm[__i]=new  StructMember("status", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),9 , false);__i++;
        sm[__i]=new  StructMember("timeIntervalLength", false, (short)-1,  false,(TypeCode) TypeCode.TC_FLOAT,10 , false);__i++;
        sm[__i]=new  StructMember("tradingDay", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeTypeTypeCode.VALUE,11 , false);__i++;
        sm[__i]=new  StructMember("tradingPeriod", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),12 , false);__i++;
        sm[__i]=new  StructMember("marketFactors", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.marketmodule.SequenceOfOptimizedMicroGridMarketMarketFactorsTypeCode.VALUE,13 , false);__i++;
        sm[__i]=new  StructMember("marketRuns", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.marketmodule.SequenceOfOptimizedMicroGridMarketMarketRunsTypeCode.VALUE,14 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("openfmb::marketmodule::OptimizedMicroGridMarket",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);        
        return tc;
    }
}

