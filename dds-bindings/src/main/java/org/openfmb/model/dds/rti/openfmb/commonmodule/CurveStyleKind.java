

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

public class CurveStyleKind  extends Enum {

    public static final CurveStyleKind constantYValue = new CurveStyleKind("constantYValue", 0);
    public static final int _constantYValue = 0;
    public static final CurveStyleKind straightLineYValues = new CurveStyleKind("straightLineYValues", 1);
    public static final int _straightLineYValues = 1;
    public static CurveStyleKind valueOf(int ordinal) {
        switch(ordinal) {

            case 0: return CurveStyleKind.constantYValue;
            case 1: return CurveStyleKind.straightLineYValues;

        }
        return null;
    }

    public static CurveStyleKind from_int(int __value) {
        return valueOf(__value);
    }

    public static int[] getOrdinals() {
        int i = 0;
        int[] values = new int[2];

        values[i] = constantYValue.ordinal();
        i++;
        values[i] = straightLineYValues.ordinal();
        i++;

        return values;
    }

    public int value() {
        return super.ordinal();
    }

    /**
    * Create a default instance
    */  
    public static CurveStyleKind create() {

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

    private CurveStyleKind(String name, int ordinal) {
        super(name, ordinal);
    }
}

