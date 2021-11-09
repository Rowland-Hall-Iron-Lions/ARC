package org.rowlandhall.arc.logging;

import android.annotation.SuppressLint;
import com.qualcomm.robotcore.util.RobotLog;

/** "Singleton" to deal with logging. Note that the RobotLog class
 * has no documentation, so you can find the source file here:
 * https://github.com/OutoftheBoxFTC/FTC-Android-Robotcore/blob/master/sources/com/qualcomm/robotcore/util/RobotLog.java */
@SuppressLint("NewApi")
public class Logging {
    static LoggingLevel min;

    /** Initializes the logger.
     * @param min The minimum logging "cutoff". Any logging level
     * before here will be ommited. */
    public static void init(LoggingLevel min) {
        Logging.min = min;

        RobotLog.logDeviceInfo();
    }

    static String getLoggingDateTime() {
        return java.time.LocalTime.now().toString();
    }

    /** Emits a trace message.
     * @param msg The message to trace log. */
    public static void trace(String msg) {
        if (Logging.min.getValue() < LoggingLevel.TRACE.getValue())
            RobotLog.v(getLoggingDateTime() + " TRACE: " + msg);
    }

    /** Emits a debug message.
     * @param msg The message to debug log. */
    public static void debug(String msg) {
        if (Logging.min.getValue() < LoggingLevel.TRACE.getValue())
            RobotLog.d(getLoggingDateTime() + " DEBUG: " + msg);
    }

    /** Emits an info message.
     * @param msg The message to info log. */
    public static void info(String msg) {
        if (Logging.min.getValue() < LoggingLevel.TRACE.getValue())
            RobotLog.i(getLoggingDateTime() + " INFO: " + msg);
    }

    /** Emits an warning message.
     * @param msg The mesage to warning log. */
    public static void warning(String msg) {
        if (Logging.min.getValue() < LoggingLevel.TRACE.getValue())
            RobotLog.w(getLoggingDateTime() + " WARN: " + msg);
    }

    /** Emits an error message.
     * @param msg The message to error log. */
    public static void error(String msg) {
        if (Logging.min.getValue() < LoggingLevel.TRACE.getValue())
            RobotLog.e(getLoggingDateTime() + " ERROR: " + msg);
    }
}
