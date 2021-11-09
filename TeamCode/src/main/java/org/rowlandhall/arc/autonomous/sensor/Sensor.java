package org.rowlandhall.arc.autonomous.sensor;

/** An interface that all sensors should implement. This is mainly 
 * just for convience */
public interface Sensor {
    /** Output some telemetry data. */
    public void outputTelemetryData();

    /** Gets a frame. Returns void for right now, until we actually
     * have some data to return (later). */
    public void getFrame();
}

