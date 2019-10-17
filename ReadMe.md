Things to check in project :
* Check for start pipeline class
* check the configuration added like subscriptions and topic.
    * i have verified it worked by pulling messages from sub
* How to run the pipeline -Locally
    * Run CMD :
       * export GOOGLE_APPLICATION_CREDENTIALS=/Users/<>/Office/newCode/content-adapter-logging/key.json
    * run gradle cmd :
      * ./gradlew clean task runApp 
* How to run the pipeline -GCP
   * Make sure - You have credentials added in opyions,since file input stream will not work,Need to switch on Byteinput   stream.
   
* Update the gradle task : with runner as : args '--runner=DataflowRunner
* run gradle cmd : ./gradlew clean task runApp 
This will submit the job to dataflow in GCP project. 
* You might get exception in submitting the job as 'Current user cant run as service account'
   * This can be overcome by setting the role as 'service account' in 'Iam'
* After you run gradle cmd , Job will be submitted and it will run.there,where you can monitor the logs. and job status.
