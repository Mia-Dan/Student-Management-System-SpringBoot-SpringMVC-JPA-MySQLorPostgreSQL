package com.example.aop;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.OperateLog;
import com.example.repository.OperateLogRepository;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogAspect {
    private final OperateLogRepository operateLogRepository;

    public LogAspect(OperateLogRepository operateLogRepository) {
        this.operateLogRepository = operateLogRepository;
    }

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private HttpServletRequest request;

    @Pointcut("@annotation(com.example.aop.LogAnnotation)")
    public void pointcut() {}

    @Around("pointcut()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AOP LogAspect: around - before - invoke");

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        OperateLog operateLog = new OperateLog();

        operateLog.setOperateTime(LocalDateTime.now());

        operateLog.setClassName(joinPoint.getTarget().getClass().getName());

        operateLog.setMethodName(joinPoint.getSignature().getName());

//        operateLog.setMethodParams(joinPoint.getArgs().toString()); // [Ljava.lang.Object;@30b9dac7
//        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs())); // [Dept(id=13, name=教研1111部, createTime=2024-01-14T09:36:08.227, updateTime=2024-01-14T09:36:08.227)]
        operateLog.setMethodParams(Arrays.deepToString(joinPoint.getArgs())); // [Dept(id=13, name=教研1111部, createTime=2024-01-14T09:36:08.227, updateTime=2024-01-14T09:36:08.227)]

//        operateLog.setReturnValue(result.toString()); // null pointer exception
        // and I need to return a json, not a plain string
        operateLog.setReturnValue(JSONObject.toJSONString(result));

        operateLog.setOperateUser((Integer) jwtUtils.jwtValidate(request.getHeader("token")).get("id"));

        operateLog.setCostTime(end - start);

        log.info("AOP LogAspect: save log: " + operateLog);
        operateLogRepository.save(operateLog);

        return result;
    }
}
