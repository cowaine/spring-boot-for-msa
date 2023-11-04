package com.cowaine.crupy.part7.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.transaction.TransactionManager;

@Slf4j
@Component
@Aspect
@Order(2)
public class ElapseLoggingAspect {

    @Around("@annotation(ElapseLoggable)")
    public Object printElapseTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        log.info("start time clock");

        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } finally {
            stopWatch.stop();
            String methodName = proceedingJoinPoint.getSignature().getName();
            long elapsedTime = stopWatch.getLastTaskTimeMillis();
            log.info("{}, elapsed time: {} ms", methodName, elapsedTime);
        }

        return result;
    }
}
