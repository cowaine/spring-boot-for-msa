package com.springtour.example.chapter07.aspect;

import com.cowaine.ahngilwoong.chapter7.model.HotelRequest;
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
    @Before("execution(* *(com.cowaine.ahngilwoong.chapter7.model.HotelRequest, ..))")
    public void printHotelRequestArgument(JoinPoint joinPoint) {
        String argumentValue = Arrays.stream(joinPoint.getArgs())
            .filter(obj -> HotelRequest.class.equals(obj.getClass()))
            .findFirst()
            .map(HotelRequest.class::cast)
            .map(hotelRequest -> hotelRequest.toString())
            .orElseThrow();
        log.info(" info : {}", argumentValue);
    }

}
