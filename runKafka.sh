#!/bin/sh

docker stop kafka_example_broker
docker stop kafka_example_zookeeper

docker rm -f kafka-example-kafka-example_init-1
docker rm -f kafka_example_broker
docker rm -f kafka_example_zookeeper

rm -rf kafka_docker

docker compose up