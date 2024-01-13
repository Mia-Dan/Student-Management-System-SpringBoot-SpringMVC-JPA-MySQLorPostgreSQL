package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class DemoAspect {

    @Before("execution(* com.example.service.*.*(..))")
    public void before() {
        log.info("AOP DemoAspect: before - invoked");
    }

    @After("execution(* com.example.service.*.*(..))")
    public void after() {
        log.info("AOP DemoAspect: after - invoked"); // act similar to finally
    }

    @AfterReturning("execution(* com.example.service.*.*(..))")
    public void afterReturning() {
        log.info("AOP DemoAspect: afterReturning - invoked");
    }

    @AfterThrowing("execution(* com.example.service.*.*(..))")
    public void afterThrowing() {
        log.info("AOP DemoAspect: afterThrowing - invoked");
    }

    @Around("execution(* com.example.service.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AOP DemoAspect: around - before - invoked");

        Object result = joinPoint.proceed();

        log.info("AOP DemoAspect: around - after - invoked");

        return result;
    }
}
