package org.firstinspires.ftc.teamcode.environment;

import org.firstinspires.ftc.teamcode.environment.EntityType;

public interface Entity {
    public EntityType getType();

    /** Constructs an entity. */
    public void setUp();

    /** Gets the current x position value. */
    public int getX();

    /** Gets the current y position value.  */
    public int getY();

    /** Gets the position of x that was stored before a set_x() call. */
    public int getPastX();

    /** Gets the position of y that was stored before a set_y() call. */
    public int getPastY();

    /** Returns the difference between the current x and the past x positional values. */
    public int getDeltaX();

    /** Returns the difference between the current y and the past y positional values. */
    public int getDeltaY();

    /** Sets the current x position value. the value already in place
     * is moved into the past_x variable. */
    public void setX(int x);

    /** Sets the current y position value. the value already in place
     * is moved into the past_y variable. */
    public void setY(int y);
}

