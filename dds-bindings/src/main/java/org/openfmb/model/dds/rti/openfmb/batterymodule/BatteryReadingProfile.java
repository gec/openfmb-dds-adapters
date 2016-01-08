

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

public class BatteryReadingProfile  extends org.openfmb.model.dds.rti.openfmb.commonmodule.Container implements Copyable, Serializable{

    public org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystem batterySystem = (org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystem)org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystem.create();
    public org.openfmb.model.dds.rti.openfmb.batterymodule.SequenceOfBatteryReadings readings = (org.openfmb.model.dds.rti.openfmb.batterymodule.SequenceOfBatteryReadings)org.openfmb.model.dds.rti.openfmb.batterymodule.SequenceOfBatteryReadings.create();

    public BatteryReadingProfile() {

        super();

    }
    public BatteryReadingProfile (BatteryReadingProfile other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        BatteryReadingProfile self;
        self = new  BatteryReadingProfile();
        self.clear();
        return self;

    }

    public void clear() {

        super.clear();
        if (batterySystem != null) {
            batterySystem.clear();
        }
        if (readings != null) {
            readings.clear();
        }
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

        BatteryReadingProfile otherObj = (BatteryReadingProfile)o;

        if(!batterySystem.equals(otherObj.batterySystem)) {
            return false;
        }
        if(!readings.equals(otherObj.readings)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;

        __result = super.hashCode();
        __result += batterySystem.hashCode(); 
        __result += readings.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>BatteryReadingProfileTypeSupport</code>
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

        BatteryReadingProfile typedSrc = (BatteryReadingProfile) src;
        BatteryReadingProfile typedDst = this;
        super.copy_from(typedSrc);
        typedDst.batterySystem = (org.openfmb.model.dds.rti.openfmb.batterymodule.BatterySystem) typedDst.batterySystem.copy_from(typedSrc.batterySystem);
        typedDst.readings = (org.openfmb.model.dds.rti.openfmb.batterymodule.SequenceOfBatteryReadings) typedDst.readings.copy_from(typedSrc.readings);

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

        strBuffer.append(batterySystem.toString("batterySystem ", indent+1));
        strBuffer.append(readings.toString("readings ", indent+1));

        return strBuffer.toString();
    }

}
