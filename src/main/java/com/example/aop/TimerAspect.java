package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TimerAspect {

    @Around("execution(* com.example.service.*.*(..))") // 切入点表达式。service包下所有类/接口的所有[方法]
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable { // 抛出的异常来自原始方法
        long start = System.currentTimeMillis();
        log.info("AOP TimerAspect: timer started: "+ start);

        Object result = joinPoint.proceed(); // 运行原始方法，得到原始方法的返回值

        long end = System.currentTimeMillis();
        log.info("AOP TimerAspect: " + joinPoint.getSignature() + " invoked, cost time: " + (end - start) + " ms");

        return result; // 返回原始方法的返回值
    }
}
