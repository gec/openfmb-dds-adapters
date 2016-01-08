

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

public class StringMeasurement   implements Copyable, Serializable{

    public String mRID=  "" ; /* maximum length = (255) */
    public String description=  "" ; /* maximum length = (255) */
    public String measurementType=  "" ; /* maximum length = (255) */
    public String name=  "" ; /* maximum length = (255) */
    public org.openfmb.model.dds.rti.openfmb.commonmodule.PhaseCodeKind phases = (org.openfmb.model.dds.rti.openfmb.commonmodule.PhaseCodeKind)org.openfmb.model.dds.rti.openfmb.commonmodule.PhaseCodeKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.StringMeasurementValue value = (org.openfmb.model.dds.rti.openfmb.commonmodule.StringMeasurementValue)org.openfmb.model.dds.rti.openfmb.commonmodule.StringMeasurementValue.create();

    public StringMeasurement() {

    }
    public StringMeasurement (StringMeasurement other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        StringMeasurement self;
        self = new  StringMeasurement();
        self.clear();
        return self;

    }

    public void clear() {

        mRID=  ""; 
        description=  ""; 
        measurementType=  ""; 
        name=  ""; 
        phases = org.openfmb.model.dds.rti.openfmb.commonmodule.PhaseCodeKind.create();
        unit = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
        multiplier = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
        if (value != null) {
            value.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        StringMeasurement otherObj = (StringMeasurement)o;

        if(!mRID.equals(otherObj.mRID)) {
            return false;
        }
        if(!description.equals(otherObj.description)) {
            return false;
        }
        if(!measurementType.equals(otherObj.measurementType)) {
            return false;
        }
        if(!name.equals(otherObj.name)) {
            return false;
        }
        if(!phases.equals(otherObj.phases)) {
            return false;
        }
        if(!unit.equals(otherObj.unit)) {
            return false;
        }
        if(!multiplier.equals(otherObj.multiplier)) {
            return false;
        }
        if(!value.equals(otherObj.value)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += mRID.hashCode(); 
        __result += description.hashCode(); 
        __result += measurementType.hashCode(); 
        __result += name.hashCode(); 
        __result += phases.hashCode(); 
        __result += unit.hashCode(); 
        __result += multiplier.hashCode(); 
        __result += value.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>StringMeasurementTypeSupport</code>
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

        StringMeasurement typedSrc = (StringMeasurement) src;
        StringMeasurement typedDst = this;

        typedDst.mRID = typedSrc.mRID;
        typedDst.description = typedSrc.description;
        typedDst.measurementType = typedSrc.measurementType;
        typedDst.name = typedSrc.name;
        typedDst.phases = (org.openfmb.model.dds.rti.openfmb.commonmodule.PhaseCodeKind) typedDst.phases.copy_from(typedSrc.phases);
        typedDst.unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind) typedDst.unit.copy_from(typedSrc.unit);
        typedDst.multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind) typedDst.multiplier.copy_from(typedSrc.multiplier);
        typedDst.value = (org.openfmb.model.dds.rti.openfmb.commonmodule.StringMeasurementValue) typedDst.value.copy_from(typedSrc.value);

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
        strBuffer.append("mRID: ").append(mRID).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("description: ").append(description).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("measurementType: ").append(measurementType).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("name: ").append(name).append("\n");  
        strBuffer.append(phases.toString("phases ", indent+1));
        strBuffer.append(unit.toString("unit ", indent+1));
        strBuffer.append(multiplier.toString("multiplier ", indent+1));
        strBuffer.append(value.toString("value ", indent+1));

        return strBuffer.toString();
    }

}
