package com.cowaine.corock.chapter03.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DivideServerConfig {

    @Bean
    public DateFormatter localDateFormatter(/* @Autowired @Qualifier("localDatePattern") */ String localDatePattern) {
        return new DateFormatter(localDatePattern);
    }

}
