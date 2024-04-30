package com.kafka.consumer.spirngkafkaconsumer.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {

    private Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = { "sign-email" }, groupId = "auth")
    public void listener(String message) {
        logger.info("Mensage recibido y dice: " + message);
    }

}
