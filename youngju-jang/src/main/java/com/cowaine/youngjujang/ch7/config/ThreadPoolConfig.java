package com.cowaine.youngjujang.ch7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

//@Test용 아니고 기존꺼
@Configuration // 여기 정의된 빈들이 생성됨
public class ThreadPoolConfig {
     
     // ThreadPoolTaskExecutor 설정용
     @Bean (destroyMethod = "shutdown")
     public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
          ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
          taskExecutor.setMaxPoolSize(10);
          taskExecutor.setThreadNamePrefix("AsyncExecutor-");
          taskExecutor.afterPropertiesSet();
          return taskExecutor;
     }
}