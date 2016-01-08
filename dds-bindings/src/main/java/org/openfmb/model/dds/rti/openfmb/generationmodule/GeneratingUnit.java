

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.generationmodule;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class GeneratingUnit  extends org.openfmb.model.dds.rti.openfmb.commonmodule.IdentifiedObject implements Copyable, Serializable{

    public org.openfmb.model.dds.rti.openfmb.commonmodule.ActivePower maxOperatingP = (org.openfmb.model.dds.rti.openfmb.commonmodule.ActivePower)org.openfmb.model.dds.rti.openfmb.commonmodule.ActivePower.create();

    public GeneratingUnit() {

        super();

    }
    public GeneratingUnit (GeneratingUnit other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        GeneratingUnit self;
        self = new  GeneratingUnit();
        self.clear();
        return self;

    }

    public void clear() {

        super.clear();
        if (maxOperatingP != null) {
            maxOperatingP.clear();
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

        GeneratingUnit otherObj = (GeneratingUnit)o;

        if(!maxOperatingP.equals(otherObj.maxOperatingP)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;

        __result = super.hashCode();
        __result += maxOperatingP.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>GeneratingUnitTypeSupport</code>
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

        GeneratingUnit typedSrc = (GeneratingUnit) src;
        GeneratingUnit typedDst = this;
        super.copy_from(typedSrc);
        typedDst.maxOperatingP = (org.openfmb.model.dds.rti.openfmb.commonmodule.ActivePower) typedDst.maxOperatingP.copy_from(typedSrc.maxOperatingP);

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

        strBuffer.append(maxOperatingP.toString("maxOperatingP ", indent+1));

        return strBuffer.toString();
    }

}
