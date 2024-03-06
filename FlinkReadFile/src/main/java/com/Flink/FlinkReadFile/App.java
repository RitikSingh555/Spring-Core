package com.Flink.FlinkReadFile;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.file.src.format.csv.CsvReaderFormat;

import org.apache.flink.connector.file.src.FileSource;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import java.io.File;
 
/*
public class App {
 
    public static class Book {
        public int id;
        public String title;
        public String author;
        public double price;
    }
 
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
 
        File csvFilePath = new File("C:\\Users\\ritik.kumarsingh\\Desktop\\TextFiles\\Sheet1.csv");
        
        //CsvReaderFormat<Book> csvFormat = CsvReaderFormat.forPojo(Book.class);
 
        //FileSource<Book> source =FileSource.forRecordStreamFormat(CsvReaderFormat.forPojo(Book.class), csvFilePath.getPath())
                //.build();
        FileSource<Book> source =FileSource.forRecordStreamFormat(CsvReaderFormat.forPojo(Book.class), new File("C:\\Users\\ankit\\OneDrive\\Documents\\Desktop\\Dataset\\Sheet1.csv"))
                .build();
 
        // Create a data stream from the FileSource
        final DataStream<Book> stream = env
                .fromSource(source, WatermarkStrategy.noWatermarks(), "csv-source");
 
        // Print the data to the console
        stream.print();
 
        
        env.execute("Flink CSV Reader Example");

    }
}*/
//Has to match the exact order of columns in the CSV file
@JsonPropertyOrder({"city","lat","lng","country","iso2",
                  "adminName","capital","population"})
  public static class CityPojo {
  public String city;
  public BigDecimal lat;
  public BigDecimal lng;
  public String country;
  public String iso2;
  public String adminName;
  public String capital;
  public long population;
}

Function<CsvMapper, CsvSchema> schemaGenerator = mapper ->
      mapper.schemaFor(CityPojo.class).withoutQuoteChar().withColumnSeparator('|');

CsvReaderFormat<CityPojo> csvFormat =
      CsvReaderFormat.forSchema(() -> new CsvMapper(), schemaGenerator, TypeInformation.of(CityPojo.class));

FileSource<CityPojo> source =
      FileSource.forRecordStreamFormat(csvFormat, Path.fromLocalFile(...)).build();
