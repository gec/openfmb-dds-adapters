

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.commonmodule;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class ForecastSchedule  extends org.openfmb.model.dds.rti.openfmb.commonmodule.BasicIntervalSchedule implements Copyable, Serializable{

    public String version=  "" ; /* maximum length = (255) */
    public long versionDateTime= 0;
    public org.openfmb.model.dds.rti.openfmb.commonmodule.SequenceOfForecastScheduleIrregularTimePoints irregularTimePoints = (org.openfmb.model.dds.rti.openfmb.commonmodule.SequenceOfForecastScheduleIrregularTimePoints)org.openfmb.model.dds.rti.openfmb.commonmodule.SequenceOfForecastScheduleIrregularTimePoints.create();

    public ForecastSchedule() {

        super();

    }
    public ForecastSchedule (ForecastSchedule other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        ForecastSchedule self;
        self = new  ForecastSchedule();
        self.clear();
        return self;

    }

    public void clear() {

        super.clear();
        version=  ""; 
        versionDateTime= 0;
        if (irregularTimePoints != null) {
            irregularTimePoints.clear();
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

        ForecastSchedule otherObj = (ForecastSchedule)o;

        if(!version.equals(otherObj.version)) {
            return false;
        }
        if(versionDateTime != otherObj.versionDateTime) {
            return false;
        }
        if(!irregularTimePoints.equals(otherObj.irregularTimePoints)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;

        __result = super.hashCode();
        __result += version.hashCode(); 
        __result += (int)versionDateTime;
        __result += irregularTimePoints.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>ForecastScheduleTypeSupport</code>
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

        ForecastSchedule typedSrc = (ForecastSchedule) src;
        ForecastSchedule typedDst = this;
        super.copy_from(typedSrc);
        typedDst.version = typedSrc.version;
        typedDst.versionDateTime = typedSrc.versionDateTime;
        typedDst.irregularTimePoints = (org.openfmb.model.dds.rti.openfmb.commonmodule.SequenceOfForecastScheduleIrregularTimePoints) typedDst.irregularTimePoints.copy_from(typedSrc.irregularTimePoints);

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
        strBuffer.append("version: ").append(version).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("versionDateTime: ").append(versionDateTime).append("\n");  
        strBuffer.append(irregularTimePoints.toString("irregularTimePoints ", indent+1));

        return strBuffer.toString();
    }

}
