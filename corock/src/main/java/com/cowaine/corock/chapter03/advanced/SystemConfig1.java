package com.cowaine.corock.chapter03.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig1 {

    @Bean
    public Long systemId() {
        return 1_111L;
    }

}
