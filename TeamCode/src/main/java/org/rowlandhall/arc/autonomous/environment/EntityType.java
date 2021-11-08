package org.rowlandhall.arc.autonomous.environment;

/** Enum containing all the possible things we could detect. */
public enum EntityType {
    ROBOT(0), GENERIC(1);

    private int numVal;

    EntityType(int numVal) {
        this.numVal = numVal;
    }

    public int getValue() {
        return numVal;
    }
}

