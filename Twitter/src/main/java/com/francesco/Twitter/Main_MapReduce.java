package com.francesco.Twitter;

import java.io.File;
import java.net.URI;



import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
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
import org.apache.hadoop.conf.Configuration;





public class Main_MapReduce extends Configured implements Tool {

	public static void main(String[] args) throws Exception {
		System.out.println("start MapReduce job");
		int exitCode = ToolRunner.run(new Main_MapReduce(), args);
		System.exit(exitCode);
	}

	
	public int run(String[] args) throws Exception {
		Configuration conf=new Configuration();
		FileSystem fs=FileSystem.get(URI.create("s3://mapduce"), conf);
		Job job = new org.apache.hadoop.mapreduce.Job();
		job.setJarByClass(Main_MapReduce.class);
		job.setJobName("Twitter");
		long start = System.currentTimeMillis();
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1])); //ricordarsi di definire le cartelle di input e output
		job.addCacheFile(new URI(args[2]));
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		//job.setOutputFormatClass(TextOutputFormat.class);
		System.out.println("fino a qui tutto ok");
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		job.setNumReduceTasks(10);
		System.out.println("fino a qui tutto ok");
		int returnValue = job.waitForCompletion(true) ? 0:1;
		System.out.println("job.isSuccessful " + job.isSuccessful());
		long elapsedTime= System.currentTimeMillis()-start;
		System.out.println("tempo in secondi:    " + elapsedTime/1000);
		return returnValue;
	}

}





