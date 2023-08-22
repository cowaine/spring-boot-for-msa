package com.cowaine.corock.chapter03.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DividePatternConfig {

    @Bean
    public String localDatePattern() {
        return "yyyy-MM-dd'T'HH:mm:ss";
    }

}
