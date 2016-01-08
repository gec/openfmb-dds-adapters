

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

public class BatterySystemControl  extends org.openfmb.model.dds.rti.openfmb.commonmodule.EndDeviceControl implements Copyable, Serializable{

    public boolean isIslanded= false;

    public BatterySystemControl() {

        super();

    }
    public BatterySystemControl (BatterySystemControl other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        BatterySystemControl self;
        self = new  BatterySystemControl();
        self.clear();
        return self;

    }

    public void clear() {

        super.clear();
        isIslanded= false;
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

        BatterySystemControl otherObj = (BatterySystemControl)o;

        if(isIslanded != otherObj.isIslanded) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;

        __result = super.hashCode();
        __result += (isIslanded == true)?1:0;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>BatterySystemControlTypeSupport</code>
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

        BatterySystemControl typedSrc = (BatterySystemControl) src;
        BatterySystemControl typedDst = this;
        super.copy_from(typedSrc);
        typedDst.isIslanded = typedSrc.isIslanded;

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
        strBuffer.append("isIslanded: ").append(isIslanded).append("\n");  

        return strBuffer.toString();
    }

}
