# Twitter sentiment analysis in Hadoop
![Image detection](Immagini/sentiment.png)
The project presents
the sequential and distributed versions of the Twitter
sentiment analysis. <br />
The entire code is written in Java using Maven. <br />
The file .jar in the project folder is used in Amazon EMR to perform the distributed version.
The data set is available in http://thinknook.com/twitter-sentiment-analysis-training-corpus-dataset-2012-09-22/ . <br />
In Twitter/src/main/java/com/francesco/Twitter/ you can find the java files. <br />
In particular, for the sequential version: <br />
* Tweet.java : define the tweet object
* Trainer.java : train the model
* Classifier.java : classify the tweets 
* Main.java : executes the program <br />

For the distributed one:
* Map.java : Map function
* Partition.java : Partition function
* Reduce.java : Reduce function
* Main_MapReduce : Defines and launches the MR job


The sequential version can be compiled and launched with Eclipse, while the the distributed one with Maven typing the following code from the terminal:  <br />
```
cd
cd Twitter
mvn clean install
cd target
java -jar Twitter-0.0.1-SNAPSHOT.jar com.francesco.Twitter.Main
```
Running the previous code we obtain the number of tweets classified and positive and negative.
