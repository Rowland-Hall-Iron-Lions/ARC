package org.rowlandhall.arc.autonomous.sensor.imu;

import org.rowlandhall.arc.autonomous.sensor.Sensor;

/** Class for interacting with the onboard IMU sensor. */
public class IMUStream implements Sensor {
    /** Creates a new IMUStream. */
    public IMUStream() {

    }

    /** Gets the current frame of information. Does not return the 
     * next in sequence from the last invokation, but instead gets the
     * very latest. */
    public void getFrame() {

    }

    /** Outputs telemetry data. */
    public void outputTelemetryData() {

    }
}
