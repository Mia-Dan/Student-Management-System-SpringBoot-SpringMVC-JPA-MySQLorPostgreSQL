package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
    5 places for binding advice to join point:
        before
        after =
                + afterReturning
                + afterThrowing
        around

    pointcut: 2 ways - example
        execution(* com.example.service.*.*(..))
        @annotation(com.example.aop.MyLogAnnotation)

    @Order() of several aspects
 */
@Slf4j
@Component
@Aspect
@Order(1)
public class DemoAspect {

    // 抽取切入点表达式，方便复用
//    @Pointcut("execution(* com.example.service.*.*(..))")
    @Pointcut("@annotation(com.example.aop.MyLogAnnotation)")
    public void pointcut() {}

    @Before("pointcut()")
    public void before() {
        log.info("AOP DemoAspect: before - invoked");
    }

    @After("pointcut()")
    public void after() {
        log.info("AOP DemoAspect: after - invoked"); // act similar to finally。 相当于AfterThrowing + AfterReturning
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        log.info("AOP DemoAspect: afterReturning - invoked");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        log.info("AOP DemoAspect: afterThrowing - invoked");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AOP DemoAspect: around - before - invoked");

        Object result = joinPoint.proceed();

        log.info("AOP DemoAspect: around - after - invoked");

        return result;
    }
}
