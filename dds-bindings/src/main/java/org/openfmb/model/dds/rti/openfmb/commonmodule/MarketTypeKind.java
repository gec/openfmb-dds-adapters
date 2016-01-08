

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.commonmodule;

import com.rti.dds.util.Enum;
import com.rti.dds.cdr.CdrHelper;
import java.util.Arrays;
import java.io.ObjectStreamException;

public class MarketTypeKind  extends Enum {

    public static final MarketTypeKind DAM = new MarketTypeKind("DAM", 0);
    public static final int _DAM = 0;
    public static final MarketTypeKind HAM = new MarketTypeKind("HAM", 1);
    public static final int _HAM = 1;
    public static final MarketTypeKind RTM = new MarketTypeKind("RTM", 2);
    public static final int _RTM = 2;
    public static final MarketTypeKind RUC = new MarketTypeKind("RUC", 3);
    public static final int _RUC = 3;
    public static MarketTypeKind valueOf(int ordinal) {
        switch(ordinal) {

            case 0: return MarketTypeKind.DAM;
            case 1: return MarketTypeKind.HAM;
            case 2: return MarketTypeKind.RTM;
            case 3: return MarketTypeKind.RUC;

        }
        return null;
    }

    public static MarketTypeKind from_int(int __value) {
        return valueOf(__value);
    }

    public static int[] getOrdinals() {
        int i = 0;
        int[] values = new int[4];

        values[i] = DAM.ordinal();
        i++;
        values[i] = HAM.ordinal();
        i++;
        values[i] = RTM.ordinal();
        i++;
        values[i] = RUC.ordinal();
        i++;

        return values;
    }

    public int value() {
        return super.ordinal();
    }

    /**
    * Create a default instance
    */  
    public static MarketTypeKind create() {

        return valueOf(0);
    }

    /**
    * Print Method
    */     
    public String toString(String desc, int indent) {
        StringBuffer strBuffer = new StringBuffer();

        CdrHelper.printIndent(strBuffer, indent);

        if (desc != null) {
            strBuffer.append(desc).append(": ");
        }

        strBuffer.append(this);
        strBuffer.append("\n");              
        return strBuffer.toString();
    }

    private Object readResolve() throws ObjectStreamException {
        return valueOf(ordinal());
    }

    private MarketTypeKind(String name, int ordinal) {
        super(name, ordinal);
    }
}

