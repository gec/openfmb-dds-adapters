

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

public class BatteryStatus  extends org.openfmb.model.dds.rti.openfmb.commonmodule.Status implements Copyable, Serializable{

    public boolean isCharging= false;
    public boolean isConnected= false;
    public String mode=  "" ; /* maximum length = (255) */
    public float stateOfCharge= 0;

    public BatteryStatus() {

        super();

    }
    public BatteryStatus (BatteryStatus other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        BatteryStatus self;
        self = new  BatteryStatus();
        self.clear();
        return self;

    }

    public void clear() {

        super.clear();
        isCharging= false;
        isConnected= false;
        mode=  ""; 
        stateOfCharge= 0;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if (!super.equals(o)) {
            return false;
        }

        if(getClass() != o.getClass()) {
            return false;
        }

        BatteryStatus otherObj = (BatteryStatus)o;

        if(isCharging != otherObj.isCharging) {
            return false;
        }
        if(isConnected != otherObj.isConnected) {
            return false;
        }
        if(!mode.equals(otherObj.mode)) {
            return false;
        }
        if(stateOfCharge != otherObj.stateOfCharge) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;

        __result = super.hashCode();
        __result += (isCharging == true)?1:0;
        __result += (isConnected == true)?1:0;
        __result += mode.hashCode(); 
        __result += (int)stateOfCharge;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>BatteryStatusTypeSupport</code>
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

        BatteryStatus typedSrc = (BatteryStatus) src;
        BatteryStatus typedDst = this;
        super.copy_from(typedSrc);
        typedDst.isCharging = typedSrc.isCharging;
        typedDst.isConnected = typedSrc.isConnected;
        typedDst.mode = typedSrc.mode;
        typedDst.stateOfCharge = typedSrc.stateOfCharge;

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

        strBuffer.append(super.toString("",indent));

        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("isCharging: ").append(isCharging).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("isConnected: ").append(isConnected).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("mode: ").append(mode).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("stateOfCharge: ").append(stateOfCharge).append("\n");  

        return strBuffer.toString();
    }

}
