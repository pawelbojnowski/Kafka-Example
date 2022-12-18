# Kafka-Example

### Script to run kafka on local environment..

## Setup kafka infrastructure

Run in main catalog:
`sh runKafka.sh`

If everything went well then you should see in console:

```
...
kafka-example-kafka-example_init-1  | Successfully created the following topics:
kafka-example-kafka-example_init-1  | __confluent.support.metrics
kafka-example-kafka-example_init-1  | kafka_example_input_1
kafka-example-kafka-example_init-1  | kafka_example_input_2
kafka-example-kafka-example_init-1  | kafka_example_input_3
kafka-example-kafka-example_init-1  | kafka_example_output_1
kafka-example-kafka-example_init-1  | kafka_example_output_2
kafka-example-kafka-example_init-1  | kafka_example_output_3
```

### Useful command

```
# list topics
# kafka/kafka_2.13-3.2.0/bin/kafka-topics.sh --bootstrap-server localhost:9092 --list

# delete topics
# kafka/kafka_2.13-3.2.0/bin/kafka-topics.sh --bootstrap-server  localhost:9092 --delete --topic '<TOPICS NAME>'

# delete topics
# kafka/kafka_2.13-3.2.0/bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe
```

### Btw...

Both scripts were tested on macOS.

### Run examples

Run e.g:

- ./src/main/java/pl/pb/kafkaexample/kstream/KafkaStreamExample.java
- ./src/main/java/pl/pb/kafkaexample/kstream/KafkaConsumerExample.java
- ./src/main/java/pl/pb/kafkaexample/kstream/KafkaProducerExample.java

KafkaStreamExample should produce console output

   ```
   wordcount = hello
   wordcount = world
   wordcount = value
   ```

KafkaConsumerExample should produce console output

   ```
   -----------------------------------------------------
   Data:
   Key: hello, Value: 1
   Partition: 0, Offset:35
   -----------------------------------------------------
   Data:
   Key: world, Value: 1
   Partition: 0, Offset:36
   -----------------------------------------------------
   Data:
   Key: value, Value: 1
   Partition: 0, Offset:37
   ```

# Have fun and learn ;)
