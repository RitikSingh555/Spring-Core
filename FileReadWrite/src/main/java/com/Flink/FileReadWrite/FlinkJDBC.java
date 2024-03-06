package com.Flink.FileReadWrite;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.jdbc.JDBCAppendTableSink;
// import org.apache.flink.api.java.io.jdbc.JDBCAppendTableSink;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
 
public class FlinkJDBC {
 
    public static void main(String[] args) throws Exception {
        
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);
 
        
        DataStream<Tuple2<String, String>> inputDataStream = env.fromElements(
                Tuple2.of("John", "Doe"),
                Tuple2.of("Jane", "Smith"),
                Tuple2.of("Bob", "Johnson")
        );
 
        
        tableEnv.createTemporaryView("myTable", inputDataStream, "col1, col2");
 
        // Define JDBC connection properties
        String jdbcUrl = "jdbc:mysql://your-mysql-host:3306/students";
        String username = "root";
        String password = "Ritik#";
 
        
       /* JDBCAppendTableSink sink = JDBCAppendTableSink.builder()
                .setDrivername("com.mysql.cj.jdbc.Driver")
                .setDBUrl(jdbcUrl)
                .setUsername(username)
                .setPassword(password)
                .setQuery("INSERT INTO your-table (column1, column2) VALUES (?, ?)")
                .setSqlTypes(new int[]{Types.VARCHAR, Types.VARCHAR})
                .build();*/
        JdbcCatalog catalog = new JdbcCatalog(name, students, "root", "Ritik#123", "jdbc:mysql://localhost:3306/students");
        tableEnv.registerCatalog("my_catalog", catalog);
 
        // Write the table to the JDBC sink
        Table resultTable = tableEnv.sqlQuery("SELECT col1, col2 FROM myTable");
        tableEnv.writeToSink(resultTable, sink);
 
        // Execute the Flink job
        env.execute("FlinkToMySQLExample");
    }
}
 
