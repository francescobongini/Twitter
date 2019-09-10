package com.francesco.Twitter;


import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;



public class Reduce extends Reducer<Text, IntWritable, Text, IntWritable>{
	@Override
	protected void reduce(Text key, Iterable<IntWritable> value, Context context) throws IOException, InterruptedException {
		int sum = 0;
		Iterator<IntWritable> valuesIt = value.iterator();
		while(valuesIt.hasNext()){
			sum = sum + valuesIt.next().get();
		}
		context.write(key, new IntWritable(sum));
		
	}
	
}
