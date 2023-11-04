package com.cowaine.dingcook.chapter03.ex06;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBean06Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBean06Application.class);
        applicationContext.close();
    }

    @Bean(initMethod = "init", destroyMethod = "clear")
    public LifeCycleComponent lifeCycleComponent() {
        return new LifeCycleComponent();
    }

    @Bean
    public BeanPostProcessor beanPostProcessor() {
        return new PrintBeanPostProcessor();
    }
}
