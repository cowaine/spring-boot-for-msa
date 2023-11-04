package com.cowaine.corock.chapter07.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class SimpleLoggingAspect {

    @Around(value = "execution(* com.cowaine.corock.chapter07.*..*(..))")
    public Object loggingPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String packageName = signature.getDeclaringType().getPackageName();
        String classFullName = signature.getDeclaringTypeName();
        String className = classFullName.replace(packageName + ".", "");
        String methodName = signature.getMethod().getName();
        String[] parameterNames = signature.getParameterNames();

        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } finally {
            stopWatch.stop();
            log.info("{}#{}({}), execution time: {} ms", className, methodName, parameterNames,
                    stopWatch.getLastTaskTimeMillis());
        }

        return result;
    }

}
