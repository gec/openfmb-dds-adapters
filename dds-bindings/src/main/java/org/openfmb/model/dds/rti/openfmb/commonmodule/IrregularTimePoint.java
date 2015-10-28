

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

public class IrregularTimePoint   implements Copyable, Serializable{

    public float value1= 0;
    public float value2= 0;

    public IrregularTimePoint() {

    }
    public IrregularTimePoint (IrregularTimePoint other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        IrregularTimePoint self;
        self = new  IrregularTimePoint();
        self.clear();
        return self;

    }

    public void clear() {

        value1= 0;
        value2= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        IrregularTimePoint otherObj = (IrregularTimePoint)o;

        if(value1 != otherObj.value1) {
            return false;
        }
        if(value2 != otherObj.value2) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)value1;
        __result += (int)value2;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>IrregularTimePointTypeSupport</code>
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

        IrregularTimePoint typedSrc = (IrregularTimePoint) src;
        IrregularTimePoint typedDst = this;

        typedDst.value1 = typedSrc.value1;
        typedDst.value2 = typedSrc.value2;

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
        strBuffer.append("value1: ").append(value1).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("value2: ").append(value2).append("\n");  

        return strBuffer.toString();
    }

}
