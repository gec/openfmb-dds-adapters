

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

public class Curve  extends org.openfmb.model.dds.rti.openfmb.commonmodule.IdentifiedObject implements Copyable, Serializable{

    public org.openfmb.model.dds.rti.openfmb.commonmodule.CurveStyleKind curveStyle = (org.openfmb.model.dds.rti.openfmb.commonmodule.CurveStyleKind)org.openfmb.model.dds.rti.openfmb.commonmodule.CurveStyleKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind xMultiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind xUnit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind y1Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind y1Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind y2Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind y2Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind y3Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind y3Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind)org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
    public org.openfmb.model.dds.rti.openfmb.commonmodule.SequenceOfCurveData curveData = (org.openfmb.model.dds.rti.openfmb.commonmodule.SequenceOfCurveData)org.openfmb.model.dds.rti.openfmb.commonmodule.SequenceOfCurveData.create();

    public Curve() {

        super();

    }
    public Curve (Curve other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        Curve self;
        self = new  Curve();
        self.clear();
        return self;

    }

    public void clear() {

        super.clear();
        curveStyle = org.openfmb.model.dds.rti.openfmb.commonmodule.CurveStyleKind.create();
        xMultiplier = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
        xUnit = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
        y1Multiplier = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
        y1Unit = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
        y2Multiplier = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
        y2Unit = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
        y3Multiplier = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind.create();
        y3Unit = org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind.create();
        if (curveData != null) {
            curveData.clear();
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

        Curve otherObj = (Curve)o;

        if(!curveStyle.equals(otherObj.curveStyle)) {
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
        if(!curveData.equals(otherObj.curveData)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;

        __result = super.hashCode();
        __result += curveStyle.hashCode(); 
        __result += xMultiplier.hashCode(); 
        __result += xUnit.hashCode(); 
        __result += y1Multiplier.hashCode(); 
        __result += y1Unit.hashCode(); 
        __result += y2Multiplier.hashCode(); 
        __result += y2Unit.hashCode(); 
        __result += y3Multiplier.hashCode(); 
        __result += y3Unit.hashCode(); 
        __result += curveData.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>CurveTypeSupport</code>
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

        Curve typedSrc = (Curve) src;
        Curve typedDst = this;
        super.copy_from(typedSrc);
        typedDst.curveStyle = (org.openfmb.model.dds.rti.openfmb.commonmodule.CurveStyleKind) typedDst.curveStyle.copy_from(typedSrc.curveStyle);
        typedDst.xMultiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind) typedDst.xMultiplier.copy_from(typedSrc.xMultiplier);
        typedDst.xUnit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind) typedDst.xUnit.copy_from(typedSrc.xUnit);
        typedDst.y1Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind) typedDst.y1Multiplier.copy_from(typedSrc.y1Multiplier);
        typedDst.y1Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind) typedDst.y1Unit.copy_from(typedSrc.y1Unit);
        typedDst.y2Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind) typedDst.y2Multiplier.copy_from(typedSrc.y2Multiplier);
        typedDst.y2Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind) typedDst.y2Unit.copy_from(typedSrc.y2Unit);
        typedDst.y3Multiplier = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitMultiplierKind) typedDst.y3Multiplier.copy_from(typedSrc.y3Multiplier);
        typedDst.y3Unit = (org.openfmb.model.dds.rti.openfmb.commonmodule.UnitSymbolKind) typedDst.y3Unit.copy_from(typedSrc.y3Unit);
        typedDst.curveData = (org.openfmb.model.dds.rti.openfmb.commonmodule.SequenceOfCurveData) typedDst.curveData.copy_from(typedSrc.curveData);

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

        strBuffer.append(curveStyle.toString("curveStyle ", indent+1));
        strBuffer.append(xMultiplier.toString("xMultiplier ", indent+1));
        strBuffer.append(xUnit.toString("xUnit ", indent+1));
        strBuffer.append(y1Multiplier.toString("y1Multiplier ", indent+1));
        strBuffer.append(y1Unit.toString("y1Unit ", indent+1));
        strBuffer.append(y2Multiplier.toString("y2Multiplier ", indent+1));
        strBuffer.append(y2Unit.toString("y2Unit ", indent+1));
        strBuffer.append(y3Multiplier.toString("y3Multiplier ", indent+1));
        strBuffer.append(y3Unit.toString("y3Unit ", indent+1));
        strBuffer.append(curveData.toString("curveData ", indent+1));

        return strBuffer.toString();
    }

}
