package com.francesco.Twitter;
import java.util.ArrayList;

import java.util.Iterator;

import com.aliasi.util.CommaSeparatedValues;
import com.aliasi.util.Files;

import com.aliasi.classify.Classification;
import com.aliasi.classify.Classified;
import com.aliasi.classify.DynamicLMClassifier;

import com.aliasi.lm.NGramProcessLM;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StringBufferInputStream;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
 
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import com.francesco.Twitter.Trainer;
import com.francesco.Twitter.Tweet;
import com.francesco.Twitter.Classifier;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Main {
	 
    static final String CSV_FILENAME = "tweet.csv";

    /**
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException{
    		      System.out.println(args.length);


        try(ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE))
        {
            // the header elements are used to map the values to the bean
            final String[] headers = beanReader.getHeader(true);
            //final String[] headers = new String[]{"V_uno","V_sei"};
            final CellProcessor[] processors = getProcessors();
            
            Tweet tweet;
            Integer i=0;
            String modelFile = "model1.txt";
    	    int numTests = 0;
    	    int numCorrect = 0;
    	    tweet = beanReader.read(Tweet.class, headers, processors);
    	    
    	    Trainer.train(tweet);
    	    
    	    
            while ((tweet = beanReader.read(Tweet.class, headers, processors)) != null) {
            
                Classifier classifier = new Classifier(new File(modelFile));
                String text=tweet.getText();
                String sentiment=tweet.getSentiment().toString();
                
                
                String resultCategory = Classifier.classify(text);
                if (resultCategory.equals(sentiment)) {
        	    	numCorrect++;}
            	i++;
                numTests++;
                System.out.println(i);
            }
            
    	    System.out.println("  # Test Cases="
    	    		+ numTests);
    	    System.out.println("  # Correct="+ numCorrect);
    	    System.out.println("  % Correct="+ ((double)numCorrect)/(double)numTests);
    
    	    
        }
    }
    /**
     * Sets up the processors used for the examples.
     */
    static CellProcessor[] getProcessors() {
 
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(new ParseInt()), // sentiment
                new NotNull(), // text

        };
        return processors;
    }
}




















