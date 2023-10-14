package com.cowaine.coalong.chapter07.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class SimpleLoggingAspect {

    @Around(value = "execution(* com.cowaine.coalong.chapter07.*..*(..))")
    public Object loggingPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result;
        try {
            result = joinPoint.proceed();
        } finally {
            stopWatch.stop();
            log.info("execution time: {} ms", stopWatch.getLastTaskTimeMillis());
        }

        return result;
    }
}
