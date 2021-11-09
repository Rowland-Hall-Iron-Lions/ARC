package org.rowlandhall.arc.autonomous.environment;

import org.rowlandhall.arc.autonomous.environment.EntityType;

public abstract class Entity {
    /** The x coordinate of our entity. */
    int x = 0;

    /** The y coordinate of our entity. */
    int y = 0;

    /** The previous value of the x coordinate. */
    int past_x = 0;

    /** The previous value of the y coordinate. */
    int past_y = 0;

    /** Gets the type on an entity. */
    abstract public EntityType getType();

    /** Constructs an entity. */
    abstract public void setUp();

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
    };

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

    /** Sets the current x position value. The value already in place
     * is moved into the past_x variable.
     * @param in_x What to set the current X coordinate to. */
    public void setX(int in_x) {
        past_x = x;
        x = in_x;
    }

    /** Sets the current y position value. The value already in place
     * is moved into the past_y variable.
     * @param in_y What to set the current Y coordinate to. */
    public void setY(int in_y) {
        past_y = y;
        y = in_y;
    }

    /** Sets both the past x and the current x position value.
     * @param in_x What to set all X coordinate related values to. */
    public void setAllX(int in_x) {
        x = in_x;
        past_x = in_x;
    }

    /** Sets both the past y and the current y position value.
     * @param in_y What to set all Y coordinate related values to. */
    public void setAllY(int in_y) {
        y = in_y;
        past_y = in_y;
    }
}

