package org.rowlandhall.arc.autonomous.sensor.webcam;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;
import org.openftc.easyopencv.OpenCvWebcam;

import org.rowlandhall.arc.logging.*;
import org.rowlandhall.arc.AutonomousMode;
import org.rowlandhall.arc.autonomous.sensor.Sensor;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

/** Class for interacting (and quasi-processing) of webcame data. */
public class Webcam implements Sensor {
    /** Webcam object */
    OpenCvWebcam webcam;

    /** The name of the device. */
    String deviceName;

    /** The ID of the device. */
    int deviceId;

    /** Creates the OpenCvCamera object.
     * @param pipeline The easyopencv pipeline to use. Defined elsewhere in this package.
     * @param deviceId The ID of the device.
     * @param cameraDevice The camera itself.
     * @param deviceName The name of the device. */
    public Webcam(OpenCvPipeline pipeline, int deviceId, WebcamName cameraDevice, String deviceName) {
        this.deviceName = deviceName;
        this.deviceId = deviceId;

        // Defining webcam object.
        webcam = OpenCvCameraFactory.getInstance().createWebcam(cameraDevice, deviceId);

        // Setting webcam's pipeline to constructor parameter.
        webcam.setPipeline(pipeline);

        // Settings permission timeout for webcam.
        webcam.setMillisecondsPermissionTimeout(2500);

        // Async webcam
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            /** Start streaming webcam when webcam is opened. */
            @Override
            public void onOpened() {
                // This makes us stream at 30 frames per second at 480p
                // You change this to 720p, at 10 frames per second, but
                // you will have to look at some example code:
                //      https://bit.ly/3wr4jcG
                webcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }

            /** Do when we encouter an error. */
            @Override
            public void onError(int errorCode) {
                Logging.error("Easy OpenCV could not open the camera. Error code: " + errorCode);
            }
        });
    }

    /** Get the frame. Don't return it, just store it somewhere that other
     * code can access. */
    public void getFrame() {

    }

    /** Method for streaming webcam data with more specific arguments. */
    public void outputTelemetryData() {
        AutonomousMode.getTelemetry().addData("Frame Count", webcam.getFrameCount());
        AutonomousMode.getTelemetry().addData("FPS", String.format("%.2f", webcam.getFps()));
        AutonomousMode.getTelemetry().addData("Total frame time ms", webcam.getTotalFrameTimeMs());
        AutonomousMode.getTelemetry().addData("Pipeline time ms", webcam.getPipelineTimeMs());
        AutonomousMode.getTelemetry().addData("Overhead time ms", webcam.getOverheadTimeMs());
        AutonomousMode.getTelemetry().addData("Theoretical max FPS", webcam.getCurrentPipelineMaxFps());
    }

    /** Populates and initializes all the webcams we pass in.
     * Note that all the IDs that we put as keys need to be 
     * mentioned in some configuration file somewhere. 
     *
     * note: The author of this code (Milo Banks), doesn't
     * know what this configuration file is. All they know
     * is that this is mentioned in the example code for 
     * Easy OpenCV. */
    public static HashMap<String, WebcamData> populateWebcams(String[] names, Context app_context) {
        HashMap<String, WebcamData> webcams = new HashMap<String, WebcamData>();

        for (String name : names) {
            webcams.put(name, null);
        }

        for (Map.Entry<String, WebcamData> entry : webcams.entrySet()) {
            int id = app_context.getResources().getIdentifier(entry.getKey(), "id", app_context.getPackageName());

            entry.setValue(
                new WebcamData(id,
                    new Webcam(
                        new WebcamPipeline(),
                        id,
                        AutonomousMode.getHardwareMap().get(WebcamName.class, entry.getKey()),
                        entry.getKey()
                    )
                )
            );
        }

        return webcams;
    }
}
