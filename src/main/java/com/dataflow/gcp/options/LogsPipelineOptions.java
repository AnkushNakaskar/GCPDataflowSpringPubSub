package com.dataflow.gcp.options;


import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.options.Description;

import java.io.Serializable;

public interface LogsPipelineOptions extends DataflowPipelineOptions, Serializable {
	
	@Description("Config")
	String getConfig();

	void setConfig(String config);

	@Description("productConfig")
	String getProductConfig();

	void setProductConfig(String productConfig);

	@Description("env")
	String getEnv();

	void setEnv(String env);

	@Description("Pub/Sub topic")
	String getPubsubTopic();

	void setPubsubTopic(String topic);

	@Description("Pub/Sub subscription")
	String getPubsubSubscription();

	void setPubsubSubscription(String subscription);


	@Description("dataflow.key.file.path")
	String getKeyFilePath();

	void setKeyFilePath(String keyFilePath);


	
	}