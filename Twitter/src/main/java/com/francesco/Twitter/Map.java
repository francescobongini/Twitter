package com.francesco.Twitter;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class Map extends Mapper<LongWritable, Text, Text, IntWritable>{
	private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
    public Classifier classifier;
    
    public void set() throws IOException, ClassNotFoundException {
    	String pp="./model.txt";
        File modelFile = new File(pp); 
          classifier = new Classifier(modelFile);

      }
    
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    	try {
			set();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String line = value.toString();//streaming each tweet from the text file
		if (line != null) {			
			word.set(Classifier.classify(line)); //invoke classify class to get tweet group of each text
			context.write(word, one);

    	
		}
    }
    
}


