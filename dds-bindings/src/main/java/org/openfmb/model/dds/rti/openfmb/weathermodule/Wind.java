

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.weathermodule;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class Wind   implements Copyable, Serializable{

    public org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind directionUnit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind speedUnit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
    public org.openfmb.model.dds.rti.openfmb.weathermodule.SequenceOfWindData windData = (org.openfmb.model.dds.rti.openfmb.weathermodule.SequenceOfWindData)org.openfmb.model.dds.rti.openfmb.weathermodule.SequenceOfWindData.create();

    public Wind() {

    }
    public Wind (Wind other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        Wind self;
        self = new  Wind();
        self.clear();
        return self;

    }

    public void clear() {

        directionUnit = org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
        speedUnit = org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
        if (windData != null) {
            windData.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        Wind otherObj = (Wind)o;

        if(!directionUnit.equals(otherObj.directionUnit)) {
            return false;
        }
        if(!speedUnit.equals(otherObj.speedUnit)) {
            return false;
        }
        if(!windData.equals(otherObj.windData)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += directionUnit.hashCode(); 
        __result += speedUnit.hashCode(); 
        __result += windData.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>WindTypeSupport</code>
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

        Wind typedSrc = (Wind) src;
        Wind typedDst = this;

        typedDst.directionUnit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind) typedDst.directionUnit.copy_from(typedSrc.directionUnit);
        typedDst.speedUnit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind) typedDst.speedUnit.copy_from(typedSrc.speedUnit);
        typedDst.windData = (org.openfmb.model.dds.rti.openfmb.weathermodule.SequenceOfWindData) typedDst.windData.copy_from(typedSrc.windData);

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

        strBuffer.append(directionUnit.toString("directionUnit ", indent+1));
        strBuffer.append(speedUnit.toString("speedUnit ", indent+1));
        strBuffer.append(windData.toString("windData ", indent+1));

        return strBuffer.toString();
    }

}
