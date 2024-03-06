package com.Flink.FileReadWrite;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.core.fs.FileSystem;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class App {

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Read data from a text file
        DataStream<String> input = env.readTextFile("input.txt");

        // Transform the data (if needed)
        DataStream<String> transformed = input.map(new MyMapFunction());

        // Write the transformed data to a new text file
        transformed.writeAsText("output.txt", FileSystem.WriteMode.OVERWRITE);

        // Execute the job
        env.execute("File Read/Write Example");
    }

    // Map function example (you would implement your own logic here)
    public static class MyMapFunction implements MapFunction<String, String> {
    	private static final long serialVersionUID = 1L;
        @Override
        public String map(String value) throws Exception {
            // Your transformation logic goes here
            return value.toUpperCase();
        }
    }
}
