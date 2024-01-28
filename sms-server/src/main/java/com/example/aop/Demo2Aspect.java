package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
    get joinPoint info

    joinPoint for before/after/afterReturning/afterThrowing
    proceedingJoinPoint for around

    proceedingJoinPoint extends joinPoint
 */

/*
@Slf4j
@Component
@Aspect
@Order(2)
public class Demo2Aspect {

    // 抽取切入点表达式，方便复用
//    @Pointcut("execution(* com.example.service.*.*(..))")
    @Pointcut("@annotation(com.example.aop.MyLogAnnotation)")
    public void pointcut() {}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        log.info("AOP Demo2Aspect: before - invoked");

        // get class name
        String className = joinPoint.getTarget().getClass().getName();

        // get method name
        String methodName = joinPoint.getSignature().getName();

        // get args
        Object[] args = joinPoint.getArgs();

//        // get return value
//        Object result = joinPoint.proceed();

        // log
        log.info("AOP Demo2Aspect: class name: " + className);
        log.info("AOP Demo2Aspect: method name: " + methodName);
        log.info("AOP Demo2Aspect: args: " + Arrays.toString(args));
//        log.info("AOP DemoAspect: return value: " + result);

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

        // get class name
        String className = joinPoint.getTarget().getClass().getName();

        // get method name
        String methodName = joinPoint.getSignature().getName();

        // get args
        Object[] args = joinPoint.getArgs();

        // get return value
        Object result = joinPoint.proceed();

        // log
        log.info("AOP Demo2Aspect: class name: " + className);
        log.info("AOP Demo2Aspect: method name: " + methodName);
        log.info("AOP Demo2Aspect: args: " + Arrays.toString(args));
        log.info("AOP Demo2Aspect: return value: " + result);

        log.info("AOP Demo2Aspect: around - after - invoked");

        return result;
    }
}
*/