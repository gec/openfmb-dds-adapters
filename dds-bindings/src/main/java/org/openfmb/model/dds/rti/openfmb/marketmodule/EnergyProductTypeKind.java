

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

public class EnergyProductTypeKind  extends Enum {

    public static final EnergyProductTypeKind DYN = new EnergyProductTypeKind("DYN", 0);
    public static final int _DYN = 0;
    public static final EnergyProductTypeKind FIRM = new EnergyProductTypeKind("FIRM", 1);
    public static final int _FIRM = 1;
    public static final EnergyProductTypeKind NFRM = new EnergyProductTypeKind("NFRM", 2);
    public static final int _NFRM = 2;
    public static final EnergyProductTypeKind WHL = new EnergyProductTypeKind("WHL", 3);
    public static final int _WHL = 3;
    public static EnergyProductTypeKind valueOf(int ordinal) {
        switch(ordinal) {

            case 0: return EnergyProductTypeKind.DYN;
            case 1: return EnergyProductTypeKind.FIRM;
            case 2: return EnergyProductTypeKind.NFRM;
            case 3: return EnergyProductTypeKind.WHL;

        }
        return null;
    }

    public static EnergyProductTypeKind from_int(int __value) {
        return valueOf(__value);
    }

    public static int[] getOrdinals() {
        int i = 0;
        int[] values = new int[4];

        values[i] = DYN.ordinal();
        i++;
        values[i] = FIRM.ordinal();
        i++;
        values[i] = NFRM.ordinal();
        i++;
        values[i] = WHL.ordinal();
        i++;

        return values;
    }

    public int value() {
        return super.ordinal();
    }

    /**
    * Create a default instance
    */  
    public static EnergyProductTypeKind create() {

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

    private EnergyProductTypeKind(String name, int ordinal) {
        super(name, ordinal);
    }
}

