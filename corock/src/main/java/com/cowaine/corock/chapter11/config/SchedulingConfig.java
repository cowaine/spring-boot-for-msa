package com.cowaine.corock.chapter11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * 스프링 프레임워크에서 스케줄이 사용하는 {@link org.springframework.scheduling.TaskScheduler} 를 재설정하는 방법은 크게 두 가지다.
 * 첫 번째는 스케줄링 기능을 확장할 수 있는 {@link SchedulingConfigurer} 인터페이스를 사용하여 재설정하는 방법이고,
 * 두 번째는 스프링 프레임워크 내부 관례에 따른 스프링 빈을 정의하는 방법이다.
 */
@EnableScheduling
@Configuration
public class SchedulingConfig implements SchedulingConfigurer {

    /**
     * 만약 별도의 {@link org.springframework.scheduling.TaskScheduler} 설정이 없다면
     * {@link Executors#newSingleThreadScheduledExecutor()} 메서드를 사용하여 싱글 스레드 TaskScheduler 를 생성한다.
     *
     * @param taskRegistrar {@link org.springframework.scheduling.TaskScheduler} 를 설정하는 헬퍼 클래스
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);                          // ThreadPoolTaskScheduler 의 스레드 개수 설정
        taskScheduler.setThreadNamePrefix("TaskScheduler-");    // 스레드 이름의 머리말 설정
        taskScheduler.initialize();                             // 객체를 초기화해야 함

        taskRegistrar.setTaskScheduler(taskScheduler);          // TaskScheduler 구현체 설정
    }

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.setThreadNamePrefix("TaskScheduler-Bean-");
        taskScheduler.initialize();

        return taskScheduler;
    }

}
