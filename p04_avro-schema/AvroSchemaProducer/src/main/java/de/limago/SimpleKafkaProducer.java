package de.limago;

import JavaSessionize.avro.LogLine;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Date;
import java.util.Map;
import java.util.Random;

public class SimpleKafkaProducer {

    private static final String TOPIC = "SimpleAvroSchemaNeuTopic";


    public void run() {

        try {
//            Schema schema = ReflectData.get().getSchema(User.class);
//
//            // subject convention is "<topic-name>-value"
//            String subject = TOPIC + "-value";
//
//            CachedSchemaRegistryClient client = new CachedSchemaRegistryClient("http://localhost:8081", 20);
//
//            client.register(subject, schema);
            var producer = createKafkaProducer();


            for (var i = 0; i < 5; i ++) {
                var user = new User();
                var record = createProducerRecord(TOPIC, user.id,user);
                producer.send(record).get();
                producer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ProducerRecord<String, User> createProducerRecord(String topic, String key, User value) {
        return new ProducerRecord<>(topic, key, value);
    }

    private Producer<String, User> createKafkaProducer() {
        return new KafkaProducer<>(createConfigMap());
    }


    private Map createConfigMap() {
        return  Map.of(
                "bootstrap.servers", "localhost:9092",
                "schema.registry.url", "http://localhost:8081",
                "acks", "all",
                "retries", 0,
                "value.serializer", "io.confluent.kafka.serializers.json.KafkaJsonSchemaSerializer",
                //"value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer",

                "key.serializer", "org.apache.kafka.common.serialization.StringSerializer",
                "key.converter","io.confluent.connect.avro.AvroConverter",
                "key.converter.schema.registry.url","http://localhost:8081",
                "value.converter","io.confluent.connect.avro.AvroConverter",
                "value.converter.schema.registry.url","http://localhost:8081"
        );
    }


}
