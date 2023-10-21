package com.cowaine.corock.chapter07.aspect;

import com.cowaine.corock.chapter07.dto.HotelResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Aspect
@Component
@Order(3)
public class ReturnValueLoggingAspect {

    /**
     * 반환하는 값이 비어 있는 경우 동작하지 않는다.
     *
     * @param joinPoint Advice 가 적용된 위치로, 관점과 어드바이스의 차이는 어드바이스가 적용될 위치 정보인 포인트 컷의 유무
     * @param returnValues returning 에 지정할 매개변수 이름
     */
    @AfterReturning(pointcut = "execution(* getHotelsByName(..))", returning = "returnValues")
    public void printReturnObject(JoinPoint joinPoint, List<HotelResponse> returnValues) {
        returnValues.forEach(response -> log.info("return value: {}", response));
    }

    @AfterThrowing(pointcut = "execution(* getHotelsByName(..))", throwing = "th")
    public void printThrowable(JoinPoint joinPoint, Throwable th) {
        log.error("error processing", th);
    }

}
