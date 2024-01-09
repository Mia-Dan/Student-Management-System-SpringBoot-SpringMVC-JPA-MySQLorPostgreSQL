package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping({"/login"})
    public Result login(@RequestBody Emp emp) {

        Emp res = empService.login(emp);

        log.info("login invoked, username: {}, password: {}", emp.getUsername(), emp.getPassword());
        return res!=null?Result.success():Result.error("用户名或密码错误");
    }
}
