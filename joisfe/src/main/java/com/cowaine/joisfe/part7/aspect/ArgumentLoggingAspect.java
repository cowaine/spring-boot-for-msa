package com.cowaine.joisfe.part7.aspect;

import com.cowaine.joisfe.part7.dto.HotelRequest;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author : 조재철
 * @since 1.0
 */
@Slf4j
@Aspect
@Component
@Order(1)
public class ArgumentLoggingAspect {
    @Before("execution(* *(com.cowaine.joisfe.part7.dto.HotelRequest, ..))")
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
