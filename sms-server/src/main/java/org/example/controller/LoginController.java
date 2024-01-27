package org.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.EmpService;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping({"/login"})
    public Result login(@RequestBody Emp emp) {

        Emp res = empService.login(emp);
        log.info("login invoked, username: {}, password: {}", emp.getUsername(), emp.getPassword());

        if (res == null) {
            log.info("login fail: username and password does not match");
            return Result.error("用户名或密码错误");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", res.getId());
        claims.put("name", res.getName());
        claims.put("username", res.getUsername());
        String jwt = jwtUtils.jwtGenerate(claims);

        log.info("login success: jwt generated: {}", jwt);

        return Result.success(jwt);
    }
}
