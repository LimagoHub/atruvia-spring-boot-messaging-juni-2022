package de.limago;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class SimpleKafkaConsumer {
    private static final String TOPIC = "SimpleAvroSchemaNeuTopic";

    public void run() {
        ObjectMapper mapper = new ObjectMapper();
        var consumer  = createKafkaConsumer();

        consumer.subscribe(Collections.singletonList(TOPIC));

        System.out.println("Reading topic:" + TOPIC);

        while (true) {
            var records = consumer.poll(Duration.ofMillis(1000));


            for (var record: records) {
                String key = record.key();
                var myMap = record.value();

                User user = mapper.convertValue(myMap, User.class);


                System.out.println(String.format("Key= '%s' Value = '%s'", key, user));

            }
            consumer.commitSync();
        }

    }

    private KafkaConsumer<String, LinkedHashMap> createKafkaConsumer() {
        return new KafkaConsumer<String, LinkedHashMap>(createConfigMap());
    }

    private Properties createConfigMap() {
        Map<String, String> map =  Map.of(

                "bootstrap.servers", "localhost:9092",
                "schema.registry.url", "http://localhost:8081",
                "value.deserializer", "io.confluent.kafka.serializers.json.KafkaJsonSchemaDeserializer",
                "key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer",
                "group.id", "Dozent",
                "auto.commit.enable", "false",
                "auto.offset.reset", "earliest",
                "key.converter","io.confluent.connect.avro.AvroConverter",
                "key.converter.schema.registry.url","http://localhost:8081",
                "value.converter","io.confluent.connect.avro.AvroConverter"




        );

        Properties props = new Properties();
        props.putAll(map);
        props.put("value.converter.schema.registry.url","http://localhost:8081");
        return props;
    }
}
