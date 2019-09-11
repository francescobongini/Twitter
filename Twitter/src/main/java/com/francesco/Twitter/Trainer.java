package com.francesco.Twitter;

import com.aliasi.classify.Classification;
import com.aliasi.classify.Classified;
import com.aliasi.classify.DynamicLMClassifier;
import com.aliasi.lm.NGramProcessLM;
import com.aliasi.util.AbstractExternalizable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.aliasi.util.Compilable;

public class Trainer {
	static final String CSV_FILENAME = "training.csv";
  static int mGram=8; 
  private static DynamicLMClassifier<NGramProcessLM> classifier =
      DynamicLMClassifier.createNGramProcess(new String[]{"0", "1"}, mGram);

  public static void train(Tweet tweet) throws IOException {
	  int i = 0;
      try(ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE))
      {
          // the header elements are used to map the values to the bean
          final String[] headers = beanReader.getHeader(true);
          final CellProcessor[] processors = Main.getProcessors();
 
          while ((tweet = beanReader.read(Tweet.class, headers, processors)) != null) {// && i<50000 se voglio un campione
          i++;
	  String sentiment=tweet.getSentiment().toString();
	  String text=tweet.getText();
      Classification classification = new Classification(sentiment);
      //System.out.println("testo che entra nel training"+text);
      Classified<CharSequence> classified
      = new Classified<CharSequence>(text,classification);
      classifier.handle(classified);
  
      }
      }
  //    System.out.println("pippo");
      try {
			AbstractExternalizable.compileTo((Compilable) classifier, new File(
					"model1.txt"));//saving serialize object to text file
			System.out.println("Succefully created a model");
			System.out.println("numero osservazioni"+i);
    } catch (IOException e) {
		e.printStackTrace();
}
  }
}
