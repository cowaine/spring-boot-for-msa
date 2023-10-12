package com.cowaine.youngjujang.ch7.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Order(2) //위빙 순서 결정용. 높을수록 우선순위 높음
@Component // bean 설정용
public class ElapsedLoggingAspect {
     
     @Around ("@annotation(ElapseLoggable)") //annotation 으로도 pointCut 지정가능
     public Object printElapsedTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
          StopWatch stopWatch = new StopWatch();
          stopWatch.start();
          log.info("2) start time clock");
          
          Object result;
          try {
               result = proceedingJoinPoint.proceed();
          }finally {
               stopWatch.stop();
               String methodName = proceedingJoinPoint.getSignature().getName();
               long elapsedTime = stopWatch.getLastTaskTimeMillis();
               log.info("4) {}, elapsed time: {} ms", methodName, elapsedTime);
          } // 예외 catch를 advice내부에서 처리하는건 바람직하지 않다. throws tjsdjs.
          return result;
     }
}
