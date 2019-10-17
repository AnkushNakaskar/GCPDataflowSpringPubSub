package com.dataflow.gcp.input.pubsub;

/**
 * @author ankushnakaskar
 */
public enum ErrorType {
    CONCURRENT_PROCESSING_EXCEPTION,
    DATABASE_UNAVAILABLE,
    DATABASE_EXCEPTION,
    SERVICE_UNAVAILABLE,
    SERVICE_EXCEPTION,
    REDIS_UNAVAILABLE,
    GENERIC_EXCEPTION,
    DATA_NOT_FOUND,
    VALIDATION_ERROR,
    HYSTRIX_RUNTIME_EXCEPTION,
    GENERIC_RETRYABLE_EXCEPTION;

    private ErrorType() {
    }
}

