

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.commonmodule;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class BasicIntervalSchedule   implements Copyable, Serializable{

    public long startTime= 0;
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind value1Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind value1Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind value2Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind value2Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();

    public BasicIntervalSchedule() {

    }
    public BasicIntervalSchedule (BasicIntervalSchedule other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        BasicIntervalSchedule self;
        self = new  BasicIntervalSchedule();
        self.clear();
        return self;

    }

    public void clear() {

        startTime= 0;
        value1Multiplier = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
        value1Unit = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
        value2Multiplier = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
        value2Unit = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        BasicIntervalSchedule otherObj = (BasicIntervalSchedule)o;

        if(startTime != otherObj.startTime) {
            return false;
        }
        if(!value1Multiplier.equals(otherObj.value1Multiplier)) {
            return false;
        }
        if(!value1Unit.equals(otherObj.value1Unit)) {
            return false;
        }
        if(!value2Multiplier.equals(otherObj.value2Multiplier)) {
            return false;
        }
        if(!value2Unit.equals(otherObj.value2Unit)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)startTime;
        __result += value1Multiplier.hashCode(); 
        __result += value1Unit.hashCode(); 
        __result += value2Multiplier.hashCode(); 
        __result += value2Unit.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>BasicIntervalScheduleTypeSupport</code>
    * rather than here by using the <code>-noCopyable</code> option
    * to rtiddsgen.
    * 
    * @param src The Object which contains the data to be copied.
    * @return Returns <code>this</code>.
    * @exception NullPointerException If <code>src</code> is null.
    * @exception ClassCastException If <code>src</code> is not the 
    * same type as <code>this</code>.
    * @see com.rti.dds.infrastructure.Copyable#copy_from(java.lang.Object)
    */
    public Object copy_from(Object src) {

        BasicIntervalSchedule typedSrc = (BasicIntervalSchedule) src;
        BasicIntervalSchedule typedDst = this;

        typedDst.startTime = typedSrc.startTime;
        typedDst.value1Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind) typedDst.value1Multiplier.copy_from(typedSrc.value1Multiplier);
        typedDst.value1Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind) typedDst.value1Unit.copy_from(typedSrc.value1Unit);
        typedDst.value2Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind) typedDst.value2Multiplier.copy_from(typedSrc.value2Multiplier);
        typedDst.value2Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind) typedDst.value2Unit.copy_from(typedSrc.value2Unit);

        return this;
    }

    public String toString(){
        return toString("", 0);
    }

    public String toString(String desc, int indent) {
        StringBuffer strBuffer = new StringBuffer();        

        if (desc != null) {
            CdrHelper.printIndent(strBuffer, indent);
            strBuffer.append(desc).append(":\n");
        }

        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("startTime: ").append(startTime).append("\n");  
        strBuffer.append(value1Multiplier.toString("value1Multiplier ", indent+1));
        strBuffer.append(value1Unit.toString("value1Unit ", indent+1));
        strBuffer.append(value2Multiplier.toString("value2Multiplier ", indent+1));
        strBuffer.append(value2Unit.toString("value2Unit ", indent+1));

        return strBuffer.toString();
    }

}
