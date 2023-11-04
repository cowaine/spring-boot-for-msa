package com.cowaine.corock.chapter07.aspect;

import com.cowaine.corock.chapter07.dto.HotelRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect     // 관점 클래스임을 선언하기 위해 @Aspect 애너테이션 정의
@Component  // 스프링 AOP 를 사용하여 프록시 객체를 만들기 때문에 관점 클래스 또한 반드시 스프링 빈이어야 함
@Order(1)
public class ArgumentLoggingAspect {

    /**
     * Before 어드바이스를 사용하여 대상 메서드의 인자를 로그로 출력한다.
     *
     * @param joinPoint 어드바이스가 정의된 메서드 인자에 JoinPoint 를 정의하면 프레임워크는 JoinPoint 인수를 주입한다.
     */
    @Before("execution(* *(com.cowaine.corock.chapter07.dto.HotelRequest, ..))")
    public void printHotelRequestArgument(JoinPoint joinPoint) {
        String argumentValue = Arrays.stream(joinPoint.getArgs())
                .filter(obj -> HotelRequest.class.equals(obj.getClass()))
                .findFirst()
                .map(HotelRequest.class::cast)
                .map(Object::toString)
                .orElseThrow();

        log.info("argument info: {}", argumentValue);
    }

}
