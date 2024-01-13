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
        log.info("AOP LogAspect: around - before - invoked");

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        OperateLog operateLog = new OperateLog();
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(joinPoint.getArgs().toString());
//        operateLog.setReturnValue(result.toString()); // null pointer exception
        operateLog.setReturnValue(JSONObject.toJSONString(result));
        operateLog.setOperateUser((Integer) jwtUtils.jwtValidate(request.getHeader("token")).get("id"));
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setCostTime(end - start);

        operateLogRepository.save(operateLog);

        return result;
    }
}
