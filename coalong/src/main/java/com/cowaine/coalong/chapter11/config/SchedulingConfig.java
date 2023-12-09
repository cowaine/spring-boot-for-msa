package com.cowaine.coalong.chapter11.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;


/**
 * 스프링 프레임워크에서 스케줄이 사용하는 TaskScheduler 를 재설정하는 방법은 크게 두 가지다.
 * 1. 스케줄링 기능을 확장할 수 있는 SchedulingConfigurer 인터페이스를 사용하여 재설정하는 방법
 * 2. 스프링 프레임워크 내부 관례에 따른 스프링 빈을 정의하는 방법이다.
 */
@EnableScheduling
@Configuration
public class SchedulingConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);                          // ThreadPoolTaskScheduler 의 스레드 개수 설정
        taskScheduler.setThreadNamePrefix("TaskScheduler-");    // 스레드 이름의 머리말 설정
        taskScheduler.initialize();                             // 객체를 초기화해야 함

        taskRegistrar.setTaskScheduler(taskScheduler);          // TaskScheduler 구현체 설정
    }

}
