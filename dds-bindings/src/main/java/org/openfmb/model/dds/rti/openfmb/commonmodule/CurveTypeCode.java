
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.commonmodule;

import com.rti.dds.typecode.*;

public class  CurveTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        ValueMember sm[]=new ValueMember[10];

        sm[__i]=new  ValueMember("curveStyle", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.CurveStyleKindTypeCode.VALUE,3 , false);__i++;
        sm[__i]=new  ValueMember("xMultiplier", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKindTypeCode.VALUE,4 , false);__i++;
        sm[__i]=new  ValueMember("xUnit", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKindTypeCode.VALUE,5 , false);__i++;
        sm[__i]=new  ValueMember("y1Multiplier", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKindTypeCode.VALUE,6 , false);__i++;
        sm[__i]=new  ValueMember("y1Unit", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKindTypeCode.VALUE,7 , false);__i++;
        sm[__i]=new  ValueMember("y2Multiplier", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKindTypeCode.VALUE,8 , false);__i++;
        sm[__i]=new  ValueMember("y2Unit", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKindTypeCode.VALUE,9 , false);__i++;
        sm[__i]=new  ValueMember("y3Multiplier", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKindTypeCode.VALUE,10 , false);__i++;
        sm[__i]=new  ValueMember("y3Unit", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKindTypeCode.VALUE,11 , false);__i++;
        sm[__i]=new  ValueMember("curveData", false, (short)-1,  false,PUBLIC_MEMBER.VALUE,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.SequenceOfCurveDataTypeCode.VALUE,12 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_value_tc("openfmb::commonmodule::Curve",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY, VM_NONE.VALUE,org.openfmb.model.dds.rti.openfmb.commonmodule.IdentifiedObjectTypeCode.VALUE, sm);        
        return tc;
    }
}

