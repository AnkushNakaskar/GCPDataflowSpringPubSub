package com.dataflow.gcp.input.pubsub;

/**
 * @author ankushnakaskar
 */
public enum Status {
    START,
    SUCCESS,
    FAILED,
    OUTDATED,
    EXHAUSTED;

    private Status() {
    }
}
