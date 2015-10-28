

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier;

import com.rti.dds.util.Enum;
import com.rti.dds.cdr.CdrHelper;
import java.util.Arrays;
import java.io.ObjectStreamException;

public class UnitMultiplierKind  extends Enum {

    public static final UnitMultiplierKind centi = new UnitMultiplierKind("centi", 0);
    public static final int _centi = 0;
    public static final UnitMultiplierKind deci = new UnitMultiplierKind("deci", 1);
    public static final int _deci = 1;
    public static final UnitMultiplierKind Giga = new UnitMultiplierKind("Giga", 2);
    public static final int _Giga = 2;
    public static final UnitMultiplierKind kilo = new UnitMultiplierKind("kilo", 3);
    public static final int _kilo = 3;
    public static final UnitMultiplierKind Mega = new UnitMultiplierKind("Mega", 4);
    public static final int _Mega = 4;
    public static final UnitMultiplierKind milli = new UnitMultiplierKind("milli", 5);
    public static final int _milli = 5;
    public static final UnitMultiplierKind micro = new UnitMultiplierKind("micro", 6);
    public static final int _micro = 6;
    public static final UnitMultiplierKind nano = new UnitMultiplierKind("nano", 7);
    public static final int _nano = 7;
    public static final UnitMultiplierKind none = new UnitMultiplierKind("none", 8);
    public static final int _none = 8;
    public static final UnitMultiplierKind pico = new UnitMultiplierKind("pico", 9);
    public static final int _pico = 9;
    public static final UnitMultiplierKind Tera = new UnitMultiplierKind("Tera", 10);
    public static final int _Tera = 10;
    public static UnitMultiplierKind valueOf(int ordinal) {
        switch(ordinal) {

            case 0: return UnitMultiplierKind.centi;
            case 1: return UnitMultiplierKind.deci;
            case 2: return UnitMultiplierKind.Giga;
            case 3: return UnitMultiplierKind.kilo;
            case 4: return UnitMultiplierKind.Mega;
            case 5: return UnitMultiplierKind.milli;
            case 6: return UnitMultiplierKind.micro;
            case 7: return UnitMultiplierKind.nano;
            case 8: return UnitMultiplierKind.none;
            case 9: return UnitMultiplierKind.pico;
            case 10: return UnitMultiplierKind.Tera;

        }
        return null;
    }

    public static UnitMultiplierKind from_int(int __value) {
        return valueOf(__value);
    }

    public static int[] getOrdinals() {
        int i = 0;
        int[] values = new int[11];

        values[i] = centi.ordinal();
        i++;
        values[i] = deci.ordinal();
        i++;
        values[i] = Giga.ordinal();
        i++;
        values[i] = kilo.ordinal();
        i++;
        values[i] = Mega.ordinal();
        i++;
        values[i] = milli.ordinal();
        i++;
        values[i] = micro.ordinal();
        i++;
        values[i] = nano.ordinal();
        i++;
        values[i] = none.ordinal();
        i++;
        values[i] = pico.ordinal();
        i++;
        values[i] = Tera.ordinal();
        i++;

        return values;
    }

    public int value() {
        return super.ordinal();
    }

    /**
    * Create a default instance
    */  
    public static UnitMultiplierKind create() {

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

    private UnitMultiplierKind(String name, int ordinal) {
        super(name, ordinal);
    }
}

