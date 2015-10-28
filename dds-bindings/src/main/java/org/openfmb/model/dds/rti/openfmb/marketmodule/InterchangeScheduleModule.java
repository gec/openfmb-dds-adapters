

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

public class InterchangeScheduleModule   implements Copyable, Serializable{

    public String scheduleID=  "" ; /* maximum length = (255) */
    public long timestamp= 0;
    public org.openfmb.model.dds.rti.openfmb.marketmodule.InterchangeSchedule interchangeSchedule = (org.openfmb.model.dds.rti.openfmb.marketmodule.InterchangeSchedule)org.openfmb.model.dds.rti.openfmb.marketmodule.InterchangeSchedule.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.PowerSystemResource powerSystemResource = (org.openfmb.model.dds.rti.openfmb.commonmodule.PowerSystemResource)org.openfmb.model.dds.rti.openfmb.commonmodule.PowerSystemResource.create();

    public InterchangeScheduleModule() {

    }
    public InterchangeScheduleModule (InterchangeScheduleModule other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        InterchangeScheduleModule self;
        self = new  InterchangeScheduleModule();
        self.clear();
        return self;

    }

    public void clear() {

        scheduleID=  ""; 
        timestamp= 0;
        if (interchangeSchedule != null) {
            interchangeSchedule.clear();
        }
        if (powerSystemResource != null) {
            powerSystemResource.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        InterchangeScheduleModule otherObj = (InterchangeScheduleModule)o;

        if(!scheduleID.equals(otherObj.scheduleID)) {
            return false;
        }
        if(timestamp != otherObj.timestamp) {
            return false;
        }
        if(!interchangeSchedule.equals(otherObj.interchangeSchedule)) {
            return false;
        }
        if(!powerSystemResource.equals(otherObj.powerSystemResource)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += scheduleID.hashCode(); 
        __result += (int)timestamp;
        __result += interchangeSchedule.hashCode(); 
        __result += powerSystemResource.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>InterchangeScheduleModuleTypeSupport</code>
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

        InterchangeScheduleModule typedSrc = (InterchangeScheduleModule) src;
        InterchangeScheduleModule typedDst = this;

        typedDst.scheduleID = typedSrc.scheduleID;
        typedDst.timestamp = typedSrc.timestamp;
        typedDst.interchangeSchedule = (org.openfmb.model.dds.rti.openfmb.marketmodule.InterchangeSchedule) typedDst.interchangeSchedule.copy_from(typedSrc.interchangeSchedule);
        typedDst.powerSystemResource = (org.openfmb.model.dds.rti.openfmb.commonmodule.PowerSystemResource) typedDst.powerSystemResource.copy_from(typedSrc.powerSystemResource);

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
        strBuffer.append("scheduleID: ").append(scheduleID).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("timestamp: ").append(timestamp).append("\n");  
        strBuffer.append(interchangeSchedule.toString("interchangeSchedule ", indent+1));
        strBuffer.append(powerSystemResource.toString("powerSystemResource ", indent+1));

        return strBuffer.toString();
    }

}