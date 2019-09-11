# Twitter sentiment analysis
The project presents
the sequential and distributed version of the Twitter
sentiment analysis. <br />
The entire code is written in Java using Maven. <br />
The file .jar in the project folder is used in Amazon EMR to perform the distributed version.
The data set is available in http://thinknook.com/twitter-sentiment-analysis-training-corpus-dataset-2012-09-22/ <br />
The sequential version can be compiled and launched with Eclipse, while the the distributed one with Maven with the following come from the terminal  <br />
```
cd
cd Twitter
mvn clean install
cd target
java -jar Twitter-0.0.1-SNAPSHOT.jar com.francesco.Twitter.Main
```
Running the previous code we obtain the number of tweets classified and positive and negative
