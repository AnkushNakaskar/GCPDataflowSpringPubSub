package com.dataflow.gcp.options;

import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.StreamingOptions;

/**
 * @author ankushnakaskar
 */
public interface PubSubToGCSOptions extends DataflowPipelineOptions, StreamingOptions {
    @Description("The Cloud Pub/Sub topic to read from.")
    String getInputSubScription();

    void setInputSubScription(String value);

    @Description("The Cloud Pub/Sub topic to publish from.")
//    @Validation.Required
    String getOutputTopic();

    void setOutputTopic(String value);

    @Description("Output file's window size in number of minutes.")
    @Default.Integer(1)
    Integer getWindowSize();

    void setWindowSize(Integer value);

    @Description("Path of the output file including its filename prefix.")
//    @Validation.Required
    String getOutput();

    void setOutput(String value);


}
