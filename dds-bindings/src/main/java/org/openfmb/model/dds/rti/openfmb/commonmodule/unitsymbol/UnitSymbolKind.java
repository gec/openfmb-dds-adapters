

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol;

import com.rti.dds.util.Enum;
import com.rti.dds.cdr.CdrHelper;
import java.util.Arrays;
import java.io.ObjectStreamException;

public class UnitSymbolKind  extends Enum {

    public static final UnitSymbolKind Amp = new UnitSymbolKind("Amp", 0);
    public static final int _Amp = 0;
    public static final UnitSymbolKind deg = new UnitSymbolKind("deg", 1);
    public static final int _deg = 1;
    public static final UnitSymbolKind degC = new UnitSymbolKind("degC", 2);
    public static final int _degC = 2;
    public static final UnitSymbolKind Farad = new UnitSymbolKind("Farad", 3);
    public static final int _Farad = 3;
    public static final UnitSymbolKind gram = new UnitSymbolKind("gram", 4);
    public static final int _gram = 4;
    public static final UnitSymbolKind hour = new UnitSymbolKind("hour", 5);
    public static final int _hour = 5;
    public static final UnitSymbolKind Henry = new UnitSymbolKind("Henry", 6);
    public static final int _Henry = 6;
    public static final UnitSymbolKind Hz = new UnitSymbolKind("Hz", 7);
    public static final int _Hz = 7;
    public static final UnitSymbolKind Joule = new UnitSymbolKind("Joule", 8);
    public static final int _Joule = 8;
    public static final UnitSymbolKind meter = new UnitSymbolKind("meter", 9);
    public static final int _meter = 9;
    public static final UnitSymbolKind m2 = new UnitSymbolKind("m2", 10);
    public static final int _m2 = 10;
    public static final UnitSymbolKind m3 = new UnitSymbolKind("m3", 11);
    public static final int _m3 = 11;
    public static final UnitSymbolKind min = new UnitSymbolKind("min", 12);
    public static final int _min = 12;
    public static final UnitSymbolKind Newton = new UnitSymbolKind("Newton", 13);
    public static final int _Newton = 13;
    public static final UnitSymbolKind none = new UnitSymbolKind("none", 14);
    public static final int _none = 14;
    public static final UnitSymbolKind ohm = new UnitSymbolKind("ohm", 15);
    public static final int _ohm = 15;
    public static final UnitSymbolKind Pa = new UnitSymbolKind("Pa", 16);
    public static final int _Pa = 16;
    public static final UnitSymbolKind rad = new UnitSymbolKind("rad", 17);
    public static final int _rad = 17;
    public static final UnitSymbolKind Siemens = new UnitSymbolKind("Siemens", 18);
    public static final int _Siemens = 18;
    public static final UnitSymbolKind sec = new UnitSymbolKind("sec", 19);
    public static final int _sec = 19;
    public static final UnitSymbolKind V = new UnitSymbolKind("V", 20);
    public static final int _V = 20;
    public static final UnitSymbolKind VA = new UnitSymbolKind("VA", 21);
    public static final int _VA = 21;
    public static final UnitSymbolKind VAh = new UnitSymbolKind("VAh", 22);
    public static final int _VAh = 22;
    public static final UnitSymbolKind VAr = new UnitSymbolKind("VAr", 23);
    public static final int _VAr = 23;
    public static final UnitSymbolKind VArh = new UnitSymbolKind("VArh", 24);
    public static final int _VArh = 24;
    public static final UnitSymbolKind W = new UnitSymbolKind("W", 25);
    public static final int _W = 25;
    public static final UnitSymbolKind Wh = new UnitSymbolKind("Wh", 26);
    public static final int _Wh = 26;
    public static final UnitSymbolKind wPerVA = new UnitSymbolKind("wPerVA", 27);
    public static final int _wPerVA = 27;
    public static UnitSymbolKind valueOf(int ordinal) {
        switch(ordinal) {

            case 0: return UnitSymbolKind.Amp;
            case 1: return UnitSymbolKind.deg;
            case 2: return UnitSymbolKind.degC;
            case 3: return UnitSymbolKind.Farad;
            case 4: return UnitSymbolKind.gram;
            case 5: return UnitSymbolKind.hour;
            case 6: return UnitSymbolKind.Henry;
            case 7: return UnitSymbolKind.Hz;
            case 8: return UnitSymbolKind.Joule;
            case 9: return UnitSymbolKind.meter;
            case 10: return UnitSymbolKind.m2;
            case 11: return UnitSymbolKind.m3;
            case 12: return UnitSymbolKind.min;
            case 13: return UnitSymbolKind.Newton;
            case 14: return UnitSymbolKind.none;
            case 15: return UnitSymbolKind.ohm;
            case 16: return UnitSymbolKind.Pa;
            case 17: return UnitSymbolKind.rad;
            case 18: return UnitSymbolKind.Siemens;
            case 19: return UnitSymbolKind.sec;
            case 20: return UnitSymbolKind.V;
            case 21: return UnitSymbolKind.VA;
            case 22: return UnitSymbolKind.VAh;
            case 23: return UnitSymbolKind.VAr;
            case 24: return UnitSymbolKind.VArh;
            case 25: return UnitSymbolKind.W;
            case 26: return UnitSymbolKind.Wh;
            case 27: return UnitSymbolKind.wPerVA;

        }
        return null;
    }

    public static UnitSymbolKind from_int(int __value) {
        return valueOf(__value);
    }

    public static int[] getOrdinals() {
        int i = 0;
        int[] values = new int[28];

        values[i] = Amp.ordinal();
        i++;
        values[i] = deg.ordinal();
        i++;
        values[i] = degC.ordinal();
        i++;
        values[i] = Farad.ordinal();
        i++;
        values[i] = gram.ordinal();
        i++;
        values[i] = hour.ordinal();
        i++;
        values[i] = Henry.ordinal();
        i++;
        values[i] = Hz.ordinal();
        i++;
        values[i] = Joule.ordinal();
        i++;
        values[i] = meter.ordinal();
        i++;
        values[i] = m2.ordinal();
        i++;
        values[i] = m3.ordinal();
        i++;
        values[i] = min.ordinal();
        i++;
        values[i] = Newton.ordinal();
        i++;
        values[i] = none.ordinal();
        i++;
        values[i] = ohm.ordinal();
        i++;
        values[i] = Pa.ordinal();
        i++;
        values[i] = rad.ordinal();
        i++;
        values[i] = Siemens.ordinal();
        i++;
        values[i] = sec.ordinal();
        i++;
        values[i] = V.ordinal();
        i++;
        values[i] = VA.ordinal();
        i++;
        values[i] = VAh.ordinal();
        i++;
        values[i] = VAr.ordinal();
        i++;
        values[i] = VArh.ordinal();
        i++;
        values[i] = W.ordinal();
        i++;
        values[i] = Wh.ordinal();
        i++;
        values[i] = wPerVA.ordinal();
        i++;

        return values;
    }

    public int value() {
        return super.ordinal();
    }

    /**
    * Create a default instance
    */  
    public static UnitSymbolKind create() {

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

    private UnitSymbolKind(String name, int ordinal) {
        super(name, ordinal);
    }
}

