package com.cowaine.youngjujang.ch7.aspect;

import com.cowaine.youngjujang.ch7.domain.controller.HotelRequest;
import com.cowaine.youngjujang.ch7.domain.controller.HotelResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Aspect
@Component
@Order(1)
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
     
     // pointCut 시그니처
     @Pointcut("execution(* com.cowaine.youngjujang.ch7.domain.service.*.getHotelsByname(..))")
     public void pointGetHotelsByName(){}
     
     // 1)
     @Before("pointGetHotelsByName()") // pointCut 시그니처를 사용한 @Before
     public void advice(JoinPoint joinPoint){
     }
     
     // 다음의 pointcut expression 들은 모두 HoteDisplayService 의 getHotelsByName() 메서드를 잡을 수 있다.
     //    @Before("execution(* getHotelsByName(..))")
     //    @Before("execution(* com.springtour.example.chapter07.service.*.getHotelsByName(..))")
     //    @Before("execution(* com.springtour.example.chapter07.service.*.get*(..))")
     @Before("execution(* *(com.cowaine.youngjujang.ch7.domain.controller.HotelRequest, ..))") // HotelRequest인자를받는 모든 메서드 대상
     public void printHotelRequestArgument(JoinPoint joinPoint){
          String argumentValue = Arrays.stream(joinPoint.getArgs()) //조인포인트의 인자를 배열로 리턴
               .filter(obj -> HotelRequest.class.equals(obj.getClass())) // 인자중 HotelRequest 와 같은것만 필터링
               .findFirst()
               .map(HotelRequest.class::cast)
               .map(Object::toString)
               .orElseThrow();
          
          log.info("1) argument info : {}", argumentValue);
     }
     
     @AfterReturning(pointcut = "execution(* getHotelsByName(..))", returning = "retVals") // 대사객체의 리턴객체를 주입
     public void printReturnObject(JoinPoint joinPoint, List<HotelResponse> retVals) throws Throwable{
          retVals.forEach(response -> log.info("5) return value : {}", response));
     }
     
     @AfterThrowing(pointcut = "execution(* getHotelsByName(..))", throwing = "th")
     public void printThrowable(JoinPoint joinPoint, Throwable th) throws Throwable{
          log.error("error processing", th);
     }
}
