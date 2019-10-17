package com.dataflow.gcp.input.pubsub;

/**
 * @author ankushnakaskar
 */
public enum Event {
    CREATE,
    UPDATE,
    DELETE,
    INVALID,
    RETRY;

    private Event() {
    }
}

