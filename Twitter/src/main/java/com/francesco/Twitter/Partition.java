package com.francesco.Twitter;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Partition extends Partitioner<Text, IntWritable>{
	@Override
	  public int getPartition(Text key, IntWritable value, int reduceTasks) {
	    return "0".equals(key.toString()) ? 0 : 1;
	  }
}
