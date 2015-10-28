
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.marketmodule;

import com.rti.dds.typecode.*;

public class  InterchangeScheduleTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[17];

        sm[__i]=new  StructMember("mRID", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.UuidTypeTypeCode.VALUE,0 , false);__i++;
        sm[__i]=new  StructMember("curveStyle", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.CurveStyleKindTypeCode.VALUE,1 , false);__i++;
        sm[__i]=new  StructMember("description", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),2 , false);__i++;
        sm[__i]=new  StructMember("directionType", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.marketmodule.InterTieDirectionKindTypeCode.VALUE,3 , false);__i++;
        sm[__i]=new  StructMember("energyType", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.marketmodule.MarketProductTypeKindTypeCode.VALUE,4 , false);__i++;
        sm[__i]=new  StructMember("intervalLength", false, (short)-1,  false,(TypeCode) TypeCode.TC_LONG,5 , false);__i++;
        sm[__i]=new  StructMember("name", false, (short)-1,  false,(TypeCode) new TypeCode(TCKind.TK_STRING,255),6 , false);__i++;
        sm[__i]=new  StructMember("scheduleType", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.marketmodule.EnergyProductTypeKindTypeCode.VALUE,7 , false);__i++;
        sm[__i]=new  StructMember("xMultiplier", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKindTypeCode.VALUE,8 , false);__i++;
        sm[__i]=new  StructMember("xUnit", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKindTypeCode.VALUE,9 , false);__i++;
        sm[__i]=new  StructMember("y1Multiplier", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKindTypeCode.VALUE,10 , false);__i++;
        sm[__i]=new  StructMember("y1Unit", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKindTypeCode.VALUE,11 , false);__i++;
        sm[__i]=new  StructMember("y2Multiplier", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKindTypeCode.VALUE,12 , false);__i++;
        sm[__i]=new  StructMember("y2Unit", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKindTypeCode.VALUE,13 , false);__i++;
        sm[__i]=new  StructMember("y3Multiplier", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKindTypeCode.VALUE,14 , false);__i++;
        sm[__i]=new  StructMember("y3Unit", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKindTypeCode.VALUE,15 , false);__i++;
        sm[__i]=new  StructMember("optimizedMicroGridMarket", false, (short)-1,  false,(TypeCode) org.openfmb.model.dds.rti.openfmb.marketmodule.OptimizedMicroGridMarketTypeCode.VALUE,16 , false);__i++;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("openfmb::marketmodule::InterchangeSchedule",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm);        
        return tc;
    }
}

