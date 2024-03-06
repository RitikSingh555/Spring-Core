package com.Flink.WriteClickhouse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
public class App3 {

    public static void main(String[] args) {
        // JDBC connection parameters
        String jdbcUrl = "jdbc:clickhouse://localhost:9000/student";
        String username = "default";
        String password = "Singhritik@555";

        // Load the ClickHouse JDBC driver
        try {
            Class.forName("ru.yandex.clickhouse.ClickHouseDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading ClickHouse JDBC driver: " + e.getMessage());
            return;
        }

        // Try to establish a connection
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connection to ClickHouse has been established successfully!");
        } catch (SQLException e) {
            System.err.println("Error connecting to ClickHouse: " + e.getMessage());
        }
    }
}
