package com.cowaine.corock.chapter06.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @implNote HotelServiceTest 테스트 실행 시 application-test-xxx.yaml 파일에 관련 프로퍼티 설정을 하지 않기 위해 스프링 빈 등록을 해지한다.
 */
// @Component
public class PropertiesComponent {

    private final List<String> bootstrapServers;
    private final Integer ackLevel;

    public PropertiesComponent(@Value("${vroong.kafka.bootstrap-servers}") List<String> bootstrapServers,
                               @Value("${vroong.kafka.ack-level}") Integer ackLevel) {

        this.bootstrapServers = bootstrapServers;
        this.ackLevel = ackLevel;
    }

}
