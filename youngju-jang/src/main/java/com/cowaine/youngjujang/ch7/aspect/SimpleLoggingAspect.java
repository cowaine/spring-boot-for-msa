package com.cowaine.youngjujang.ch7.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class SimpleLoggingAspect {
     
     @Around(value = "execution(* com.cowaine.youngjujang.ch7.*.*(..))")
     public Object loggingPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
          StopWatch stopWatch = new StopWatch();
          stopWatch.start();
          
          Object result;
          try {
               result = proceedingJoinPoint.proceed();
          } finally {
               stopWatch.stop();
               log.info("execution time : {} ms", stopWatch.getLastTaskTimeMillis());
          }
          return result;
     }
}
