package com.cowaine.dingcook.chapter07.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//@Component
//@Aspect
@Slf4j
public class LoggingAspect {

    //Around는 특별한 설정이 없다면 메서드의 실행, 메서드의 리턴, 예외 발생될 때 모두다 발현된다.
    @Around(value = "execution(* com.cowaine.dingcook.chapter07.*.*(..))")
    public Object loggingPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 대상 객체의 메서드가 실행되기 전 실행될 로직
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result;
        // 대상 객체의 메서드가 실행되기 전 실행될 로직
        try {
            result = proceedingJoinPoint.proceed(); // 대상 객체 메서드 실행 됨.
        } finally {
            stopWatch.stop();
            log.info("execution time: {} ms", stopWatch.getLastTaskTimeMillis());
            // 대상 객체의 메서드가 실행된 후 실행될 로직임
        }

        return result;
    }
}
