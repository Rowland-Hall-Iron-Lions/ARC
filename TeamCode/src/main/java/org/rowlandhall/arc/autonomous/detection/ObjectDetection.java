package org.rowlandhall.arc.detection;

import org.tensorflow.lite.Interpreter;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class ObjectDetection {
    Interpreter interpreter;
    Map<String, Object> inputs = new HashMap<>();
    Map<String, Object> outputs = new HashMap<>();

    public ObjectDetection() {
        File model = new File("future_model_location.tflite");
        interpreter = new Interpreter(model);
    }

    public void run(long[] frame) {
        inputs.put("frame", frame);
        
        // TODO: Figure out what these outputs should be
        // TODO: after we train the model.
    
        interpreter.runSignature(inputs, outputs);
    }

    // NOTE: This will be finished after we, again, figure out
    // NOTE: what the outputs should be.
    /* public UNKNOWN get_detected_boundaries() {
        // Query the output map
    } */
}  

