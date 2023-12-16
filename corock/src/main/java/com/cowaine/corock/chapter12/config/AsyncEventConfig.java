package com.cowaine.corock.chapter12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncEventConfig {

    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster applicationEventMulticaster(TaskExecutor asyncEventTaskExecutor) {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(asyncEventTaskExecutor);

        return eventMulticaster;
    }

    @Bean
    public TaskExecutor asyncEventTaskExecutor() {
        ThreadPoolTaskExecutor asyncEventTaskExecutor = new ThreadPoolTaskExecutor();
        asyncEventTaskExecutor.setMaxPoolSize(10);
        asyncEventTaskExecutor.setThreadNamePrefix("eventExecutor-");
        asyncEventTaskExecutor.afterPropertiesSet();

        return asyncEventTaskExecutor;
    }

}
