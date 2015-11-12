

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

public class WindData   implements Copyable, Serializable{

    public long timestamp= 0;
    public float windDirection= 0;
    public float windSpeed= 0;

    public WindData() {

    }
    public WindData (WindData other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        WindData self;
        self = new  WindData();
        self.clear();
        return self;

    }

    public void clear() {

        timestamp= 0;
        windDirection= 0;
        windSpeed= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        WindData otherObj = (WindData)o;

        if(timestamp != otherObj.timestamp) {
            return false;
        }
        if(windDirection != otherObj.windDirection) {
            return false;
        }
        if(windSpeed != otherObj.windSpeed) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)timestamp;
        __result += (int)windDirection;
        __result += (int)windSpeed;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>WindDataTypeSupport</code>
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

        WindData typedSrc = (WindData) src;
        WindData typedDst = this;

        typedDst.timestamp = typedSrc.timestamp;
        typedDst.windDirection = typedSrc.windDirection;
        typedDst.windSpeed = typedSrc.windSpeed;

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
        strBuffer.append("windDirection: ").append(windDirection).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("windSpeed: ").append(windSpeed).append("\n");  

        return strBuffer.toString();
    }

}
