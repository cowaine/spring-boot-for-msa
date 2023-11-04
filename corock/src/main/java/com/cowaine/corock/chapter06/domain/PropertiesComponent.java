package com.cowaine.corock.chapter06.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PropertiesComponent {

    private final List<String> bootstrapServers;
    private final Integer ackLevel;

    public PropertiesComponent(@Value("${vroong.kafka.bootstrap-servers}") List<String> bootstrapServers,
                               @Value("${vroong.kafka.ack-level}") Integer ackLevel) {

        this.bootstrapServers = bootstrapServers;
        this.ackLevel = ackLevel;
    }

}
