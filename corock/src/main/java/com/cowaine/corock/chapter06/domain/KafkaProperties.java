package com.cowaine.corock.chapter06.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "vroong.kafka")
public class KafkaProperties {

    private List<String> bootstrapServers;
    private Integer ackLevel;
    private Topic topic;

    @Getter
    @Setter
    @ToString
    public static class Topic {
        private String checkout;
        private String reservation;
    }

}
