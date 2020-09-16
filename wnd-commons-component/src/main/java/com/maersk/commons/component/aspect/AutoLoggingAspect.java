package com.maersk.commons.component.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class AutoLoggingAspect {

    @Pointcut("@annotation(com.maersk.commons.component.annotation.AutoLogging)")
    public void autoLoggingAdvice() {
        // do nothing
    }

    @Around("autoLoggingAdvice()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed;
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        try {
            proceed = joinPoint.proceed(args);
        } finally {
            long costTime = System.currentTimeMillis() - startTime;
            log.info("Log check point: class=[{}], method=[{}], costTime=[{}ms]", className, method.getName(), costTime);
        }
        return proceed;
    }
}
