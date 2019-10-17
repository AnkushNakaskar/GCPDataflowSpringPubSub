package com.dataflow.gcp.input.pubsub;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NonNull;

/**
 * @author ankushnakaskar
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {

    @NonNull
    protected String serviceName;

    private String node;

    @NonNull
    protected Long lastUpdateTime;

    @NonNull
    protected Long currentTime;

    @NonNull
    protected String contentId;

    protected String sourceId;

    @NonNull
    protected Type type;

    @NonNull
    protected Event event;

    @NonNull
    protected EventMode mode;

    @NonNull
    protected Stage stage;

    @NonNull
    private StatusAttributes status;

    private String consumer;

}
