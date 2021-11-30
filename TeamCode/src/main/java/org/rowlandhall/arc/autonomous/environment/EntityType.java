package org.rowlandhall.arc.autonomous.environment;

/** Enum containing all the possible things we could detect. */
public enum EntityType {
    ROBOT(0), GENERIC(1), IMAGE(2);

    private int numVal;

    /** Constructs a new entity. Gives the enum a specific numeric number,
     * so we can find out what kind of entity this is, later.
     * @param numVal The numeric value. */
    EntityType(int numVal) {
        this.numVal = numVal;
    }

    /** Gets the numeric value associated with this specific enum instance. */
    public int getValue() {
        return numVal;
    }
}

