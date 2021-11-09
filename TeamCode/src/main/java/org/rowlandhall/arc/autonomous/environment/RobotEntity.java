package org.rowlandhall.arc.autonomous.environment;

import org.rowlandhall.arc.autonomous.environment.Entity;
import org.rowlandhall.arc.autonomous.environment.EntityType;

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

    /** Constructs an entity. Is it active? 
     * @param active Set this as inactive or active from the get go. */
    public RobotEntity(boolean active) {
        this.active = active;
    }

    /** Constructs an entity. */
    public RobotEntity() {
        // Hmm, nothing here yet.
    }

    /** Sets activity.
     * @param active Sets this entity as either active or not. */
    public void setActive(boolean active) {
        this.active = active;
    }
}

