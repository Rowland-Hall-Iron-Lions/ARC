package org.firstinspires.ftc.teamcode.collision;

public class CollisionDetector {

    // This code will be initiated after the ducks have been read
    // We need a distance sensor
    // We will add motor stuff
    // This will override other sensor data

    int Distance;

    Boolean detectIfNeeded() {
        // Detect if we are within 12 inches
        if (Distance <= 12) {
            // We do need to change something; communicate this to the caller
            return true;

        }
    }
}