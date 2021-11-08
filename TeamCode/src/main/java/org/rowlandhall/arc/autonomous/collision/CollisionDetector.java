package org.rowlandhall.arc.autonomous.collision;

/** Class to detect collisions. */
public class CollisionDetector {
    int Distance;

    /** This code will be initiated after the ducks have been read
     * We need a distance sensor
     * We will add motor stuff
     * This will override other sensor data */
    Boolean detectIfNeeded() {
        // Detect if we are within 12 inches
        if (Distance <= 12) {
            // We do need to change something; communicate this to the caller
            return true;
        }

        // We do not need to change something;
        return false;
    }
}
