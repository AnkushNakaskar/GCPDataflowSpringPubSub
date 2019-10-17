package com.dataflow.gcp.input.pubsub;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NonNull;

/**
 * @author ankushnakaskar
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusAttributes {
    @NonNull
    private Status status;
    private ErrorType errorType;
    private String message;
}
