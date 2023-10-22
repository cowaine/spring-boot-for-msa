package com.cowaine.ahngilwoong.chapter7.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Component
@Aspect
@Order(2)
public class ElapseLoggingAspect {

    @Around("@annotation(ElapseLoggable)")
    public Object printElapseTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        log.info("측정 시작");
        Object resultTime;
        try {
            resultTime = proceedingJoinPoint.proceed();
        } finally {
            stopWatch.stop();
            String methodName = proceedingJoinPoint.getSignature().getName();
            long elapsedTime = stopWatch.getLastTaskTimeMillis();
            log.info("{}, 경과 시간: {} 초", methodName, elapsedTime);
        }

        return resultTime;
    }
}

