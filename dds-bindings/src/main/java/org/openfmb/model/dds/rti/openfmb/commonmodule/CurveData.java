

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

public class CurveData   implements Copyable, Serializable{

    public float xvalue= 0;
    public float y1value= 0;
    public float y2value= 0;
    public float y3value= 0;

    public CurveData() {

    }
    public CurveData (CurveData other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        CurveData self;
        self = new  CurveData();
        self.clear();
        return self;

    }

    public void clear() {

        xvalue= 0;
        y1value= 0;
        y2value= 0;
        y3value= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        CurveData otherObj = (CurveData)o;

        if(xvalue != otherObj.xvalue) {
            return false;
        }
        if(y1value != otherObj.y1value) {
            return false;
        }
        if(y2value != otherObj.y2value) {
            return false;
        }
        if(y3value != otherObj.y3value) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)xvalue;
        __result += (int)y1value;
        __result += (int)y2value;
        __result += (int)y3value;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>CurveDataTypeSupport</code>
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

        CurveData typedSrc = (CurveData) src;
        CurveData typedDst = this;

        typedDst.xvalue = typedSrc.xvalue;
        typedDst.y1value = typedSrc.y1value;
        typedDst.y2value = typedSrc.y2value;
        typedDst.y3value = typedSrc.y3value;

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
        strBuffer.append("xvalue: ").append(xvalue).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("y1value: ").append(y1value).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("y2value: ").append(y2value).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("y3value: ").append(y3value).append("\n");  

        return strBuffer.toString();
    }

}
