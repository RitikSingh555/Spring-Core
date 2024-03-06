package com.Flink.WriteClickhouse;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import ru.ivi.opensource.flinkclickhousesink.ClickHouseSink;
import ru.ivi.opensource.flinkclickhousesink.model.ClickHouseClusterSettings;
import ru.ivi.opensource.flinkclickhousesink.model.ClickHouseSinkConst;

import java.util.Properties;

public class App1 {

    public static void main(String[] args) throws Exception {
        // Set up global configuration for ClickHouse
        Configuration config = new Configuration();
        config.setString(ClickHouseClusterSettings.CLICKHOUSE_HOSTS, "jdbc:clickhouse://localhost:9000/student");
        config.setString(ClickHouseClusterSettings.CLICKHOUSE_USER, "default");
        config.setString(ClickHouseClusterSettings.CLICKHOUSE_PASSWORD, "Singhritik@555");

        // Create Flink execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(config);

        // Define your CSV source path
        String csvFilePath = "C:\\Users\\ankit\\OneDrive\\Documents\\Desktop\\Dataset\\Sheet3.csv";

        // Read CSV file and convert to Tuple3<String, String, String>
        DataStream<Tuple3<String, String, String>> csvStream = env.readTextFile(csvFilePath)
                .map((MapFunction<String, Tuple3<String, String, String>>) value -> {
                    // Implement logic to convert CSV lines to Tuple3
                    String[] fields = value.split(",");
                    return new Tuple3<>(fields[0], fields[1], fields[2]);
                }).returns(Types.TUPLE(Types.STRING, Types.STRING, Types.STRING));

        // Configure ClickHouse sink properties
        Properties clickHouseSinkProps = new Properties();
        clickHouseSinkProps.put(ClickHouseSinkConst.TIMEOUT_SEC, "60");
        clickHouseSinkProps.put(ClickHouseSinkConst.NUM_WRITERS, "1");
        clickHouseSinkProps.put(ClickHouseSinkConst.QUEUE_MAX_CAPACITY, "1000");
        clickHouseSinkProps.put(ClickHouseSinkConst.TARGET_TABLE_NAME, "Info");
        clickHouseSinkProps.put(ClickHouseSinkConst.MAX_BUFFER_SIZE, "10000");

        // Add the missing property
        clickHouseSinkProps.put("clickhouse.sink.ignoring-clickhouse-sending-exception-enabled", "true");

        // Create ClickHouse sink with Tuple3 to CSV converter
        ClickHouseSink<Tuple3<String, String, String>> clickHouseSink =
                new ClickHouseSink<>(clickHouseSinkProps, new Tuple3ToCsvConverter());

        // Add ClickHouse sink to the data stream
        csvStream.addSink(clickHouseSink).name("CsvToClickHouseSink");

        // Execute the Flink job
        env.execute("CsvToClickHouseJob");
    }

    // Converter for Tuple3<String, String, Integer> to CSV
    public static class Tuple3ToCsvConverter implements ru.ivi.opensource.flinkclickhousesink.ClickHouseSinkConverter<Tuple3<String, String, String>> {
        @Override
        public String convert(Tuple3<String, String, String> record) {
            return String.format("('%s', '%s', '%s')", record.f0, record.f1, record.f2);
        }
    }
}
