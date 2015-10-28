

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

public class EndDeviceControlType   implements Copyable, Serializable{

    public String action=  "" ; /* maximum length = (255) */
    public String type=  "" ; /* maximum length = (255) */

    public EndDeviceControlType() {

    }
    public EndDeviceControlType (EndDeviceControlType other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        EndDeviceControlType self;
        self = new  EndDeviceControlType();
        self.clear();
        return self;

    }

    public void clear() {

        action=  ""; 
        type=  ""; 
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        EndDeviceControlType otherObj = (EndDeviceControlType)o;

        if(!action.equals(otherObj.action)) {
            return false;
        }
        if(!type.equals(otherObj.type)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += action.hashCode(); 
        __result += type.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>EndDeviceControlTypeTypeSupport</code>
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

        EndDeviceControlType typedSrc = (EndDeviceControlType) src;
        EndDeviceControlType typedDst = this;

        typedDst.action = typedSrc.action;
        typedDst.type = typedSrc.type;

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
        strBuffer.append("action: ").append(action).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("type: ").append(type).append("\n");  

        return strBuffer.toString();
    }

}
