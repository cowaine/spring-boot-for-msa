package com.cowaine.joisfe.part3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class LifeCycleComponent implements InitializingBean, DisposableBean {

    @Override
    public void destroy() throws Exception {
        log.error("destroy from DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.error("afterPropertiesSet from InitializingBean");
    }

    public void init() {
        log.error("customized init method");
    }

    public void clear() {
        log.error("customized destroy method");
    }
}
