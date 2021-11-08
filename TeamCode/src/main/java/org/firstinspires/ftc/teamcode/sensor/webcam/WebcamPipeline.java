package org.firstinspires.ftc.teamcode.sensor.webcam;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;
import org.openftc.easyopencv.OpenCvWebcam;

/** The OpenCV pipeline for the webcam; what all the frames go through
 * to get processed. */
public class WebcamPipeline extends OpenCvPipeline {
    boolean viewportDisabled = false;

    /** Creates a new webcam pipelines. Nothing special. */
    public WebcamPipeline() {}

    /** Does what the function signature says it does; processes a frame. */
    @Override
    public Mat processFrame(Mat input) {
        // Draw a simple box around the middle 1/2 of the entire frame.
        // note: Please note that this is PLACEHOLDER code while we get
        // note: the AI processing code in place.
        Imgproc.rectangle(
            input,
            new Point(
                    input.cols() / 4,
                    input.rows() / 4),
            new Point(
                    input.cols() * (3f / 4f),
                    input.rows() * (3f / 4f)),
            new Scalar(0, 255, 0),
            4
        );

        return input;
    }
}

