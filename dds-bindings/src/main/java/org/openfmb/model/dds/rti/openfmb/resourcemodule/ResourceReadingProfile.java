

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.resourcemodule;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class ResourceReadingProfile  extends org.openfmb.model.dds.rti.openfmb.commonmodule.Container implements Copyable, Serializable{

    public org.openfmb.model.dds.rti.openfmb.commonmodule.Meter meter = (org.openfmb.model.dds.rti.openfmb.commonmodule.Meter)org.openfmb.model.dds.rti.openfmb.commonmodule.Meter.create();
    public org.openfmb.model.dds.rti.openfmb.resourcemodule.SequenceOfResourceReadings readings = (org.openfmb.model.dds.rti.openfmb.resourcemodule.SequenceOfResourceReadings)org.openfmb.model.dds.rti.openfmb.resourcemodule.SequenceOfResourceReadings.create();

    public ResourceReadingProfile() {

        super();

    }
    public ResourceReadingProfile (ResourceReadingProfile other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        ResourceReadingProfile self;
        self = new  ResourceReadingProfile();
        self.clear();
        return self;

    }

    public void clear() {

        super.clear();
        if (meter != null) {
            meter.clear();
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

        ResourceReadingProfile otherObj = (ResourceReadingProfile)o;

        if(!meter.equals(otherObj.meter)) {
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
        __result += meter.hashCode(); 
        __result += readings.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>ResourceReadingProfileTypeSupport</code>
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

        ResourceReadingProfile typedSrc = (ResourceReadingProfile) src;
        ResourceReadingProfile typedDst = this;
        super.copy_from(typedSrc);
        typedDst.meter = (org.openfmb.model.dds.rti.openfmb.commonmodule.Meter) typedDst.meter.copy_from(typedSrc.meter);
        typedDst.readings = (org.openfmb.model.dds.rti.openfmb.resourcemodule.SequenceOfResourceReadings) typedDst.readings.copy_from(typedSrc.readings);

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

        strBuffer.append(meter.toString("meter ", indent+1));
        strBuffer.append(readings.toString("readings ", indent+1));

        return strBuffer.toString();
    }

}
