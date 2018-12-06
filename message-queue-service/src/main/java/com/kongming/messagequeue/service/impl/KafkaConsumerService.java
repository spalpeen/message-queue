package com.kongming.messagequeue.service.impl;

import com.kongming.messagequeue.service.ConsumerServicer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService implements ConsumerServicer {
    @Override
    public void consumeQueueMessage() {
//        listen(new ConsumerRecord<String,String>);
    }

    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<?, ?> record) throws Exception {
        System.out.printf("topic = %s, offset = %d, value = %s ", record.topic(), record.offset(), record.value());
    }
}
