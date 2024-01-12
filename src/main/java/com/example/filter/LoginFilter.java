package com.example.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Login Check Filter */
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("LoginFilter: doFilter invoked");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        log.info("getRequestURL: " + request.getRequestURL());
        if (request.getRequestURL().toString().contains("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // get jwt from header - token
        String jwt = request.getHeader("token");

        // if not login
        if (!StringUtils.hasLength(jwt)) {
            log.info("LoginFilter: jwt is empty");
            responseErrorMsg(response);
            return;
        }

        // if jwt is invalid or expired
        try{
            JwtUtils.jwtValidate(jwt);
        } catch (Exception e){
            log.info("LoginFilter: jwt is invalid or expired");
            responseErrorMsg(response);
            return;
        }

        // if jwt is valid

        filterChain.doFilter(servletRequest, servletResponse);

        // post-filter
        log.info("// LoginFilter: after filterChain.doFilter(servletRequest, servletResponse), that is, when web server has processed the request, it will return to filter - once again - , and these lines will be invoked");

        return;

    }

    private void responseErrorMsg(HttpServletResponse response) throws IOException {
        // send error message in response body
        Result err = Result.error("NOT_LOGIN");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString(err));
    }

}
