package com.cowaine.corock.chapter03.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class PrintableBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("lifeCycleComponent".equals(beanName)) {
            log.error("Called postProcessBeforeInitialization() for: {}", beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("lifeCycleComponent".equals(beanName)) {
            log.error("Called postProcessAfterInitialization() for: {}", beanName);
        }
        return bean;
    }

}
