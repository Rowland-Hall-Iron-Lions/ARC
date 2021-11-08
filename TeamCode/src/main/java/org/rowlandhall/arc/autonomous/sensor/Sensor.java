package org.rowlandhall.arc.autonomous.sensor;

/** An interface that all sensors should implement. This is mainly 
 * just for convience */
public interface Sensor {
    public void outputTelemetryData();
    public void getFrame();
}

