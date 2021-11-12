package org.rowlandhall.arc.pipeline;

/** A pipeline. Duh. We should only have two pipelines
 * in existance (teleop and autonomous), but this is 
 * nice for readability. */
public interface Pipeline {
    public void runFrame();
}

