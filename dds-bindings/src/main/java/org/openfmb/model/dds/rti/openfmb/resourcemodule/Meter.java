

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

public class Meter   implements Copyable, Serializable{

    public String mRID=  "" ; /* maximum length = (255) */
    public String description=  "" ; /* maximum length = (255) */
    public String name=  "" ; /* maximum length = (255) */
    public org.openfmb.model.dds.rti.openfmb.commonmodule.PowerSystemResource powerSystemResource = (org.openfmb.model.dds.rti.openfmb.commonmodule.PowerSystemResource)org.openfmb.model.dds.rti.openfmb.commonmodule.PowerSystemResource.create();

    public Meter() {

    }
    public Meter (Meter other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        Meter self;
        self = new  Meter();
        self.clear();
        return self;

    }

    public void clear() {

        mRID=  ""; 
        description=  ""; 
        name=  ""; 
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

        Meter otherObj = (Meter)o;

        if(!mRID.equals(otherObj.mRID)) {
            return false;
        }
        if(!description.equals(otherObj.description)) {
            return false;
        }
        if(!name.equals(otherObj.name)) {
            return false;
        }
        if(!powerSystemResource.equals(otherObj.powerSystemResource)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += mRID.hashCode(); 
        __result += description.hashCode(); 
        __result += name.hashCode(); 
        __result += powerSystemResource.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>MeterTypeSupport</code>
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

        Meter typedSrc = (Meter) src;
        Meter typedDst = this;

        typedDst.mRID = typedSrc.mRID;
        typedDst.description = typedSrc.description;
        typedDst.name = typedSrc.name;
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
        strBuffer.append("mRID: ").append(mRID).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("description: ").append(description).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("name: ").append(name).append("\n");  
        strBuffer.append(powerSystemResource.toString("powerSystemResource ", indent+1));

        return strBuffer.toString();
    }

}
