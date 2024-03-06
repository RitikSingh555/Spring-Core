package com.Flink.FileOperation;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
//import org.apache.flink.api.java.utils.parameterTool;


public class App
{
	public static void main(String[] args) throws Exception {
	    ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

	    ParameterTool params = ParameterTool.fromArgs(args);
	    env.getConfig().setGlobalJobParameters(params);

	    String inputFilePath = params.get("input.txt");

	    if (inputFilePath == null) {
	        System.err.println("Input file path not provided. Please use --input.txt to specify the input file path.");
	        System.exit(1);
	    }

	    DataSet<String> text = env.readTextFile(inputFilePath);
	    DataSet<Tuple2<String, Integer>> tokenized = text.map(new Tokenizer());
	    DataSet<Tuple2<String, Integer>> counts = tokenized.groupBy(new int[]{0}).sum(1);

	    if (params.has("output")) {
	        counts.writeAsCsv(params.get("output"), "\n", " ");
	        
	    }
	    env.execute("wordcount Example");
	}

public static final class Tokenizer implements MapFunction<String, Tuple2<String, Integer>>
{

private static final long serialVersionUID = 1L;
public Tuple2<String, Integer> map(String value){
return new Tuple2<String, Integer>(value,Integer.valueOf(1));
}}}





