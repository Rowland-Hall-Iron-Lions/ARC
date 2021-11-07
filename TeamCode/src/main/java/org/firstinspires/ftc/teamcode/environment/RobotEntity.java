package org.firstinspires.ftc.teamcode.environment;

import org.firstinspires.ftc.teamcode.environment.Entity;
import org.firstinspires.ftc.teamcode.environment.EntityType;

public class RobotEntity implements Entity {
    boolean active;

    int x = 0;
    int y = 0;
    int past_x = 0;
    int past_y = 0;

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

    /** Gets the current x position value. */
    public int getX() {
        return x;
    }

    /** Gets the current y position value.  */
    public int getY() {
        return y;
    }

    /** Gets the position of x that was stored before a set_x() call. */
    public int getPastX() {
        return past_x;
    }

    /** Gets the position of y that was stored before a set_y() call. */
    public int getPastY() {
        return past_y;
    }

    /** Returns the difference between the current x and the past x positional values. */
    public int getDeltaX() {
        return past_x + x;
    }

    /** Returns the difference between the current y and the past y positional values. */
    public int getDeltaY() {
        return past_y + y;
    }

    /** Sets activity. */
    public void setActive(boolean active) {
        this.active = active;
    }

    /** Sets the current x position value. the value already in place
     * is moved into the past_x variable. */
    public void setX(int x) {
        this.past_x = this.x;
        this.x = x;
    }

    /** Sets the current y position value. the value already in place
     * is moved into the past_y variable. */
    public void setY(int y) {
        this.past_y = this.y;
        this.y = y;
    }

    /** Sets both the past x and the current x position value. */
    public void setAllX(int x) {
        this.past_x = x;
        this.x = x;
    }

    /** Sets both the past y and the current y position value. */
    public void setAllY(int y) {
        this.past_y = y;
        this.y = y;
    }
}

