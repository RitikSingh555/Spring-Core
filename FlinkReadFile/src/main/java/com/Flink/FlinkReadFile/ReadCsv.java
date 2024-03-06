package com.Flink.FlinkReadFile;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.connector.file.src.FileSource;
import org.apache.flink.connector.file.src.format.csv.CsvReaderFormat;
import org.apache.flink.core.fs.Path;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.math.BigDecimal;
import java.util.function.Function;

public class ReadCsv {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Function<CsvReaderFormat.CsvMapperFactory, CsvReaderFormat.CsvMapper> mapperFactory =
                CsvReaderFormat.CsvMapperFactory.newFactory();
        
        Function<CsvReaderFormat.CsvMapper, CsvReaderFormat.CsvSchema> schemaGenerator = mapper ->
                mapper.schemaFor(CityPojo.class).withoutQuoteChar().withColumnSeparator(',');

        CsvReaderFormat<CityPojo> csvFormat = CsvReaderFormat
                .builder(new CsvReaderFormat.CsvSchemaFactory(), mapperFactory, schemaGenerator)
                .typeInfo(TypeInformation.of(CityPojo.class))
                .build();

        FileSource<CityPojo> source =
                FileSource.forRecordStreamFormat(csvFormat, Path.fromLocalFile(new Path("C:\\Users\\ankit\\OneDrive\\Documents\\Desktop\\Dataset\\Sheet1.csv"))).build();

        // Create a data stream from the FileSource
        final DataStream<CityPojo> stream = env
                .fromSource(source, WatermarkStrategy.noWatermarks(), "csv-source");

        // Process the data as needed (for example, print it)
        stream.map(new MapFunction<CityPojo, String>() {
            @Override
            public String map(CityPojo value) throws Exception {
                return value.toString();
            }
        }).print();

        env.execute("Flink CSV Reader Example");
    }

    @JsonPropertyOrder({"city", "lat", "lng", "country", "iso2", "adminName", "capital", "population"})
    public static class CityPojo {
	public long id;
        public String Title;
        public String Author;
        public long Price ;

        @Override
        public String toString() {
            return "CityPojo{" +
                    "id='" + id + '\'' +
                    ", Title=" + Title +
                    ", Author='" + Author + '\'' +
                    ", Price='" + Price + '\'' +
                    '}';
        }
    }
}
