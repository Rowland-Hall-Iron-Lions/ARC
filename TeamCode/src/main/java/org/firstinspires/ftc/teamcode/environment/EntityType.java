/** Enum containing all the possible things we could detect. */
public enum EntityType {
    /** A robot entity. */
    ROBOT(0);

    private int numVal;

    EntityType(int numVal) {
        this.numVal = numVal;
    }

    public int getValue() {
        return numVal;
    }
}

