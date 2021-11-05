package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;
import org.openftc.easyopencv.OpenCvWebcam;



public class WebcamInit {
    // Instantiating webcam object
    OpenCvWebcam webcam;
    // Instantiating opMode object to be defined in constructor and call OpMode methods.
    LinearOpMode opMode;

    // Constructor
    WebcamInit(int cameraMonitorViewId, LinearOpMode tempOpMode, OpenCvPipeline pipeline) {
        // Setting opMode to constructor parameter
        opMode = tempOpMode;
        // Defining webcam object
        webcam = OpenCvCameraFactory.getInstance().createWebcam(opMode.hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        // Setting webcam's pipeline to constructor parameter
        webcam.setPipeline(pipeline);
        // Settings permission timeout for webcam
        webcam.setMillisecondsPermissionTimeout(2500);
        // Async webcam
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            // Start streaming webcam when webcam is opened
            @Override
            public void onOpened() {
                webcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }

            // Do when error
            @Override
            public void onError(int errorCode) {

            }
        });
    }

    // Method for streaming webcam data with more specific arguments
    void stream() {
        opMode.telemetry.addData("Frame Count", webcam.getFrameCount());
        opMode.telemetry.addData("FPS", String.format("%.2f", webcam.getFps()));
        opMode.telemetry.addData("Total frame time ms", webcam.getTotalFrameTimeMs());
        opMode.telemetry.addData("Pipeline time ms", webcam.getPipelineTimeMs());
        opMode.telemetry.addData("Overhead time ms", webcam.getOverheadTimeMs());
        opMode.telemetry.addData("Theoretical max FPS", webcam.getCurrentPipelineMaxFps());
        opMode.telemetry.update();

        // Stop streaming when a is pressed
        if(opMode.gamepad1.a) {
            webcam.stopStreaming();
        }

        // Sleep so processor doesn't burn cycles
        opMode.sleep(100);
    }
}
