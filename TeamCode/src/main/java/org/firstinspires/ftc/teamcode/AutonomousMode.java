package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.logging.*;
import org.firstinspires.ftc.teamcode.webcam.Webcam;
import org.firstinspires.ftc.teamcode.webcam.WebcamPipeline;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

// NOTE: If you are not familiar with the FTC API and usage, please check out this resource:
// NOTE: https://github.com/alan412/LearnJavaForFTC/blob/master/LearnJavaForFTC.pdf

/** The Operation Mode for our Autonomy. */
@TeleOp()
public class AutonomousMode extends OpMode {
    /** Holds webcame data. The key is the deviceId, wereas the value is the
     * camera view ID. */
    HashMap<String, WebcamData> webcams;

    /** Holds a static version of this opmodes telemetry. This is kind of janky,
     * but it's the only way I can think of to expose the telemetry object for use
     * outside of this class. A singleton would probably be better for this. */
    static Telemetry s_telemetry;

    /** Holds webcam data. This would be a singleton in most other languages, but 
     * Java is all about the base... woops I meant objects. */
    class WebcamData {
        int identifier;
        Webcam webcam;

        WebcamData(int identifier, Webcam webcam) {
            this.identifier = identifier;
            this.webcam = webcam;
        }
    }

    /** The initialization code for our autonomous mode. Obviously, this is only called once. */
    @Override
    public void init() {
        Logging.init(LoggingLevel.DEBUG);
        Logging.debug("Initialized logging singleton!");

        Logging.debug("Setting up telemetry....");
        this.s_telemetry = telemetry;

        Logging.debug("Getting app context....");
        Context app_context = hardwareMap.appContext;

        Logging.debug("Initializing webcam(s)....");
        webcams = new HashMap<String, WebcamData>();

        // Note that all the IDs that we put as keys need to be 
        // mentioned in some configuration file somewhere.
        //
        // note: The author of this code (Milo Banks), doesn't
        // know what this configuration file is. All they know
        // is that this is mentioned in the example code for 
        // Easy OpenCV.
        webcams.put("wc0", null);

        for (Map.Entry<String, WebcamData> entry : webcams.entrySet()) {
            int id = app_context.getResources().getIdentifier(entry.getKey(), "id", app_context.getPackageName());

            entry.setValue(
                new WebcamData(id,
                    new Webcam(new WebcamPipeline(), id, hardwareMap.get(WebcamName.class, entry.getKey()), entry.getKey())
                )
            );
        }

        Logging.info("Initialization done, FTC innards will call the loop.");
    }

    /** A single "frame" of the program. Called about 50 times per second. 
     * Note that this is note a linear opmode, so we don't have to supply
     * the loop ourselfs. */
    @Override
    public void loop() {
        // Unnesssary. Delete when we actually get some code in here.
        Logging.trace("New frame");
    }

    /** Returns the jank static telemetry object. */
    public static Telemetry getTelemetry() {
        return s_telemetry;
    }
}

