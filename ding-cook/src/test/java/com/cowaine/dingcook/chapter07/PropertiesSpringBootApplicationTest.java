package com.cowaine.dingcook.chapter07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.cowaine.dingcook.chapter07.PropertiesSpringBootTestKeyValue.SearchProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

/**
 * PropertiesSpringBootTestKeyValue 클래스의 설정과 다르다. 해당 클래스의 테스트 코드는 resources의 application-test의 설정을 확인하는 테스트 코드이다.
 */
@SpringBootTest(properties = "spring.config.location=classpath:application-test.properties")
@EnableConfigurationProperties(PropertiesSpringBootApplicationTest.SearchProperties.class)
public class PropertiesSpringBootApplicationTest {

    @Autowired
    private SearchProperties searchProperties;

    @Test
    public void testProperties() {
        assertEquals("127.0.0.11", searchProperties.getHost());
        assertEquals(20000, searchProperties.getPort());
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
