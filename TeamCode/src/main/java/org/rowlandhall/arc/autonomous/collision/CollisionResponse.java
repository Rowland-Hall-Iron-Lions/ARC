package org.rowlandhall.arc.autonomous.collision;

/** Class to response to collisions. */
public class CollisionResponse {
    /** Detect if we need to change our velocity (based on if we are about to collide with something). */
    Boolean detectIfNeeded(int distance) {
        // Detect if we are within 12 inches
        if (distance <= 12) {
            // We do need to change something; communicate this to the caller
            return true;
        }
        //stop

        // We do not need to change anything
        return false;
    }
}
