package com.cowaine.youngjujang.ch2_3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfig {
     @Bean
     public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
          return new ThreadPoolTaskExecutor();
     }
}
