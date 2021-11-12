package org.rowlandhall.arc;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.rowlandhall.arc.logging.*;
import org.rowlandhall.arc.autonomous.pipeline.AutonomousPipeline;
import org.rowlandhall.arc.autonomous.sensor.webcam.Webcam;
import org.rowlandhall.arc.autonomous.sensor.webcam.WebcamPipeline;
import org.rowlandhall.arc.autonomous.sensor.webcam.WebcamData;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

// NOTE: If you are not familiar with the FTC API and usage, please check out this resource:
// NOTE: https://github.com/alan412/LearnJavaForFTC/blob/master/LearnJavaForFTC.pdf.
/** The Operation Mode for our Autonomy. */
@TeleOp()
public class AutonomousMode extends OpMode {
    /** Holds webcame data. The key is the deviceId, wereas the value is the
     * camera view ID. */
    HashMap<String, WebcamData> webcams;

    /** Autonomous Pipeline. See the class, it explains itself. */
    AutonomousPipeline auto_pipeline;

    /** Holds a static version of this opmodes telemetry. This is kind of janky,
     * but it's the only way I can think of to expose the telemetry object for use
     * outside of this class. A singleton would probably be better for this. */
    static Telemetry s_telemetry;

    /** Holds a static version of this opmodes hardware map. This is kind of janky,
     * but it's the only way I can think of to expose the telemetry object for use
     * outside of this class. A singleton would probably be better for this. */
    static HardwareMap s_hardwareMap;

    /** The initialization code for our autonomous mode. Obviously, this is only called once. */
    @Override
    public void init() {
        Logging.init(LoggingLevel.DEBUG);
        Logging.debug("Initialized logging singleton!");

        Logging.debug("Getting app context....");
        Context app_context = hardwareMap.appContext;

        Logging.debug("Initializing misc...");
        this.s_telemetry = telemetry;
        this.s_hardwareMap = hardwareMap;
        this.webcams = new HashMap<String, WebcamData>();
        this.auto_pipeline = new AutonomousPipeline();

        /* We use an array here because we don't mutate it after
         * construction. In C, this would be much more effient than
         * doing some malloc calls, so I **assume** it's the name
         * in Java. Submit a PR if incorrect. */
        String[] webcams = { "wc0" };
        this.webcams = Webcam.populateWebcams(webcams, app_context);
    }

    /** A single "frame" of the program. Called about 50 times per second. 
     * Note that this is note a linear opmode, so we don't have to supply
     * the loop ourselfs. */
    @Override
    public void loop() {
        // Unnesssary. Delete when we actually get some code in here.
        Logging.trace("New frame");

        // Call the pipeline code.
        auto_pipeline.runFrame();
    }

    /** Returns the jank static telemetry object. */
    public static Telemetry getTelemetry() {
        return s_telemetry;
    }

    /** Returns the jank static hardware map. */
    public static HardwareMap getHardwareMap() {
        return s_hardwareMap;
    }
}

