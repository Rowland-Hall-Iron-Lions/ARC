package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import org.firstinspires.ftc.teamcode.logging.*;

// NOTE: If you are not familiar with the FTC API and usage, please check out this resource:
// NOTE: https://github.com/alan412/LearnJavaForFTC/blob/master/LearnJavaForFTC.pdf

/** The Operation Mode for our Autonomy. */
@TeleOp()
public class AutonomousMode extends OpMode {
    /** The initialization code for our autonomous mode. Obviously, this is only called once. */
    @Override
    public void init() {
        Logging.init(LoggingLevel.DEBUG);
        Logging.info("Initializing ARC robot...");
    }

    /** A single "frame" of the program. Called about 50 times per second. */
    @Override
    public void loop() {
        // This may seem inefficient, but the logger is running on a separate thread
        Logging.trace("New frame");
    }
}

