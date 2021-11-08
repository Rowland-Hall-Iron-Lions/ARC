package org.rowlandhall.arc.autonomous.collision;

/** Class to response to collisions. */
public class CollisionResponse<Distance> {
    int Distance = 100;

    /** Detect if we need to change our velocity (based on if we are about to collide with something). */
    Boolean detectIfNeeded() {
        // Detect if we are within 12 inches
        if (Distance <= 12) {
            // We do need to change something; communicate this to the caller
            return true;
        }
        //stop

        // We do not need to change anything
        return false;
    }
}
