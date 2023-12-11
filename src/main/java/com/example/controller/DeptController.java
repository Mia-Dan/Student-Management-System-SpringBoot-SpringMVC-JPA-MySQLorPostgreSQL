package com.example.controller;

import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DeptController {

    //@RequestMapping(path = "/depts", method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result listAll() {
        log.info("Dept listAll() invoked");
        return Result.success();
    }
}
