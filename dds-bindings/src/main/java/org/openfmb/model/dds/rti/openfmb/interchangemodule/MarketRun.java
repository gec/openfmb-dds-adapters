

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

public class MarketRun   implements Copyable, Serializable{

    public org.openfmb.model.dds.rti.openfmb.commonmodule.ExecutionTypeKind executionType = (org.openfmb.model.dds.rti.openfmb.commonmodule.ExecutionTypeKind)org.openfmb.model.dds.rti.openfmb.commonmodule.ExecutionTypeKind.create();
    public long marketEndTime= 0;
    public String marketID=  "" ; /* maximum length = (255) */
    public String marketRunID=  "" ; /* maximum length = (255) */
    public long marketStartTime= 0;
    public org.openfmb.model.dds.rti.openfmb.commonmodule.MarketTypeKind marketType = (org.openfmb.model.dds.rti.openfmb.commonmodule.MarketTypeKind)org.openfmb.model.dds.rti.openfmb.commonmodule.MarketTypeKind.create();

    public MarketRun() {

    }
    public MarketRun (MarketRun other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        MarketRun self;
        self = new  MarketRun();
        self.clear();
        return self;

    }

    public void clear() {

        executionType = org.openfmb.model.dds.rti.openfmb.commonmodule.ExecutionTypeKind.create();
        marketEndTime= 0;
        marketID=  ""; 
        marketRunID=  ""; 
        marketStartTime= 0;
        marketType = org.openfmb.model.dds.rti.openfmb.commonmodule.MarketTypeKind.create();
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        MarketRun otherObj = (MarketRun)o;

        if(!executionType.equals(otherObj.executionType)) {
            return false;
        }
        if(marketEndTime != otherObj.marketEndTime) {
            return false;
        }
        if(!marketID.equals(otherObj.marketID)) {
            return false;
        }
        if(!marketRunID.equals(otherObj.marketRunID)) {
            return false;
        }
        if(marketStartTime != otherObj.marketStartTime) {
            return false;
        }
        if(!marketType.equals(otherObj.marketType)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += executionType.hashCode(); 
        __result += (int)marketEndTime;
        __result += marketID.hashCode(); 
        __result += marketRunID.hashCode(); 
        __result += (int)marketStartTime;
        __result += marketType.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>MarketRunTypeSupport</code>
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

        MarketRun typedSrc = (MarketRun) src;
        MarketRun typedDst = this;

        typedDst.executionType = (org.openfmb.model.dds.rti.openfmb.commonmodule.ExecutionTypeKind) typedDst.executionType.copy_from(typedSrc.executionType);
        typedDst.marketEndTime = typedSrc.marketEndTime;
        typedDst.marketID = typedSrc.marketID;
        typedDst.marketRunID = typedSrc.marketRunID;
        typedDst.marketStartTime = typedSrc.marketStartTime;
        typedDst.marketType = (org.openfmb.model.dds.rti.openfmb.commonmodule.MarketTypeKind) typedDst.marketType.copy_from(typedSrc.marketType);

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

        strBuffer.append(executionType.toString("executionType ", indent+1));
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("marketEndTime: ").append(marketEndTime).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("marketID: ").append(marketID).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("marketRunID: ").append(marketRunID).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("marketStartTime: ").append(marketStartTime).append("\n");  
        strBuffer.append(marketType.toString("marketType ", indent+1));

        return strBuffer.toString();
    }

}
