

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.commonmodule.flowdirection;

import com.rti.dds.util.Enum;
import com.rti.dds.cdr.CdrHelper;
import java.util.Arrays;
import java.io.ObjectStreamException;

public class FlowDirectionKind  extends Enum {

    public static final FlowDirectionKind forward = new FlowDirectionKind("forward", 0);
    public static final int _forward = 0;
    public static final FlowDirectionKind lagging = new FlowDirectionKind("lagging", 1);
    public static final int _lagging = 1;
    public static final FlowDirectionKind leading = new FlowDirectionKind("leading", 2);
    public static final int _leading = 2;
    public static final FlowDirectionKind net = new FlowDirectionKind("net", 3);
    public static final int _net = 3;
    public static final FlowDirectionKind none = new FlowDirectionKind("none", 4);
    public static final int _none = 4;
    public static final FlowDirectionKind q1minusQ4 = new FlowDirectionKind("q1minusQ4", 5);
    public static final int _q1minusQ4 = 5;
    public static final FlowDirectionKind q1plusQ2 = new FlowDirectionKind("q1plusQ2", 6);
    public static final int _q1plusQ2 = 6;
    public static final FlowDirectionKind q1plusQ3 = new FlowDirectionKind("q1plusQ3", 7);
    public static final int _q1plusQ3 = 7;
    public static final FlowDirectionKind q1plusQ4 = new FlowDirectionKind("q1plusQ4", 8);
    public static final int _q1plusQ4 = 8;
    public static final FlowDirectionKind q2minusQ3 = new FlowDirectionKind("q2minusQ3", 9);
    public static final int _q2minusQ3 = 9;
    public static final FlowDirectionKind q2plusQ3 = new FlowDirectionKind("q2plusQ3", 10);
    public static final int _q2plusQ3 = 10;
    public static final FlowDirectionKind q2plusQ4 = new FlowDirectionKind("q2plusQ4", 11);
    public static final int _q2plusQ4 = 11;
    public static final FlowDirectionKind q3minusQ2 = new FlowDirectionKind("q3minusQ2", 12);
    public static final int _q3minusQ2 = 12;
    public static final FlowDirectionKind q3plusQ4 = new FlowDirectionKind("q3plusQ4", 13);
    public static final int _q3plusQ4 = 13;
    public static final FlowDirectionKind quadrant1 = new FlowDirectionKind("quadrant1", 14);
    public static final int _quadrant1 = 14;
    public static final FlowDirectionKind quadrant2 = new FlowDirectionKind("quadrant2", 15);
    public static final int _quadrant2 = 15;
    public static final FlowDirectionKind quadrant3 = new FlowDirectionKind("quadrant3", 16);
    public static final int _quadrant3 = 16;
    public static final FlowDirectionKind quadrant4 = new FlowDirectionKind("quadrant4", 17);
    public static final int _quadrant4 = 17;
    public static final FlowDirectionKind reverse = new FlowDirectionKind("reverse", 18);
    public static final int _reverse = 18;
    public static final FlowDirectionKind total = new FlowDirectionKind("total", 19);
    public static final int _total = 19;
    public static final FlowDirectionKind totalByPhase = new FlowDirectionKind("totalByPhase", 20);
    public static final int _totalByPhase = 20;
    public static FlowDirectionKind valueOf(int ordinal) {
        switch(ordinal) {

            case 0: return FlowDirectionKind.forward;
            case 1: return FlowDirectionKind.lagging;
            case 2: return FlowDirectionKind.leading;
            case 3: return FlowDirectionKind.net;
            case 4: return FlowDirectionKind.none;
            case 5: return FlowDirectionKind.q1minusQ4;
            case 6: return FlowDirectionKind.q1plusQ2;
            case 7: return FlowDirectionKind.q1plusQ3;
            case 8: return FlowDirectionKind.q1plusQ4;
            case 9: return FlowDirectionKind.q2minusQ3;
            case 10: return FlowDirectionKind.q2plusQ3;
            case 11: return FlowDirectionKind.q2plusQ4;
            case 12: return FlowDirectionKind.q3minusQ2;
            case 13: return FlowDirectionKind.q3plusQ4;
            case 14: return FlowDirectionKind.quadrant1;
            case 15: return FlowDirectionKind.quadrant2;
            case 16: return FlowDirectionKind.quadrant3;
            case 17: return FlowDirectionKind.quadrant4;
            case 18: return FlowDirectionKind.reverse;
            case 19: return FlowDirectionKind.total;
            case 20: return FlowDirectionKind.totalByPhase;

        }
        return null;
    }

    public static FlowDirectionKind from_int(int __value) {
        return valueOf(__value);
    }

    public static int[] getOrdinals() {
        int i = 0;
        int[] values = new int[21];

        values[i] = forward.ordinal();
        i++;
        values[i] = lagging.ordinal();
        i++;
        values[i] = leading.ordinal();
        i++;
        values[i] = net.ordinal();
        i++;
        values[i] = none.ordinal();
        i++;
        values[i] = q1minusQ4.ordinal();
        i++;
        values[i] = q1plusQ2.ordinal();
        i++;
        values[i] = q1plusQ3.ordinal();
        i++;
        values[i] = q1plusQ4.ordinal();
        i++;
        values[i] = q2minusQ3.ordinal();
        i++;
        values[i] = q2plusQ3.ordinal();
        i++;
        values[i] = q2plusQ4.ordinal();
        i++;
        values[i] = q3minusQ2.ordinal();
        i++;
        values[i] = q3plusQ4.ordinal();
        i++;
        values[i] = quadrant1.ordinal();
        i++;
        values[i] = quadrant2.ordinal();
        i++;
        values[i] = quadrant3.ordinal();
        i++;
        values[i] = quadrant4.ordinal();
        i++;
        values[i] = reverse.ordinal();
        i++;
        values[i] = total.ordinal();
        i++;
        values[i] = totalByPhase.ordinal();
        i++;

        return values;
    }

    public int value() {
        return super.ordinal();
    }

    /**
    * Create a default instance
    */  
    public static FlowDirectionKind create() {

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

    private FlowDirectionKind(String name, int ordinal) {
        super(name, ordinal);
    }
}

