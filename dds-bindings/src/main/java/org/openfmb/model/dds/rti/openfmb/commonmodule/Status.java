

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

public class Status   implements Copyable, Serializable{

    public long timestamp= 0;
    public String value=  "" ; /* maximum length = (255) */
    public org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type qualityFlag = (org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type)org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type.create();

    public Status() {

    }
    public Status (Status other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        Status self;
        self = new  Status();
        self.clear();
        return self;

    }

    public void clear() {

        timestamp= 0;
        value=  ""; 
        if (qualityFlag != null) {
            qualityFlag.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        Status otherObj = (Status)o;

        if(timestamp != otherObj.timestamp) {
            return false;
        }
        if(!value.equals(otherObj.value)) {
            return false;
        }
        if(!qualityFlag.equals(otherObj.qualityFlag)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)timestamp;
        __result += value.hashCode(); 
        __result += qualityFlag.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>StatusTypeSupport</code>
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

        Status typedSrc = (Status) src;
        Status typedDst = this;

        typedDst.timestamp = typedSrc.timestamp;
        typedDst.value = typedSrc.value;
        typedDst.qualityFlag = (org.openfmb.model.dds.rti.openfmb.commonmodule.HexBinary16Type) typedDst.qualityFlag.copy_from(typedSrc.qualityFlag);

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
        strBuffer.append("timestamp: ").append(timestamp).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("value: ").append(value).append("\n");  
        strBuffer.append(qualityFlag.toString("qualityFlag ", indent+1));

        return strBuffer.toString();
    }

}
