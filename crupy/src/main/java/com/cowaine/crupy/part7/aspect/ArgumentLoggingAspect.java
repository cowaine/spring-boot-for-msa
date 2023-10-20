package com.cowaine.crupy.part7.aspect;

import com.cowaine.crupy.part7.controller.HotelRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
@Order(1)
public class ArgumentLoggingAspect {

    @Before("execution(* *(com.cowaine.crupy.part7.controller.HotelRequest, ..))")
    public void printHotelRequestArgument(JoinPoint joinPoint) {

        String argumentValue = Arrays.stream(joinPoint.getArgs())
                .filter(obj -> HotelRequest.class.equals(obj.getClass()))
                .findFirst()
                .map(HotelRequest.class::cast)
                .map(hotelRequest -> hotelRequest.toString())
                .orElseThrow();

        log.info("argument info : {}", argumentValue);
    }
}
