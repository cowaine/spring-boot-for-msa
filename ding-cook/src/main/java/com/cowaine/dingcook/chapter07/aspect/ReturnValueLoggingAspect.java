package com.cowaine.dingcook.chapter07.aspect;

import com.cowaine.dingcook.chapter07.controller.HotelResponse;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Order(1)
public class ReturnValueLoggingAspect {

    @AfterReturning(pointcut = "execution(* getHotelsByName(..))", returning = "retVals")
    public void printReturnObject(JoinPoint joinPoint, List<HotelResponse> retVals) {
        retVals.stream()
               .forEach(hotelResponse -> log.info("return value: {}", hotelResponse));
    }

    @AfterThrowing(pointcut = "execution(* getHotelsByName(..))", throwing = "th")
    public void printThrowable(JoinPoint joinPoint, Throwable th) throws Throwable {
        log.error("error processing", th);
    }
}
