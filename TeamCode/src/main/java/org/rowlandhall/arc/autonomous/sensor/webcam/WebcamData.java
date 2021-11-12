package org.rowlandhall.arc.autonomous.sensor.webcam;

/** Holds webcam data. **This would be a tuple in most other languages**, but 
  * Java is all about the base... woops I mean objects. */
public class WebcamData {
    int identifier;
    Webcam webcam;

    WebcamData(int identifier, Webcam webcam) {
        this.identifier = identifier;
        this.webcam = webcam;
    }
}

