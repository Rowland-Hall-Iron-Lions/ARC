package org.firstinspires.ftc.teamcode.autonomous.environment;

import org.firstinspires.ftc.teamcode.autonomous.environment.Entity;
import org.firstinspires.ftc.teamcode.autonomous.environment.EntityType;

public class RobotEntity extends Entity {
    boolean active;

    public boolean isActive() {
        return active;
    }

    public EntityType getType() {
        return EntityType.ROBOT;
    }

    /** Constructs an entity. */
    public void setUp() {
        // Hmm, nothing here yet.
    }

    /** Constructs an entity. Is it active? */
    public RobotEntity(boolean active) {
        this.active = active;
    }

    /** Constructs an entity. */
    public RobotEntity() {
        // Hmm, nothing here yet.
    }

    /** Sets activity. */
    public void setActive(boolean active) {
        this.active = active;
    }
}

