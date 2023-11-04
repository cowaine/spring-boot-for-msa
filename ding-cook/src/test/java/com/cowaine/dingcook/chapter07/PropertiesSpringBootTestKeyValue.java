package com.cowaine.dingcook.chapter07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

// 해당 테스트 코드는 @SpringBootTest properties에 정의된 key value의 값을 검증하는 테스트 코드이다.
@SpringBootTest(properties = {"search.host=127.0.0.1", "search.port=19999"})
@EnableConfigurationProperties(PropertiesSpringBootTestKeyValue.SearchProperties.class)
public class PropertiesSpringBootTestKeyValue {

    @Autowired
    private SearchProperties searchProperties;

    @Test
    public void testProperties() {
        assertEquals("127.0.0.1", searchProperties.getHost());
        assertEquals(19999, searchProperties.getPort());
    }

    @ConfigurationProperties(prefix = "search")
    @Component
    static class SearchProperties {
        private String host;
        private Integer port;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }
    }
}