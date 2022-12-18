package pl.pb.kafkaexample.statefultransformations.windowing.sessionwindows;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import static pl.pb.kafkaexample.config.Commons.println;
import static pl.pb.kafkaexample.config.Commons.sleep;
import static pl.pb.kafkaexample.statefultransformations.windowing.sessionwindows.KafkaConfig.INPUT_TOPIC_1;
import static pl.pb.kafkaexample.statefultransformations.windowing.sessionwindows.KafkaConfig.getProducerConfig;

public class KafkaProducerExample {

	public static void main(final String[] args) {

		// create the producer
		final KafkaProducer<String, String> producer = new KafkaProducer<>(getProducerConfig());

		send(producer, "REGULAR_USER", "r1", 0);
		send(producer, "REGULAR_USER", "r2", 500);
		send(producer, "REGULAR_USER", "r3", 500);
		send(producer, "REGULAR_USER", "r4", 1000);
		send(producer, "REGULAR_USER", "r5", 3000);
		send(producer, "REGULAR_USER", "r6", 500);
		send(producer, "REGULAR_USER", "r7", 1000);
		send(producer, "REGULAR_USER", "r8", 1500);

		// flush data - synchronous
		producer.flush();

		// flush and close producer
		producer.close();
	}

	private static void send(final KafkaProducer<String, String> producer, final String key, final String value, final int slipTime) {

		// create a producer record
		final ProducerRecord<String, String> producerRecord = new ProducerRecord<>(INPUT_TOPIC_1, key, value);

		// send data - asynchronous
		producer.send(producerRecord);

		println("Sent message for 'recordMessages': " + producerRecord);

		sleep(slipTime);
	}
}