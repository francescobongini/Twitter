package com.francesco.Twitter;

import java.io.File;
import java.io.IOException;

import com.aliasi.classify.Classification;
import com.aliasi.classify.LMClassifier;
import com.aliasi.lm.LanguageModel;
import com.aliasi.stats.MultivariateDistribution;
import com.aliasi.util.AbstractExternalizable;

public class Classifier {

	  public static LMClassifier<LanguageModel, MultivariateDistribution> classifier;

	  public Classifier(File modelFile) throws IOException, ClassNotFoundException {
	    classifier = (LMClassifier<LanguageModel, MultivariateDistribution>)
	        AbstractExternalizable.readObject(modelFile);
	  }

	  public static String classify(String tweet) {
	    return classifier.classify(tweet).bestCategory();
	  }

	}


/*



public class Classifier {
	
	private static LMClassifier<LanguageModel, MultivariateDistribution> classifier;
	
	 public Classifier(File modelFile) throws IOException, ClassNotFoundException {
		    classifier = (LMClassifier<LanguageModel, MultivariateDistribution>)
		        AbstractExternalizable.readObject(modelFile);
		  }

	public static int classify(Tweet tweet) {
		
		String text = new String ("Awww, that's a bummer.  You shoulda got David Carr of Third Day to do it. ;D");
		//System.out.println("pippo");
		String sentiment = tweet.getSentiment().toString();
	    int numTests = 0;
	    int numCorrect = 0;
	    System.out.println(text); //quindi lo legge.
	    Classifier classifier = new Classifier
	    Classification classification = classifier.classify(tweet.getText()); //classifier è un oggetto nullo.
	    String resultCategory = classification.bestCategory();
	    if (resultCategory.equals(tweet.getSentiment()))
	    	++numCorrect;
	    System.out.println("  # Test Cases="
                + numTests);
System.out.println("  # Correct="+ numCorrect);
System.out.println("  % Correct="+ (double)numCorrect);
System.out.println("  % Correct="+ ((double)numCorrect)/(double)numTests);
		return numCorrect;
	
	}
}

*/
