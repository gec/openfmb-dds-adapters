

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

public class Reading   implements Copyable, Serializable{

    public String source=  "" ; /* maximum length = (255) */
    public float value= 0;
    public org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type qualityFlag = (org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type)org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.ReadingType readingType = (org.openfmb.model.dds.rti.openfmb.commonmodule.ReadingType)org.openfmb.model.dds.rti.openfmb.commonmodule.ReadingType.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeInterval timePeriod = (org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeInterval)org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeInterval.create();

    public Reading() {

    }
    public Reading (Reading other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        Reading self;
        self = new  Reading();
        self.clear();
        return self;

    }

    public void clear() {

        source=  ""; 
        value= 0;
        if (qualityFlag != null) {
            qualityFlag.clear();
        }
        if (readingType != null) {
            readingType.clear();
        }
        if (timePeriod != null) {
            timePeriod.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        Reading otherObj = (Reading)o;

        if(!source.equals(otherObj.source)) {
            return false;
        }
        if(value != otherObj.value) {
            return false;
        }
        if(!qualityFlag.equals(otherObj.qualityFlag)) {
            return false;
        }
        if(!readingType.equals(otherObj.readingType)) {
            return false;
        }
        if(!timePeriod.equals(otherObj.timePeriod)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += source.hashCode(); 
        __result += (int)value;
        __result += qualityFlag.hashCode(); 
        __result += readingType.hashCode(); 
        __result += timePeriod.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>ReadingTypeSupport</code>
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

        Reading typedSrc = (Reading) src;
        Reading typedDst = this;

        typedDst.source = typedSrc.source;
        typedDst.value = typedSrc.value;
        typedDst.qualityFlag = (org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type) typedDst.qualityFlag.copy_from(typedSrc.qualityFlag);
        typedDst.readingType = (org.openfmb.model.dds.rti.openfmb.commonmodule.ReadingType) typedDst.readingType.copy_from(typedSrc.readingType);
        typedDst.timePeriod = (org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeInterval) typedDst.timePeriod.copy_from(typedSrc.timePeriod);

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
        strBuffer.append("source: ").append(source).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("value: ").append(value).append("\n");  
        strBuffer.append(qualityFlag.toString("qualityFlag ", indent+1));
        strBuffer.append(readingType.toString("readingType ", indent+1));
        strBuffer.append(timePeriod.toString("timePeriod ", indent+1));

        return strBuffer.toString();
    }

}
