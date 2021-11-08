package org.firstinspires.ftc.teamcode.autonomous.environment;

import org.firstinspires.ftc.teamcode.autonomous.environment.Entity;
import org.firstinspires.ftc.teamcode.autonomous.environment.EntityType;

/** A generic entity. Used mostly for testing, but should be in
 * the main source tree as it's not actually a test itself. */
public class GenericEntity extends Entity {
    public EntityType getType() {
        return EntityType.GENERIC;
    }

    /** Constructs an entity. */
    public void setUp() {
        // Hmm, nothing here yet.
    }
}

