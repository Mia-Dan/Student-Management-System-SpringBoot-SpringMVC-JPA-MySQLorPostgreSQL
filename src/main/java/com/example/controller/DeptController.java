package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //@RequestMapping(path = "/depts", method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result listAll() {
        List<Dept> depts = deptService.listAll();
        log.info("Dept listAll() invoked");
        return Result.success(depts);
    }
}
