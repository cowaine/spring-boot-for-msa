package com.cowaine.ahngilwoong.chapter7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class TestConfig {
    @Bean(destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(1);
        taskExecutor.setThreadNamePrefix("TestExecutor-");
        taskExecutor.afterPropertiesSet();
        return taskExecutor;
    }



}
