
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.interchangemodule;

import com.rti.dds.typecode.*;

public class  SequenceOfMarketFactorsTypeCode {
    public static final TypeCode VALUE = getTypeCode();

    private static TypeCode getTypeCode() {
        TypeCode tc = null;

        tc = TypeCodeFactory.TheTypeCodeFactory.create_alias_tc("openfmb::interchangemodule::SequenceOfMarketFactors", new TypeCode((org.openfmb.model.dds.rti.openfmb.interchangemodule.MaxLengthMarketFactors.VALUE), org.openfmb.model.dds.rti.openfmb.interchangemodule.MarketFactorsTypeCode.VALUE),  false);        
        return tc;
    }
}

