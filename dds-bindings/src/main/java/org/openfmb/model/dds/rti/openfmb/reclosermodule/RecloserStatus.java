

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.reclosermodule;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class RecloserStatus  extends org.openfmb.model.dds.rti.openfmb.commonmodule.Status implements Copyable, Serializable{

    public boolean isBlocked= false;
    public org.openfmb.model.dds.rti.openfmb.commonmodule.SwitchStatusKind switchStatus = (org.openfmb.model.dds.rti.openfmb.commonmodule.SwitchStatusKind)org.openfmb.model.dds.rti.openfmb.commonmodule.SwitchStatusKind.create();

    public RecloserStatus() {

        super();

    }
    public RecloserStatus (RecloserStatus other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        RecloserStatus self;
        self = new  RecloserStatus();
        self.clear();
        return self;

    }

    public void clear() {

        super.clear();
        isBlocked= false;
        switchStatus = org.openfmb.model.dds.rti.openfmb.commonmodule.SwitchStatusKind.create();
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

        RecloserStatus otherObj = (RecloserStatus)o;

        if(isBlocked != otherObj.isBlocked) {
            return false;
        }
        if(!switchStatus.equals(otherObj.switchStatus)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;

        __result = super.hashCode();
        __result += (isBlocked == true)?1:0;
        __result += switchStatus.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>RecloserStatusTypeSupport</code>
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

        RecloserStatus typedSrc = (RecloserStatus) src;
        RecloserStatus typedDst = this;
        super.copy_from(typedSrc);
        typedDst.isBlocked = typedSrc.isBlocked;
        typedDst.switchStatus = (org.openfmb.model.dds.rti.openfmb.commonmodule.SwitchStatusKind) typedDst.switchStatus.copy_from(typedSrc.switchStatus);

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
        strBuffer.append("isBlocked: ").append(isBlocked).append("\n");  
        strBuffer.append(switchStatus.toString("switchStatus ", indent+1));

        return strBuffer.toString();
    }

}
