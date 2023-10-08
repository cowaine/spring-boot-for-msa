package com.cowaine.corock.chapter06.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(value = { "dev", "stage", "local" })
@Configuration
public class TestEnvConfig {

    @Bean
    public String applicationName1() {
        return "production-rest-api";
    }

    @Profile("dev")
    @Bean
    public String applicationName2() {
        return "dev-rest-api";
    }

}
