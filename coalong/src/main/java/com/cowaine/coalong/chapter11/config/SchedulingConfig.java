package com.cowaine.coalong.chapter11.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;


/**
 * 스프링 프레임워크에서 스케줄이 사용하는 TaskScheduler 를 재설정하는 방법은 크게 두 가지다.
 * 1. 스케줄링 기능을 확장할 수 있는 SchedulingConfigurer 인터페이스를 사용하여 재설정하는 방법
 * 2. 스프링 프레임워크 내부 관례에 따른 스프링 빈을 정의하는 방법이다.
 */
@EnableScheduling
@Configuration
public class SchedulingConfig {
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.setThreadNamePrefix("TaskScheduler-Bean-");
        taskScheduler.initialize();
        return taskScheduler;
    }
}
