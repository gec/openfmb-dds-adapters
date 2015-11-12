

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.batterymodule;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class BatteryControlProfile   implements Copyable, Serializable{

    public String logicalDeviceID=  "" ; /* maximum length = (255) */
    public long timestamp= 0;
    public org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystem batterySystem = (org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystem)org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystem.create();
    public org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystemControl batterySystemControl = (org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystemControl)org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystemControl.create();

    public BatteryControlProfile() {

    }
    public BatteryControlProfile (BatteryControlProfile other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        BatteryControlProfile self;
        self = new  BatteryControlProfile();
        self.clear();
        return self;

    }

    public void clear() {

        logicalDeviceID=  ""; 
        timestamp= 0;
        if (batterySystem != null) {
            batterySystem.clear();
        }
        if (batterySystemControl != null) {
            batterySystemControl.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        BatteryControlProfile otherObj = (BatteryControlProfile)o;

        if(!logicalDeviceID.equals(otherObj.logicalDeviceID)) {
            return false;
        }
        if(timestamp != otherObj.timestamp) {
            return false;
        }
        if(!batterySystem.equals(otherObj.batterySystem)) {
            return false;
        }
        if(!batterySystemControl.equals(otherObj.batterySystemControl)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += logicalDeviceID.hashCode(); 
        __result += (int)timestamp;
        __result += batterySystem.hashCode(); 
        __result += batterySystemControl.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>BatteryControlProfileTypeSupport</code>
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

        BatteryControlProfile typedSrc = (BatteryControlProfile) src;
        BatteryControlProfile typedDst = this;

        typedDst.logicalDeviceID = typedSrc.logicalDeviceID;
        typedDst.timestamp = typedSrc.timestamp;
        typedDst.batterySystem = (org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystem) typedDst.batterySystem.copy_from(typedSrc.batterySystem);
        typedDst.batterySystemControl = (org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystemControl) typedDst.batterySystemControl.copy_from(typedSrc.batterySystemControl);

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
        strBuffer.append(batterySystem.toString("batterySystem ", indent+1));
        strBuffer.append(batterySystemControl.toString("batterySystemControl ", indent+1));

        return strBuffer.toString();
    }

}
