

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

public class ExecutionTypeKind  extends Enum {

    public static final ExecutionTypeKind DA = new ExecutionTypeKind("DA", 0);
    public static final int _DA = 0;
    public static final ExecutionTypeKind HASP = new ExecutionTypeKind("HASP", 1);
    public static final int _HASP = 1;
    public static final ExecutionTypeKind RTD = new ExecutionTypeKind("RTD", 2);
    public static final int _RTD = 2;
    public static final ExecutionTypeKind RTPD = new ExecutionTypeKind("RTPD", 3);
    public static final int _RTPD = 3;
    public static ExecutionTypeKind valueOf(int ordinal) {
        switch(ordinal) {

            case 0: return ExecutionTypeKind.DA;
            case 1: return ExecutionTypeKind.HASP;
            case 2: return ExecutionTypeKind.RTD;
            case 3: return ExecutionTypeKind.RTPD;

        }
        return null;
    }

    public static ExecutionTypeKind from_int(int __value) {
        return valueOf(__value);
    }

    public static int[] getOrdinals() {
        int i = 0;
        int[] values = new int[4];

        values[i] = DA.ordinal();
        i++;
        values[i] = HASP.ordinal();
        i++;
        values[i] = RTD.ordinal();
        i++;
        values[i] = RTPD.ordinal();
        i++;

        return values;
    }

    public int value() {
        return super.ordinal();
    }

    /**
    * Create a default instance
    */  
    public static ExecutionTypeKind create() {

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

    private ExecutionTypeKind(String name, int ordinal) {
        super(name, ordinal);
    }
}

