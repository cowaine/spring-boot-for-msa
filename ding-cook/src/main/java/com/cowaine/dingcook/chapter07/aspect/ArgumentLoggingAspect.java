package com.cowaine.dingcook.chapter07.aspect;

import com.cowaine.dingcook.chapter07.controller.HotelRequest;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Order(1)
public class ArgumentLoggingAspect {

    // 다음의 pointcut expression 들은 모두 HotelDisplayService의 getHotelsByName() 메서드를 잡을 수 있다.
    //    @Before("execution(* getHotelsByName(..))")
    //    @Before("execution(* com.springtour.example.chapter07.service.*.getHotelsByName(..))")
    //    @Before("execution(* com.springtour.example.chapter07.service.*.get*(..))")
    @Before("execution(* * (com.cowaine.dingcook.chapter07.controller.HotelRequest, ..))")
    public void printHotelRequestArgument(JoinPoint joinPoint) {
        String argumentValue = Arrays.stream(joinPoint.getArgs())
                                     .filter(obj -> HotelRequest.class.equals(obj.getClass()))
                                     .findFirst()
                                     .map(HotelRequest.class::cast)
                                     .map(HotelRequest::toString)
                                     .orElseThrow();

        log.info("argument info : {}", argumentValue);
    }
}
