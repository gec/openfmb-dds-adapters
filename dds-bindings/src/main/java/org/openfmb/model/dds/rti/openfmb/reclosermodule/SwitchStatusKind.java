

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.reclosermodule;

import com.rti.dds.util.Enum;
import com.rti.dds.cdr.CdrHelper;
import java.util.Arrays;
import java.io.ObjectStreamException;

public class SwitchStatusKind  extends Enum {

    public static final SwitchStatusKind Closed = new SwitchStatusKind("Closed", 0);
    public static final int _Closed = 0;
    public static final SwitchStatusKind Open = new SwitchStatusKind("Open", 1);
    public static final int _Open = 1;
    public static SwitchStatusKind valueOf(int ordinal) {
        switch(ordinal) {

            case 0: return SwitchStatusKind.Closed;
            case 1: return SwitchStatusKind.Open;

        }
        return null;
    }

    public static SwitchStatusKind from_int(int __value) {
        return valueOf(__value);
    }

    public static int[] getOrdinals() {
        int i = 0;
        int[] values = new int[2];

        values[i] = Closed.ordinal();
        i++;
        values[i] = Open.ordinal();
        i++;

        return values;
    }

    public int value() {
        return super.ordinal();
    }

    /**
    * Create a default instance
    */  
    public static SwitchStatusKind create() {

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

    private SwitchStatusKind(String name, int ordinal) {
        super(name, ordinal);
    }
}

