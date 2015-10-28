

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

public class ReadingType   implements Copyable, Serializable{

    public org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind)org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind.create();
    public String name=  "" ; /* maximum length = (255) */
    public org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.flowdirection.FlowDirectionKind flowDirection = (org.openfmb.model.dds.rti.openfmb.commonmodule.flowdirection.FlowDirectionKind)org.openfmb.model.dds.rti.openfmb.commonmodule.flowdirection.FlowDirectionKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.phasecode.PhaseCodeKind phases = (org.openfmb.model.dds.rti.openfmb.commonmodule.phasecode.PhaseCodeKind)org.openfmb.model.dds.rti.openfmb.commonmodule.phasecode.PhaseCodeKind.create();

    public ReadingType() {

    }
    public ReadingType (ReadingType other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        ReadingType self;
        self = new  ReadingType();
        self.clear();
        return self;

    }

    public void clear() {

        multiplier = org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind.create();
        name=  ""; 
        unit = org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
        flowDirection = org.openfmb.model.dds.rti.openfmb.commonmodule.flowdirection.FlowDirectionKind.create();
        phases = org.openfmb.model.dds.rti.openfmb.commonmodule.phasecode.PhaseCodeKind.create();
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        ReadingType otherObj = (ReadingType)o;

        if(!multiplier.equals(otherObj.multiplier)) {
            return false;
        }
        if(!name.equals(otherObj.name)) {
            return false;
        }
        if(!unit.equals(otherObj.unit)) {
            return false;
        }
        if(!flowDirection.equals(otherObj.flowDirection)) {
            return false;
        }
        if(!phases.equals(otherObj.phases)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += multiplier.hashCode(); 
        __result += name.hashCode(); 
        __result += unit.hashCode(); 
        __result += flowDirection.hashCode(); 
        __result += phases.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>ReadingTypeTypeSupport</code>
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

        ReadingType typedSrc = (ReadingType) src;
        ReadingType typedDst = this;

        typedDst.multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind) typedDst.multiplier.copy_from(typedSrc.multiplier);
        typedDst.name = typedSrc.name;
        typedDst.unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind) typedDst.unit.copy_from(typedSrc.unit);
        typedDst.flowDirection = (org.openfmb.model.dds.rti.openfmb.commonmodule.flowdirection.FlowDirectionKind) typedDst.flowDirection.copy_from(typedSrc.flowDirection);
        typedDst.phases = (org.openfmb.model.dds.rti.openfmb.commonmodule.phasecode.PhaseCodeKind) typedDst.phases.copy_from(typedSrc.phases);

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
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("name: ").append(name).append("\n");  
        strBuffer.append(unit.toString("unit ", indent+1));
        strBuffer.append(flowDirection.toString("flowDirection ", indent+1));
        strBuffer.append(phases.toString("phases ", indent+1));

        return strBuffer.toString();
    }

}
