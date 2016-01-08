

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.interchangemodule;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class InterchangeSchedule  extends org.openfmb.model.dds.rti.openfmb.commonmodule.Curve implements Copyable, Serializable{

    public org.openfmb.model.dds.rti.openfmb.commonmodule.InterTieDirectionKind directionType = (org.openfmb.model.dds.rti.openfmb.commonmodule.InterTieDirectionKind)org.openfmb.model.dds.rti.openfmb.commonmodule.InterTieDirectionKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.MarketProductTypeKind energyType = (org.openfmb.model.dds.rti.openfmb.commonmodule.MarketProductTypeKind)org.openfmb.model.dds.rti.openfmb.commonmodule.MarketProductTypeKind.create();
    public int intervalLength= 0;
    public org.openfmb.model.dds.rti.openfmb.commonmodule.EnergyProductTypeKind scheduleType = (org.openfmb.model.dds.rti.openfmb.commonmodule.EnergyProductTypeKind)org.openfmb.model.dds.rti.openfmb.commonmodule.EnergyProductTypeKind.create();
    public org.openfmb.model.dds.rti.openfmb.interchangemodule.OptimizedMicroGridMarket optimizedMicroGridMarket = (org.openfmb.model.dds.rti.openfmb.interchangemodule.OptimizedMicroGridMarket)org.openfmb.model.dds.rti.openfmb.interchangemodule.OptimizedMicroGridMarket.create();

    public InterchangeSchedule() {

        super();

    }
    public InterchangeSchedule (InterchangeSchedule other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        InterchangeSchedule self;
        self = new  InterchangeSchedule();
        self.clear();
        return self;

    }

    public void clear() {

        super.clear();
        directionType = org.openfmb.model.dds.rti.openfmb.commonmodule.InterTieDirectionKind.create();
        energyType = org.openfmb.model.dds.rti.openfmb.commonmodule.MarketProductTypeKind.create();
        intervalLength= 0;
        scheduleType = org.openfmb.model.dds.rti.openfmb.commonmodule.EnergyProductTypeKind.create();
        if (optimizedMicroGridMarket != null) {
            optimizedMicroGridMarket.clear();
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

        InterchangeSchedule otherObj = (InterchangeSchedule)o;

        if(!directionType.equals(otherObj.directionType)) {
            return false;
        }
        if(!energyType.equals(otherObj.energyType)) {
            return false;
        }
        if(intervalLength != otherObj.intervalLength) {
            return false;
        }
        if(!scheduleType.equals(otherObj.scheduleType)) {
            return false;
        }
        if(!optimizedMicroGridMarket.equals(otherObj.optimizedMicroGridMarket)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;

        __result = super.hashCode();
        __result += directionType.hashCode(); 
        __result += energyType.hashCode(); 
        __result += (int)intervalLength;
        __result += scheduleType.hashCode(); 
        __result += optimizedMicroGridMarket.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>InterchangeScheduleTypeSupport</code>
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

        InterchangeSchedule typedSrc = (InterchangeSchedule) src;
        InterchangeSchedule typedDst = this;
        super.copy_from(typedSrc);
        typedDst.directionType = (org.openfmb.model.dds.rti.openfmb.commonmodule.InterTieDirectionKind) typedDst.directionType.copy_from(typedSrc.directionType);
        typedDst.energyType = (org.openfmb.model.dds.rti.openfmb.commonmodule.MarketProductTypeKind) typedDst.energyType.copy_from(typedSrc.energyType);
        typedDst.intervalLength = typedSrc.intervalLength;
        typedDst.scheduleType = (org.openfmb.model.dds.rti.openfmb.commonmodule.EnergyProductTypeKind) typedDst.scheduleType.copy_from(typedSrc.scheduleType);
        typedDst.optimizedMicroGridMarket = (org.openfmb.model.dds.rti.openfmb.interchangemodule.OptimizedMicroGridMarket) typedDst.optimizedMicroGridMarket.copy_from(typedSrc.optimizedMicroGridMarket);

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

        strBuffer.append(directionType.toString("directionType ", indent+1));
        strBuffer.append(energyType.toString("energyType ", indent+1));
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("intervalLength: ").append(intervalLength).append("\n");  
        strBuffer.append(scheduleType.toString("scheduleType ", indent+1));
        strBuffer.append(optimizedMicroGridMarket.toString("optimizedMicroGridMarket ", indent+1));

        return strBuffer.toString();
    }

}
