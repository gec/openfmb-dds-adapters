

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

public class DateTimeInterval   implements Copyable, Serializable{

    public long end= 0;
    public long start= 0;

    public DateTimeInterval() {

    }
    public DateTimeInterval (DateTimeInterval other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        DateTimeInterval self;
        self = new  DateTimeInterval();
        self.clear();
        return self;

    }

    public void clear() {

        end= 0;
        start= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        DateTimeInterval otherObj = (DateTimeInterval)o;

        if(end != otherObj.end) {
            return false;
        }
        if(start != otherObj.start) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)end;
        __result += (int)start;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>DateTimeIntervalTypeSupport</code>
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

        DateTimeInterval typedSrc = (DateTimeInterval) src;
        DateTimeInterval typedDst = this;

        typedDst.end = typedSrc.end;
        typedDst.start = typedSrc.start;

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
        strBuffer.append("end: ").append(end).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("start: ").append(start).append("\n");  

        return strBuffer.toString();
    }

}
