
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.commonmodule;

import com.rti.dds.typecode.*;

public class  ForecastScheduleTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[8];

        sm[__i]=new  StructMember("startTime", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeTypeTypeCode.VALUE,0 , false);__i++;
        sm[__i]=new  StructMember("value1Multiplier", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKindTypeCode.VALUE,1 , false);__i++;
        sm[__i]=new  StructMember("value1Unit", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKindTypeCode.VALUE,2 , false);__i++;
        sm[__i]=new  StructMember("value2Multiplier", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKindTypeCode.VALUE,3 , false);__i++;
        sm[__i]=new  StructMember("value2Unit", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKindTypeCode.VALUE,4 , false);__i++;
        sm[__i]=new  StructMember("version", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),5 , false);__i++;
        sm[__i]=new  StructMember("versionDateTime", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeTypeTypeCode.VALUE,6 , false);__i++;
        sm[__i]=new  StructMember("irregularTimePoints", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.SequenceOfForecastScheduleIrregularTimePointsTypeCode.VALUE,7 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("openfmb::commonmodule::ForecastSchedule",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);        
        return tc;
    }
}

