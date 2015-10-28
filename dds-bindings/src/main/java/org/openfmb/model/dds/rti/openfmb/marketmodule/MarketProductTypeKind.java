

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.marketmodule;

import com.rti.dds.util.Enum;
import com.rti.dds.cdr.CdrHelper;
import java.util.Arrays;
import java.io.ObjectStreamException;

public class MarketProductTypeKind  extends Enum {

    public static final MarketProductTypeKind EN = new MarketProductTypeKind("EN", 0);
    public static final int _EN = 0;
    public static final MarketProductTypeKind LFU = new MarketProductTypeKind("LFU", 1);
    public static final int _LFU = 1;
    public static final MarketProductTypeKind NR = new MarketProductTypeKind("NR", 2);
    public static final int _NR = 2;
    public static final MarketProductTypeKind RC = new MarketProductTypeKind("RC", 3);
    public static final int _RC = 3;
    public static final MarketProductTypeKind RD = new MarketProductTypeKind("RD", 4);
    public static final int _RD = 4;
    public static final MarketProductTypeKind REG = new MarketProductTypeKind("REG", 5);
    public static final int _REG = 5;
    public static final MarketProductTypeKind RU = new MarketProductTypeKind("RU", 6);
    public static final int _RU = 6;
    public static final MarketProductTypeKind SR = new MarketProductTypeKind("SR", 7);
    public static final int _SR = 7;
    public static MarketProductTypeKind valueOf(int ordinal) {
        switch(ordinal) {

            case 0: return MarketProductTypeKind.EN;
            case 1: return MarketProductTypeKind.LFU;
            case 2: return MarketProductTypeKind.NR;
            case 3: return MarketProductTypeKind.RC;
            case 4: return MarketProductTypeKind.RD;
            case 5: return MarketProductTypeKind.REG;
            case 6: return MarketProductTypeKind.RU;
            case 7: return MarketProductTypeKind.SR;

        }
        return null;
    }

    public static MarketProductTypeKind from_int(int __value) {
        return valueOf(__value);
    }

    public static int[] getOrdinals() {
        int i = 0;
        int[] values = new int[8];

        values[i] = EN.ordinal();
        i++;
        values[i] = LFU.ordinal();
        i++;
        values[i] = NR.ordinal();
        i++;
        values[i] = RC.ordinal();
        i++;
        values[i] = RD.ordinal();
        i++;
        values[i] = REG.ordinal();
        i++;
        values[i] = RU.ordinal();
        i++;
        values[i] = SR.ordinal();
        i++;

        return values;
    }

    public int value() {
        return super.ordinal();
    }

    /**
    * Create a default instance
    */  
    public static MarketProductTypeKind create() {

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

    private MarketProductTypeKind(String name, int ordinal) {
        super(name, ordinal);
    }
}

