

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

public class StringMeasurementValue   implements Copyable, Serializable{

    public String value=  "" ; /* maximum length = (255) */
    public long timestamp= 0;
    public org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type qualityFlag = (org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type)org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type.create();
    public String source=  "" ; /* maximum length = (255) */

    public StringMeasurementValue() {

    }
    public StringMeasurementValue (StringMeasurementValue other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        StringMeasurementValue self;
        self = new  StringMeasurementValue();
        self.clear();
        return self;

    }

    public void clear() {

        value=  ""; 
        timestamp= 0;
        if (qualityFlag != null) {
            qualityFlag.clear();
        }
        source=  ""; 
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        StringMeasurementValue otherObj = (StringMeasurementValue)o;

        if(!value.equals(otherObj.value)) {
            return false;
        }
        if(timestamp != otherObj.timestamp) {
            return false;
        }
        if(!qualityFlag.equals(otherObj.qualityFlag)) {
            return false;
        }
        if(!source.equals(otherObj.source)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += value.hashCode(); 
        __result += (int)timestamp;
        __result += qualityFlag.hashCode(); 
        __result += source.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>StringMeasurementValueTypeSupport</code>
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

        StringMeasurementValue typedSrc = (StringMeasurementValue) src;
        StringMeasurementValue typedDst = this;

        typedDst.value = typedSrc.value;
        typedDst.timestamp = typedSrc.timestamp;
        typedDst.qualityFlag = (org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type) typedDst.qualityFlag.copy_from(typedSrc.qualityFlag);
        typedDst.source = typedSrc.source;

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
        strBuffer.append("value: ").append(value).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("timestamp: ").append(timestamp).append("\n");  
        strBuffer.append(qualityFlag.toString("qualityFlag ", indent+1));
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("source: ").append(source).append("\n");  

        return strBuffer.toString();
    }

}
