package com.dataflow.gcp.input.pubsub;

/**
 * @author ankushnakaskar
 */
public enum EventMode {
    DELTA,
    RECONCILIATION,
    MIGRATION,
    INVALID;

    private EventMode() {
    }
}
