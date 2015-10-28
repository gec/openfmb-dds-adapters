

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

public class GenerationControl   implements Copyable, Serializable{

    public String issueID=  "" ; /* maximum length = (255) */
    public String name=  "" ; /* maximum length = (255) */
    public org.openfmb.model.dds.rti.openfmb.commonmodule.EndDeviceControlType endDeviceControlType = (org.openfmb.model.dds.rti.openfmb.commonmodule.EndDeviceControlType)org.openfmb.model.dds.rti.openfmb.commonmodule.EndDeviceControlType.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeInterval scheduledInterval = (org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeInterval)org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeInterval.create();
    public org.openfmb.model.dds.rti.openfmb.generationmodule.SequenceOfGenerationControlSetPoints setPoints = (org.openfmb.model.dds.rti.openfmb.generationmodule.SequenceOfGenerationControlSetPoints)org.openfmb.model.dds.rti.openfmb.generationmodule.SequenceOfGenerationControlSetPoints.create();

    public GenerationControl() {

    }
    public GenerationControl (GenerationControl other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        GenerationControl self;
        self = new  GenerationControl();
        self.clear();
        return self;

    }

    public void clear() {

        issueID=  ""; 
        name=  ""; 
        if (endDeviceControlType != null) {
            endDeviceControlType.clear();
        }
        if (scheduledInterval != null) {
            scheduledInterval.clear();
        }
        if (setPoints != null) {
            setPoints.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        GenerationControl otherObj = (GenerationControl)o;

        if(!issueID.equals(otherObj.issueID)) {
            return false;
        }
        if(!name.equals(otherObj.name)) {
            return false;
        }
        if(!endDeviceControlType.equals(otherObj.endDeviceControlType)) {
            return false;
        }
        if(!scheduledInterval.equals(otherObj.scheduledInterval)) {
            return false;
        }
        if(!setPoints.equals(otherObj.setPoints)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += issueID.hashCode(); 
        __result += name.hashCode(); 
        __result += endDeviceControlType.hashCode(); 
        __result += scheduledInterval.hashCode(); 
        __result += setPoints.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>GenerationControlTypeSupport</code>
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

        GenerationControl typedSrc = (GenerationControl) src;
        GenerationControl typedDst = this;

        typedDst.issueID = typedSrc.issueID;
        typedDst.name = typedSrc.name;
        typedDst.endDeviceControlType = (org.openfmb.model.dds.rti.openfmb.commonmodule.EndDeviceControlType) typedDst.endDeviceControlType.copy_from(typedSrc.endDeviceControlType);
        typedDst.scheduledInterval = (org.openfmb.model.dds.rti.openfmb.commonmodule.DateTimeInterval) typedDst.scheduledInterval.copy_from(typedSrc.scheduledInterval);
        typedDst.setPoints = (org.openfmb.model.dds.rti.openfmb.generationmodule.SequenceOfGenerationControlSetPoints) typedDst.setPoints.copy_from(typedSrc.setPoints);

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
        strBuffer.append("issueID: ").append(issueID).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("name: ").append(name).append("\n");  
        strBuffer.append(endDeviceControlType.toString("endDeviceControlType ", indent+1));
        strBuffer.append(scheduledInterval.toString("scheduledInterval ", indent+1));
        strBuffer.append(setPoints.toString("setPoints ", indent+1));

        return strBuffer.toString();
    }

}
