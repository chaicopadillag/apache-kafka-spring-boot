package com.kafka.provider.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    final String TOPIC_NAME = "sign-email";

    @Bean
    public NewTopic generateTopic() {

        Map<String, String> configs = new HashMap<>();
        configs.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configs.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // -1
        configs.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // default 1GB
        configs.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "2097152"); // defatult 1MB

        return TopicBuilder.name(this.TOPIC_NAME).partitions(2).replicas(2).configs(configs).build();
    }

}
