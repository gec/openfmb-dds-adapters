

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.solarmodule;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class SolarControlModule   implements Copyable, Serializable{

    public String logicalDeviceID=  "" ; /* maximum length = (255) */
    public long timestamp= 0;
    public org.openfmb.model.dds.rti.openfmb.solarmodule.SolarControl solarControl = (org.openfmb.model.dds.rti.openfmb.solarmodule.SolarControl)org.openfmb.model.dds.rti.openfmb.solarmodule.SolarControl.create();
    public org.openfmb.model.dds.rti.openfmb.solarmodule.SolarInverter solarInverter = (org.openfmb.model.dds.rti.openfmb.solarmodule.SolarInverter)org.openfmb.model.dds.rti.openfmb.solarmodule.SolarInverter.create();

    public SolarControlModule() {

    }
    public SolarControlModule (SolarControlModule other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        SolarControlModule self;
        self = new  SolarControlModule();
        self.clear();
        return self;

    }

    public void clear() {

        logicalDeviceID=  ""; 
        timestamp= 0;
        if (solarControl != null) {
            solarControl.clear();
        }
        if (solarInverter != null) {
            solarInverter.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        SolarControlModule otherObj = (SolarControlModule)o;

        if(!logicalDeviceID.equals(otherObj.logicalDeviceID)) {
            return false;
        }
        if(timestamp != otherObj.timestamp) {
            return false;
        }
        if(!solarControl.equals(otherObj.solarControl)) {
            return false;
        }
        if(!solarInverter.equals(otherObj.solarInverter)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += logicalDeviceID.hashCode(); 
        __result += (int)timestamp;
        __result += solarControl.hashCode(); 
        __result += solarInverter.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>SolarControlModuleTypeSupport</code>
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

        SolarControlModule typedSrc = (SolarControlModule) src;
        SolarControlModule typedDst = this;

        typedDst.logicalDeviceID = typedSrc.logicalDeviceID;
        typedDst.timestamp = typedSrc.timestamp;
        typedDst.solarControl = (org.openfmb.model.dds.rti.openfmb.solarmodule.SolarControl) typedDst.solarControl.copy_from(typedSrc.solarControl);
        typedDst.solarInverter = (org.openfmb.model.dds.rti.openfmb.solarmodule.SolarInverter) typedDst.solarInverter.copy_from(typedSrc.solarInverter);

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
        strBuffer.append("logicalDeviceID: ").append(logicalDeviceID).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("timestamp: ").append(timestamp).append("\n");  
        strBuffer.append(solarControl.toString("solarControl ", indent+1));
        strBuffer.append(solarInverter.toString("solarInverter ", indent+1));

        return strBuffer.toString();
    }

}
