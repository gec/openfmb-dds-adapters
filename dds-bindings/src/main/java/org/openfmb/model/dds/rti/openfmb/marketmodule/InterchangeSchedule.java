

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.marketmodule;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class InterchangeSchedule   implements Copyable, Serializable{

    public String mRID=  "" ; /* maximum length = (255) */
    public org.openfmb.model.dds.rti.openfmb.commonmodule.CurveStyleKind curveStyle = (org.openfmb.model.dds.rti.openfmb.commonmodule.CurveStyleKind)org.openfmb.model.dds.rti.openfmb.commonmodule.CurveStyleKind.create();
    public String description=  "" ; /* maximum length = (255) */
    public org.openfmb.model.dds.rti.openfmb.marketmodule.InterTieDirectionKind directionType = (org.openfmb.model.dds.rti.openfmb.marketmodule.InterTieDirectionKind)org.openfmb.model.dds.rti.openfmb.marketmodule.InterTieDirectionKind.create();
    public org.openfmb.model.dds.rti.openfmb.marketmodule.MarketProductTypeKind energyType = (org.openfmb.model.dds.rti.openfmb.marketmodule.MarketProductTypeKind)org.openfmb.model.dds.rti.openfmb.marketmodule.MarketProductTypeKind.create();
    public int intervalLength= 0;
    public String name=  "" ; /* maximum length = (255) */
    public org.openfmb.model.dds.rti.openfmb.marketmodule.EnergyProductTypeKind scheduleType = (org.openfmb.model.dds.rti.openfmb.marketmodule.EnergyProductTypeKind)org.openfmb.model.dds.rti.openfmb.marketmodule.EnergyProductTypeKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind xMultiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind)org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind xUnit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind y1Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind)org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind y1Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind y2Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind)org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind y2Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind y3Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind)org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind y3Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
    public org.openfmb.model.dds.rti.openfmb.marketmodule.OptimizedMicroGridMarket optimizedMicroGridMarket = (org.openfmb.model.dds.rti.openfmb.marketmodule.OptimizedMicroGridMarket)org.openfmb.model.dds.rti.openfmb.marketmodule.OptimizedMicroGridMarket.create();

    public InterchangeSchedule() {

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

        mRID=  ""; 
        curveStyle = org.openfmb.model.dds.rti.openfmb.commonmodule.CurveStyleKind.create();
        description=  ""; 
        directionType = org.openfmb.model.dds.rti.openfmb.marketmodule.InterTieDirectionKind.create();
        energyType = org.openfmb.model.dds.rti.openfmb.marketmodule.MarketProductTypeKind.create();
        intervalLength= 0;
        name=  ""; 
        scheduleType = org.openfmb.model.dds.rti.openfmb.marketmodule.EnergyProductTypeKind.create();
        xMultiplier = org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind.create();
        xUnit = org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
        y1Multiplier = org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind.create();
        y1Unit = org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
        y2Multiplier = org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind.create();
        y2Unit = org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
        y3Multiplier = org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind.create();
        y3Unit = org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind.create();
        if (optimizedMicroGridMarket != null) {
            optimizedMicroGridMarket.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        InterchangeSchedule otherObj = (InterchangeSchedule)o;

        if(!mRID.equals(otherObj.mRID)) {
            return false;
        }
        if(!curveStyle.equals(otherObj.curveStyle)) {
            return false;
        }
        if(!description.equals(otherObj.description)) {
            return false;
        }
        if(!directionType.equals(otherObj.directionType)) {
            return false;
        }
        if(!energyType.equals(otherObj.energyType)) {
            return false;
        }
        if(intervalLength != otherObj.intervalLength) {
            return false;
        }
        if(!name.equals(otherObj.name)) {
            return false;
        }
        if(!scheduleType.equals(otherObj.scheduleType)) {
            return false;
        }
        if(!xMultiplier.equals(otherObj.xMultiplier)) {
            return false;
        }
        if(!xUnit.equals(otherObj.xUnit)) {
            return false;
        }
        if(!y1Multiplier.equals(otherObj.y1Multiplier)) {
            return false;
        }
        if(!y1Unit.equals(otherObj.y1Unit)) {
            return false;
        }
        if(!y2Multiplier.equals(otherObj.y2Multiplier)) {
            return false;
        }
        if(!y2Unit.equals(otherObj.y2Unit)) {
            return false;
        }
        if(!y3Multiplier.equals(otherObj.y3Multiplier)) {
            return false;
        }
        if(!y3Unit.equals(otherObj.y3Unit)) {
            return false;
        }
        if(!optimizedMicroGridMarket.equals(otherObj.optimizedMicroGridMarket)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += mRID.hashCode(); 
        __result += curveStyle.hashCode(); 
        __result += description.hashCode(); 
        __result += directionType.hashCode(); 
        __result += energyType.hashCode(); 
        __result += (int)intervalLength;
        __result += name.hashCode(); 
        __result += scheduleType.hashCode(); 
        __result += xMultiplier.hashCode(); 
        __result += xUnit.hashCode(); 
        __result += y1Multiplier.hashCode(); 
        __result += y1Unit.hashCode(); 
        __result += y2Multiplier.hashCode(); 
        __result += y2Unit.hashCode(); 
        __result += y3Multiplier.hashCode(); 
        __result += y3Unit.hashCode(); 
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

        typedDst.mRID = typedSrc.mRID;
        typedDst.curveStyle = (org.openfmb.model.dds.rti.openfmb.commonmodule.CurveStyleKind) typedDst.curveStyle.copy_from(typedSrc.curveStyle);
        typedDst.description = typedSrc.description;
        typedDst.directionType = (org.openfmb.model.dds.rti.openfmb.marketmodule.InterTieDirectionKind) typedDst.directionType.copy_from(typedSrc.directionType);
        typedDst.energyType = (org.openfmb.model.dds.rti.openfmb.marketmodule.MarketProductTypeKind) typedDst.energyType.copy_from(typedSrc.energyType);
        typedDst.intervalLength = typedSrc.intervalLength;
        typedDst.name = typedSrc.name;
        typedDst.scheduleType = (org.openfmb.model.dds.rti.openfmb.marketmodule.EnergyProductTypeKind) typedDst.scheduleType.copy_from(typedSrc.scheduleType);
        typedDst.xMultiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind) typedDst.xMultiplier.copy_from(typedSrc.xMultiplier);
        typedDst.xUnit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind) typedDst.xUnit.copy_from(typedSrc.xUnit);
        typedDst.y1Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind) typedDst.y1Multiplier.copy_from(typedSrc.y1Multiplier);
        typedDst.y1Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind) typedDst.y1Unit.copy_from(typedSrc.y1Unit);
        typedDst.y2Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind) typedDst.y2Multiplier.copy_from(typedSrc.y2Multiplier);
        typedDst.y2Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind) typedDst.y2Unit.copy_from(typedSrc.y2Unit);
        typedDst.y3Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitmultiplier.UnitMultiplierKind) typedDst.y3Multiplier.copy_from(typedSrc.y3Multiplier);
        typedDst.y3Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.unitsymbol.UnitSymbolKind) typedDst.y3Unit.copy_from(typedSrc.y3Unit);
        typedDst.optimizedMicroGridMarket = (org.openfmb.model.dds.rti.openfmb.marketmodule.OptimizedMicroGridMarket) typedDst.optimizedMicroGridMarket.copy_from(typedSrc.optimizedMicroGridMarket);

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
        strBuffer.append(curveStyle.toString("curveStyle ", indent+1));
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("description: ").append(description).append("\n");  
        strBuffer.append(directionType.toString("directionType ", indent+1));
        strBuffer.append(energyType.toString("energyType ", indent+1));
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("intervalLength: ").append(intervalLength).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("name: ").append(name).append("\n");  
        strBuffer.append(scheduleType.toString("scheduleType ", indent+1));
        strBuffer.append(xMultiplier.toString("xMultiplier ", indent+1));
        strBuffer.append(xUnit.toString("xUnit ", indent+1));
        strBuffer.append(y1Multiplier.toString("y1Multiplier ", indent+1));
        strBuffer.append(y1Unit.toString("y1Unit ", indent+1));
        strBuffer.append(y2Multiplier.toString("y2Multiplier ", indent+1));
        strBuffer.append(y2Unit.toString("y2Unit ", indent+1));
        strBuffer.append(y3Multiplier.toString("y3Multiplier ", indent+1));
        strBuffer.append(y3Unit.toString("y3Unit ", indent+1));
        strBuffer.append(optimizedMicroGridMarket.toString("optimizedMicroGridMarket ", indent+1));

        return strBuffer.toString();
    }

}
