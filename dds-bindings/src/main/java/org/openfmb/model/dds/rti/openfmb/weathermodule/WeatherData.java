

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl using "rtiddsgen".
The rtiddsgen tool is part of the RTI Connext distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the RTI Connext manual.
*/

package org.openfmb.model.dds.rti.openfmb.weathermodule;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;

public class WeatherData   implements Copyable, Serializable{

    public String interval=  "" ; /* maximum length = (255) */
    public String source=  "" ; /* maximum length = (255) */
    public String version=  "" ; /* maximum length = (255) */
    public long versionDateTime= 0;
    public org.openfmb.model.dds.rti.openfmb.weathermodule.Humidity humidity = (org.openfmb.model.dds.rti.openfmb.weathermodule.Humidity)org.openfmb.model.dds.rti.openfmb.weathermodule.Humidity.create();
    public org.openfmb.model.dds.rti.openfmb.weathermodule.SunRadiation sunRadiation = (org.openfmb.model.dds.rti.openfmb.weathermodule.SunRadiation)org.openfmb.model.dds.rti.openfmb.weathermodule.SunRadiation.create();
    public org.openfmb.model.dds.rti.openfmb.weathermodule.Temperature temperature = (org.openfmb.model.dds.rti.openfmb.weathermodule.Temperature)org.openfmb.model.dds.rti.openfmb.weathermodule.Temperature.create();
    public org.openfmb.model.dds.rti.openfmb.weathermodule.Wind wind = (org.openfmb.model.dds.rti.openfmb.weathermodule.Wind)org.openfmb.model.dds.rti.openfmb.weathermodule.Wind.create();

    public WeatherData() {

    }
    public WeatherData (WeatherData other) {

        this();
        copy_from(other);
    }

    public static Object create() {

        WeatherData self;
        self = new  WeatherData();
        self.clear();
        return self;

    }

    public void clear() {

        interval=  ""; 
        source=  ""; 
        version=  ""; 
        versionDateTime= 0;
        if (humidity != null) {
            humidity.clear();
        }
        if (sunRadiation != null) {
            sunRadiation.clear();
        }
        if (temperature != null) {
            temperature.clear();
        }
        if (wind != null) {
            wind.clear();
        }
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        WeatherData otherObj = (WeatherData)o;

        if(!interval.equals(otherObj.interval)) {
            return false;
        }
        if(!source.equals(otherObj.source)) {
            return false;
        }
        if(!version.equals(otherObj.version)) {
            return false;
        }
        if(versionDateTime != otherObj.versionDateTime) {
            return false;
        }
        if(!humidity.equals(otherObj.humidity)) {
            return false;
        }
        if(!sunRadiation.equals(otherObj.sunRadiation)) {
            return false;
        }
        if(!temperature.equals(otherObj.temperature)) {
            return false;
        }
        if(!wind.equals(otherObj.wind)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int __result = 0;
        __result += interval.hashCode(); 
        __result += source.hashCode(); 
        __result += version.hashCode(); 
        __result += (int)versionDateTime;
        __result += humidity.hashCode(); 
        __result += sunRadiation.hashCode(); 
        __result += temperature.hashCode(); 
        __result += wind.hashCode(); 
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>WeatherDataTypeSupport</code>
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

        WeatherData typedSrc = (WeatherData) src;
        WeatherData typedDst = this;

        typedDst.interval = typedSrc.interval;
        typedDst.source = typedSrc.source;
        typedDst.version = typedSrc.version;
        typedDst.versionDateTime = typedSrc.versionDateTime;
        typedDst.humidity = (org.openfmb.model.dds.rti.openfmb.weathermodule.Humidity) typedDst.humidity.copy_from(typedSrc.humidity);
        typedDst.sunRadiation = (org.openfmb.model.dds.rti.openfmb.weathermodule.SunRadiation) typedDst.sunRadiation.copy_from(typedSrc.sunRadiation);
        typedDst.temperature = (org.openfmb.model.dds.rti.openfmb.weathermodule.Temperature) typedDst.temperature.copy_from(typedSrc.temperature);
        typedDst.wind = (org.openfmb.model.dds.rti.openfmb.weathermodule.Wind) typedDst.wind.copy_from(typedSrc.wind);

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
        strBuffer.append("interval: ").append(interval).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("source: ").append(source).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("version: ").append(version).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("versionDateTime: ").append(versionDateTime).append("\n");  
        strBuffer.append(humidity.toString("humidity ", indent+1));
        strBuffer.append(sunRadiation.toString("sunRadiation ", indent+1));
        strBuffer.append(temperature.toString("temperature ", indent+1));
        strBuffer.append(wind.toString("wind ", indent+1));

        return strBuffer.toString();
    }

}
