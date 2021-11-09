package org.rowlandhall.arc.logging;

/** A logging level. */
public enum LoggingLevel {
    TRACE(0), DEBUG(1), INFO(2), WARNING(3), ERROR(4);

    private final int value;

    /** Make a new logging level with a numeric identifier. 
     * @param value Said numberic value. */
    LoggingLevel(int value) {
        this.value = value;
    }

    /** Gets the value of the logging level. Used for the cutoff code. */
    public int getValue() {
        return value;
    }
}
