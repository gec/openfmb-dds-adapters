

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

public class InterTieDirectionKind  extends Enum {

    public static final InterTieDirectionKind E = new InterTieDirectionKind("E", 0);
    public static final int _E = 0;
    public static final InterTieDirectionKind I = new InterTieDirectionKind("I", 1);
    public static final int _I = 1;
    public static final InterTieDirectionKind NETZERO = new InterTieDirectionKind("NETZERO", 2);
    public static final int _NETZERO = 2;
    public static InterTieDirectionKind valueOf(int ordinal) {
        switch(ordinal) {

            case 0: return InterTieDirectionKind.E;
            case 1: return InterTieDirectionKind.I;
            case 2: return InterTieDirectionKind.NETZERO;

        }
        return null;
    }

    public static InterTieDirectionKind from_int(int __value) {
        return valueOf(__value);
    }

    public static int[] getOrdinals() {
        int i = 0;
        int[] values = new int[3];

        values[i] = E.ordinal();
        i++;
        values[i] = I.ordinal();
        i++;
        values[i] = NETZERO.ordinal();
        i++;

        return values;
    }

    public int value() {
        return super.ordinal();
    }

    /**
    * Create a default instance
    */  
    public static InterTieDirectionKind create() {

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

    private InterTieDirectionKind(String name, int ordinal) {
        super(name, ordinal);
    }
}

