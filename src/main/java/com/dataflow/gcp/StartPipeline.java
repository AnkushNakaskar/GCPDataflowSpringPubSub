package com.dataflow.gcp;

import com.dataflow.gcp.options.PubSubToGCSOptions;
import com.google.api.services.dataflow.Dataflow;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import org.apache.beam.runners.dataflow.DataflowRunner;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.windowing.FixedWindows;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * @author ankushnakaskar
 */
public class StartPipeline {

    private static final Logger logger = LoggerFactory.getLogger(StartPipeline.class);

    private static final String DEFAULT_SECTION = "default";

    public static void main(String[] args) throws IOException {
        logger.info("Initializing pipeline options");
        PubSubToGCSOptions options = PipelineOptionsFactory
                .fromArgs(args)
                .withValidation()
                .as(PubSubToGCSOptions.class);

        options.setStreaming(true);
        options.setInputSubScription("projects/<projectid>/subscriptions/dataflowoutputsub");
        options.setOutputTopic("projects/<projectid>/topics/dataflowfinalsend");


        final List<String> SCOPES = Arrays.asList(
                "https://www.googleapis.com/auth/cloud-platform",
                "https://www.googleapis.com/auth/devstorage.full_control",
                "https://www.googleapis.com/auth/userinfo.email",
                "https://www.googleapis.com/auth/datastore",
                "https://www.googleapis.com/auth/pubsub");


        String inputCredString ="";//Paste the credential string here in variables

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                inputCredString.getBytes(StandardCharsets.UTF_8));

        GoogleCredentials credentials = ServiceAccountCredentials.fromStream(byteArrayInputStream).createScoped(SCOPES);


        options.setGcpCredential(credentials);
        options.setServiceAccount("ankushsampledatastore@<projectid>.iam.gserviceaccount.com");


        Pipeline pipeline = Pipeline.create(options);

        pipeline
                // 1) Read string messages from a Pub/Sub topic.
                .apply("Read PubSub Messages", PubsubIO.readStrings().fromSubscription(options.getInputSubScription()))
                // 2) Group the messages into fixed-sized minute intervals.
                .apply(Window.into(FixedWindows.of(Duration.standardMinutes(options.getWindowSize()))))
                // 3) Write one file to GCS for every window of messages.
                .apply("Write Files to GCS", PubsubIO.writeStrings().to(options.getOutputTopic()));

        // Execute the pipeline and wait until it finishes running.

        DataflowRunner.fromOptions(options).run(pipeline);


    }


}

