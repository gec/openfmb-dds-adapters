

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.interchangemodule;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class MarketFactors   implements Copyable, Serializable{

    public long intervalEndTime= 0;
    public long intervalStartTime= 0;

    public MarketFactors() {

    }
    public MarketFactors (MarketFactors other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        MarketFactors self;
        self = new  MarketFactors();
        self.clear();
        return self;

    }

    public void clear() {

        intervalEndTime= 0;
        intervalStartTime= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        MarketFactors otherObj = (MarketFactors)o;

        if(intervalEndTime != otherObj.intervalEndTime) {
            return false;
        }
        if(intervalStartTime != otherObj.intervalStartTime) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += (int)intervalEndTime;
        __result += (int)intervalStartTime;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>MarketFactorsTypeSupport</code>
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

        MarketFactors typedSrc = (MarketFactors) src;
        MarketFactors typedDst = this;

        typedDst.intervalEndTime = typedSrc.intervalEndTime;
        typedDst.intervalStartTime = typedSrc.intervalStartTime;

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
        strBuffer.append("intervalEndTime: ").append(intervalEndTime).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("intervalStartTime: ").append(intervalStartTime).append("\n");  

        return strBuffer.toString();
    }

}
