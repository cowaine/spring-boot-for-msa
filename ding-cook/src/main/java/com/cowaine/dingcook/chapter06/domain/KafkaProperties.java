package com.cowaine.dingcook.chapter06.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ToString
@Getter
@Setter
@ConfigurationProperties(prefix = "springtour.kafka")
public class KafkaProperties {

    private List<String> bootstrapServers;
    private Integer ackLevel;
    private Topic topic;
    private List<Grade> grades;

    @ToString
    @Getter
    @Setter
    public static class Topic {
        private String checkout;
        private String reservation;
    }

    @ToString
    @Getter
    @Setter
    public static class Grade {
        private String subject;
        private Integer score;
    }
}
