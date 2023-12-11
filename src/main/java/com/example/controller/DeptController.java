package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/depts/{id}") // 大括号内为路径变量
    public Result deleteById(@PathVariable("id") Integer id) { //路径变量用@PathVariable注解
        deptService.deleteById(id);
        log.info("Dept deleteById() invoked, id = " + id);
        return Result.success();
    }

    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) { //请求体用@RequestBody注解, 这里用实体类Dept接收json数据(请求体)
        deptService.add(dept);
        log.info("Dept add() invoked, dept = " + dept);
        return Result.success();
    }
}
