package com.cowaine.corock.chapter07.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
@Order(2)
public class ElapseLoggingAspect {

    @Around("@annotation(ElapseLoggable)")
    public Object printElapseTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        log.info("=== start time clock ===");

        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } finally {
            stopWatch.stop();
            String methodName = proceedingJoinPoint.getSignature().getName();
            long elapsedTime = stopWatch.getLastTaskTimeMillis();
            log.info("{}, elapsed time: {} ms", methodName, elapsedTime);
        }
        log.info("=== end time clock ===");

        return result;
    }

}
