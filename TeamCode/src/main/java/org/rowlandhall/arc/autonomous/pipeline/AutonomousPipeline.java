package org.rowlandhall.arc.autonomous.pipeline;

import org.rowlandhall.arc.pipeline.Pipeline;

/** A pipeline of things to do. Taken from a functional paradiegm
 * perspective, only we have mutable variables (yuk!). */
public class AutonomousPipeline implements Pipeline {
    /** The pipeline itself. A unit of execution. */
    public void runFrame() {
        // Get video feed

        // Object detection

        // Map to 3D coordinates -> EnvironmentMap

        // Optimise environment map.
        // TODO: Make this paralell?

        // Trajectory map
    }
}

