

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.marketmodule;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class OptimizedMicroGridMarket   implements Copyable, Serializable{

    public String mRID=  "" ; /* maximum length = (255) */
    public long actualEnd= 0;
    public long actualStart= 0;
    public String description=  "" ; /* maximum length = (255) */
    public boolean dst= false;
    public long end= 0;
    public String localTimeZone=  "" ; /* maximum length = (255) */
    public String name=  "" ; /* maximum length = (255) */
    public long start= 0;
    public String status=  "" ; /* maximum length = (255) */
    public float timeIntervalLength= 0;
    public long tradingDay= 0;
    public String tradingPeriod=  "" ; /* maximum length = (255) */
    public org.openfmb.model.dds.rti.openfmb.marketmodule.SequenceOfOptimizedMicroGridMarketMarketFactors marketFactors = (org.openfmb.model.dds.rti.openfmb.marketmodule.SequenceOfOptimizedMicroGridMarketMarketFactors)org.openfmb.model.dds.rti.openfmb.marketmodule.SequenceOfOptimizedMicroGridMarketMarketFactors.create();
    public org.openfmb.model.dds.rti.openfmb.marketmodule.SequenceOfOptimizedMicroGridMarketMarketRuns marketRuns = (org.openfmb.model.dds.rti.openfmb.marketmodule.SequenceOfOptimizedMicroGridMarketMarketRuns)org.openfmb.model.dds.rti.openfmb.marketmodule.SequenceOfOptimizedMicroGridMarketMarketRuns.create();

    public OptimizedMicroGridMarket() {

    }
    public OptimizedMicroGridMarket (OptimizedMicroGridMarket other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        OptimizedMicroGridMarket self;
        self = new  OptimizedMicroGridMarket();
        self.clear();
        return self;

    }

    public void clear() {

        mRID=  ""; 
        actualEnd= 0;
        actualStart= 0;
        description=  ""; 
        dst= false;
        end= 0;
        localTimeZone=  ""; 
        name=  ""; 
        start= 0;
        status=  ""; 
        timeIntervalLength= 0;
        tradingDay= 0;
        tradingPeriod=  ""; 
        if (marketFactors != null) {
            marketFactors.clear();
        }
        if (marketRuns != null) {
            marketRuns.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        OptimizedMicroGridMarket otherObj = (OptimizedMicroGridMarket)o;

        if(!mRID.equals(otherObj.mRID)) {
            return false;
        }
        if(actualEnd != otherObj.actualEnd) {
            return false;
        }
        if(actualStart != otherObj.actualStart) {
            return false;
        }
        if(!description.equals(otherObj.description)) {
            return false;
        }
        if(dst != otherObj.dst) {
            return false;
        }
        if(end != otherObj.end) {
            return false;
        }
        if(!localTimeZone.equals(otherObj.localTimeZone)) {
            return false;
        }
        if(!name.equals(otherObj.name)) {
            return false;
        }
        if(start != otherObj.start) {
            return false;
        }
        if(!status.equals(otherObj.status)) {
            return false;
        }
        if(timeIntervalLength != otherObj.timeIntervalLength) {
            return false;
        }
        if(tradingDay != otherObj.tradingDay) {
            return false;
        }
        if(!tradingPeriod.equals(otherObj.tradingPeriod)) {
            return false;
        }
        if(!marketFactors.equals(otherObj.marketFactors)) {
            return false;
        }
        if(!marketRuns.equals(otherObj.marketRuns)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += mRID.hashCode(); 
        __result += (int)actualEnd;
        __result += (int)actualStart;
        __result += description.hashCode(); 
        __result += (dst == true)?1:0;
        __result += (int)end;
        __result += localTimeZone.hashCode(); 
        __result += name.hashCode(); 
        __result += (int)start;
        __result += status.hashCode(); 
        __result += (int)timeIntervalLength;
        __result += (int)tradingDay;
        __result += tradingPeriod.hashCode(); 
        __result += marketFactors.hashCode(); 
        __result += marketRuns.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>OptimizedMicroGridMarketTypeSupport</code>
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

        OptimizedMicroGridMarket typedSrc = (OptimizedMicroGridMarket) src;
        OptimizedMicroGridMarket typedDst = this;

        typedDst.mRID = typedSrc.mRID;
        typedDst.actualEnd = typedSrc.actualEnd;
        typedDst.actualStart = typedSrc.actualStart;
        typedDst.description = typedSrc.description;
        typedDst.dst = typedSrc.dst;
        typedDst.end = typedSrc.end;
        typedDst.localTimeZone = typedSrc.localTimeZone;
        typedDst.name = typedSrc.name;
        typedDst.start = typedSrc.start;
        typedDst.status = typedSrc.status;
        typedDst.timeIntervalLength = typedSrc.timeIntervalLength;
        typedDst.tradingDay = typedSrc.tradingDay;
        typedDst.tradingPeriod = typedSrc.tradingPeriod;
        typedDst.marketFactors = (org.openfmb.model.dds.rti.openfmb.marketmodule.SequenceOfOptimizedMicroGridMarketMarketFactors) typedDst.marketFactors.copy_from(typedSrc.marketFactors);
        typedDst.marketRuns = (org.openfmb.model.dds.rti.openfmb.marketmodule.SequenceOfOptimizedMicroGridMarketMarketRuns) typedDst.marketRuns.copy_from(typedSrc.marketRuns);

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
        strBuffer.append("mRID: ").append(mRID).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("actualEnd: ").append(actualEnd).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("actualStart: ").append(actualStart).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("description: ").append(description).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("dst: ").append(dst).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("end: ").append(end).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("localTimeZone: ").append(localTimeZone).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("name: ").append(name).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("start: ").append(start).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("status: ").append(status).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("timeIntervalLength: ").append(timeIntervalLength).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("tradingDay: ").append(tradingDay).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("tradingPeriod: ").append(tradingPeriod).append("\n");  
        strBuffer.append(marketFactors.toString("marketFactors ", indent+1));
        strBuffer.append(marketRuns.toString("marketRuns ", indent+1));

        return strBuffer.toString();
    }

}
