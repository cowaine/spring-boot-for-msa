package com.cowaine.youngjujang;

import com.cowaine.youngjujang.ch2_3.domain.DateFormatter;
import com.cowaine.youngjujang.ch2_3.domain.LifeCycleComponent;
import com.cowaine.youngjujang.ch2_3.domain.LifeCycleComponentVer2;
import com.cowaine.youngjujang.ch2_3.domain.PrintableBeanPostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.TimeUnit;


@Slf4j
@SpringBootApplication
public class YoungjuJangApplication {
    public static void main(String[] args) throws InterruptedException {
        
        ConfigurableApplicationContext ctx = SpringApplication.run(YoungjuJangApplication.class, args);
        ctx.close();
    }
    @Bean(initMethod = "init", destroyMethod = "clear")
    public LifeCycleComponent lifecycleComponent(){
        return new LifeCycleComponent();
    }
    
    @Bean(initMethod = "init", destroyMethod = "clear")
    public LifeCycleComponentVer2 lifeCycleComponentVer2(){
        return new LifeCycleComponentVer2();
    }
    
    @Bean
    public BeanPostProcessor beanPostProcessor(){
        return new PrintableBeanPostProcessor();
    }
}
