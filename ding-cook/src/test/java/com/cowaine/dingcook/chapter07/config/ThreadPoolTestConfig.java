package com.cowaine.dingcook.chapter07.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@TestConfiguration
public class ThreadPoolTestConfig {

    @Bean(destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

        taskExecutor.setMaxPoolSize(1);
        taskExecutor.setThreadNamePrefix("TestExecutor-");

        taskExecutor.afterPropertiesSet();

        return taskExecutor;
    }
}
