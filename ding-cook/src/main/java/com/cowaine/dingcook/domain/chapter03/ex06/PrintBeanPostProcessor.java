package com.cowaine.dingcook.domain.chapter03.ex06;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class PrintBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("lifecycleComponent".equals(beanName)) {
            log.error("Called postProcessBeforeInitialization() for : {}", beanName);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("lifecycleComponent".equals(beanName)) {
            log.error("Called postProcessAfterInitialization() for : {}", beanName);
        }

        return bean;
    }
}
