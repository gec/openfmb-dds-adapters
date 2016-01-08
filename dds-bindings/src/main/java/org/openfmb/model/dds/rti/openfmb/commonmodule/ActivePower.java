

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

public class ActivePower   implements Copyable, Serializable{

    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
    public float value= 0;

    public ActivePower() {

    }
    public ActivePower (ActivePower other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        ActivePower self;
        self = new  ActivePower();
        self.clear();
        return self;

    }

    public void clear() {

        multiplier = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
        unit = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
        value= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        ActivePower otherObj = (ActivePower)o;

        if(!multiplier.equals(otherObj.multiplier)) {
            return false;
        }
        if(!unit.equals(otherObj.unit)) {
            return false;
        }
        if(value != otherObj.value) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += multiplier.hashCode(); 
        __result += unit.hashCode(); 
        __result += (int)value;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>ActivePowerTypeSupport</code>
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

        ActivePower typedSrc = (ActivePower) src;
        ActivePower typedDst = this;

        typedDst.multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind) typedDst.multiplier.copy_from(typedSrc.multiplier);
        typedDst.unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind) typedDst.unit.copy_from(typedSrc.unit);
        typedDst.value = typedSrc.value;

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

        strBuffer.append(multiplier.toString("multiplier ", indent+1));
        strBuffer.append(unit.toString("unit ", indent+1));
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("value: ").append(value).append("\n");  

        return strBuffer.toString();
    }

}
