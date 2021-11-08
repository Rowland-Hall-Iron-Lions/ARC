package org.rowlandhall.arc.logging;

/** A logging level. */
public enum LoggingLevel {
    TRACE(0), DEBUG(1), INFO(2), WARNING(3), ERROR(4);

    private final int value;
    private LoggingLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
