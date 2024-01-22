package com.example.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Login Check Interceptor */

@Slf4j
@Component
// to be auto-scanned by Spring
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Interceptor: preHandle invoked");

        // get jwt from header - token
        String jwt = request.getHeader("token");

        // if not login
        if (!StringUtils.hasLength(jwt)) {
            log.info("Interceptor: jwt is empty");
            responseErrorMsg(response);
            return false;
        }

        // if jwt is invalid or expired
        try{
            JwtUtils.jwtParse(jwt);
        } catch (Exception e){
            log.info("Interceptor: jwt is invalid or expired");
            responseErrorMsg(response);
            return false;
        }

        // if jwt is valid
        return true;
    }

    private void responseErrorMsg(HttpServletResponse response) throws IOException {
        // send error message in response body
        Result err = Result.error("NOT_LOGIN");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString(err));
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Interceptor: postHandle invoked");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("Interceptor: afterCompletion invoked");
    }
}
