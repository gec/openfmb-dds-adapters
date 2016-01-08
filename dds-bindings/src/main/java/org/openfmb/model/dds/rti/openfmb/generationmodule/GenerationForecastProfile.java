

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

public class GenerationForecastProfile  extends org.openfmb.model.dds.rti.openfmb.commonmodule.Container implements Copyable, Serializable{

    public org.openfmb.model.dds.rti.openfmb.commonmodule.ForecastSchedule forecastSchedule = (org.openfmb.model.dds.rti.openfmb.commonmodule.ForecastSchedule)org.openfmb.model.dds.rti.openfmb.commonmodule.ForecastSchedule.create();
    public org.openfmb.model.dds.rti.openfmb.generationmodule.GeneratingUnit generatingUnit = (org.openfmb.model.dds.rti.openfmb.generationmodule.GeneratingUnit)org.openfmb.model.dds.rti.openfmb.generationmodule.GeneratingUnit.create();

    public GenerationForecastProfile() {

        super();

    }
    public GenerationForecastProfile (GenerationForecastProfile other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        GenerationForecastProfile self;
        self = new  GenerationForecastProfile();
        self.clear();
        return self;

    }

    public void clear() {

        super.clear();
        if (forecastSchedule != null) {
            forecastSchedule.clear();
        }
        if (generatingUnit != null) {
            generatingUnit.clear();
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

        GenerationForecastProfile otherObj = (GenerationForecastProfile)o;

        if(!forecastSchedule.equals(otherObj.forecastSchedule)) {
            return false;
        }
        if(!generatingUnit.equals(otherObj.generatingUnit)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;

        __result = super.hashCode();
        __result += forecastSchedule.hashCode(); 
        __result += generatingUnit.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>GenerationForecastProfileTypeSupport</code>
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

        GenerationForecastProfile typedSrc = (GenerationForecastProfile) src;
        GenerationForecastProfile typedDst = this;
        super.copy_from(typedSrc);
        typedDst.forecastSchedule = (org.openfmb.model.dds.rti.openfmb.commonmodule.ForecastSchedule) typedDst.forecastSchedule.copy_from(typedSrc.forecastSchedule);
        typedDst.generatingUnit = (org.openfmb.model.dds.rti.openfmb.generationmodule.GeneratingUnit) typedDst.generatingUnit.copy_from(typedSrc.generatingUnit);

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

        strBuffer.append(forecastSchedule.toString("forecastSchedule ", indent+1));
        strBuffer.append(generatingUnit.toString("generatingUnit ", indent+1));

        return strBuffer.toString();
    }

}
