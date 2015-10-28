

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.commonmodule.phasecode;

import com.rti.dds.util.Enum;
import com.rti.dds.cdr.CdrHelper;
import java.util.Arrays;
import java.io.ObjectStreamException;

public class PhaseCodeKind  extends Enum {

    public static final PhaseCodeKind A = new PhaseCodeKind("A", 0);
    public static final int _A = 0;
    public static final PhaseCodeKind AB = new PhaseCodeKind("AB", 1);
    public static final int _AB = 1;
    public static final PhaseCodeKind ABC = new PhaseCodeKind("ABC", 2);
    public static final int _ABC = 2;
    public static final PhaseCodeKind ABCN = new PhaseCodeKind("ABCN", 3);
    public static final int _ABCN = 3;
    public static final PhaseCodeKind ABN = new PhaseCodeKind("ABN", 4);
    public static final int _ABN = 4;
    public static final PhaseCodeKind AC = new PhaseCodeKind("AC", 5);
    public static final int _AC = 5;
    public static final PhaseCodeKind ACN = new PhaseCodeKind("ACN", 6);
    public static final int _ACN = 6;
    public static final PhaseCodeKind AN = new PhaseCodeKind("AN", 7);
    public static final int _AN = 7;
    public static final PhaseCodeKind B = new PhaseCodeKind("B", 8);
    public static final int _B = 8;
    public static final PhaseCodeKind BC = new PhaseCodeKind("BC", 9);
    public static final int _BC = 9;
    public static final PhaseCodeKind BCN = new PhaseCodeKind("BCN", 10);
    public static final int _BCN = 10;
    public static final PhaseCodeKind BN = new PhaseCodeKind("BN", 11);
    public static final int _BN = 11;
    public static final PhaseCodeKind C = new PhaseCodeKind("C", 12);
    public static final int _C = 12;
    public static final PhaseCodeKind CN = new PhaseCodeKind("CN", 13);
    public static final int _CN = 13;
    public static final PhaseCodeKind N = new PhaseCodeKind("N", 14);
    public static final int _N = 14;
    public static final PhaseCodeKind s1 = new PhaseCodeKind("s1", 15);
    public static final int _s1 = 15;
    public static final PhaseCodeKind s12 = new PhaseCodeKind("s12", 16);
    public static final int _s12 = 16;
    public static final PhaseCodeKind s12N = new PhaseCodeKind("s12N", 17);
    public static final int _s12N = 17;
    public static final PhaseCodeKind s1N = new PhaseCodeKind("s1N", 18);
    public static final int _s1N = 18;
    public static final PhaseCodeKind s2 = new PhaseCodeKind("s2", 19);
    public static final int _s2 = 19;
    public static final PhaseCodeKind s2N = new PhaseCodeKind("s2N", 20);
    public static final int _s2N = 20;
    public static PhaseCodeKind valueOf(int ordinal) {
        switch(ordinal) {

            case 0: return PhaseCodeKind.A;
            case 1: return PhaseCodeKind.AB;
            case 2: return PhaseCodeKind.ABC;
            case 3: return PhaseCodeKind.ABCN;
            case 4: return PhaseCodeKind.ABN;
            case 5: return PhaseCodeKind.AC;
            case 6: return PhaseCodeKind.ACN;
            case 7: return PhaseCodeKind.AN;
            case 8: return PhaseCodeKind.B;
            case 9: return PhaseCodeKind.BC;
            case 10: return PhaseCodeKind.BCN;
            case 11: return PhaseCodeKind.BN;
            case 12: return PhaseCodeKind.C;
            case 13: return PhaseCodeKind.CN;
            case 14: return PhaseCodeKind.N;
            case 15: return PhaseCodeKind.s1;
            case 16: return PhaseCodeKind.s12;
            case 17: return PhaseCodeKind.s12N;
            case 18: return PhaseCodeKind.s1N;
            case 19: return PhaseCodeKind.s2;
            case 20: return PhaseCodeKind.s2N;

        }
        return null;
    }

    public static PhaseCodeKind from_int(int __value) {
        return valueOf(__value);
    }

    public static int[] getOrdinals() {
        int i = 0;
        int[] values = new int[21];

        values[i] = A.ordinal();
        i++;
        values[i] = AB.ordinal();
        i++;
        values[i] = ABC.ordinal();
        i++;
        values[i] = ABCN.ordinal();
        i++;
        values[i] = ABN.ordinal();
        i++;
        values[i] = AC.ordinal();
        i++;
        values[i] = ACN.ordinal();
        i++;
        values[i] = AN.ordinal();
        i++;
        values[i] = B.ordinal();
        i++;
        values[i] = BC.ordinal();
        i++;
        values[i] = BCN.ordinal();
        i++;
        values[i] = BN.ordinal();
        i++;
        values[i] = C.ordinal();
        i++;
        values[i] = CN.ordinal();
        i++;
        values[i] = N.ordinal();
        i++;
        values[i] = s1.ordinal();
        i++;
        values[i] = s12.ordinal();
        i++;
        values[i] = s12N.ordinal();
        i++;
        values[i] = s1N.ordinal();
        i++;
        values[i] = s2.ordinal();
        i++;
        values[i] = s2N.ordinal();
        i++;

        return values;
    }

    public int value() {
        return super.ordinal();
    }

    /**
    * Create a default instance
    */  
    public static PhaseCodeKind create() {

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

    private PhaseCodeKind(String name, int ordinal) {
        super(name, ordinal);
    }
}

