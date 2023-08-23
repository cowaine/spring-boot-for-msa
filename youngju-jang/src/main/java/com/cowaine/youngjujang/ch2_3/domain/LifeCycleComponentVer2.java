package com.cowaine.youngjujang.ch2_3.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class LifeCycleComponentVer2{
     @PreDestroy
     public void preDestroy() throws Exception {
          log.error("preDestroy from preDestroy annotation");
     }
     
     @PostConstruct
     public void postConstruct() throws Exception {
          log.error("postConstruct from postConstruct annotation");
     }
     
     public void init(){
          log.error("customized init method");
     }
     
     public void clear(){
          log.error("customized destroy method");
     }
}
