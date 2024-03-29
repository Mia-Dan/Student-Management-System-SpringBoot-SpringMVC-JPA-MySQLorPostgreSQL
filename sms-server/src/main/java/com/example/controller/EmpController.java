package com.example.controller;


import com.example.aop.LogAnnotation;
import com.example.pojo.Emp;
import com.example.pojo.EmpPageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    // 请求样例: /emps?name=张&gender=1&begin=2007-09-01&end=2022-09-01&page=1&pageSize=10
    @GetMapping("/emps")
    public Result listPage(@RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           String name, Short gender,
//                           LocalDate begin, LocalDate end // Resolved [org.springframework.web.method.annotation.MethodArgumentTypeMismatchException: Failed to convert value of type 'java.lang.String' to required type 'java.time.LocalDate'; nested exception is org.springframework.core.convert.ConversionFailedException: Failed to convert from type [java.lang.String] to type [java.time.LocalDate] for value '2007-09-01'; nested exception is java.lang.IllegalArgumentException: Parse attempt failed for value [2007-09-01]]
                           @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                           @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
                           ){
        EmpPageBean empPageBean = empService.page(page, pageSize, name, gender, begin, end);
        log.info("Emp listPage() invoked, page = " + page + ", pageSize = " + pageSize + ", name = " + name + ", gender = " + gender + ", begin = " + begin + ", end = " + end);
        return Result.success(empPageBean);
    }

    @GetMapping("/emps/{id}")
    public Result getById(@PathVariable("id") Integer id) {
        Emp emp = empService.getById(id);
        log.info("Emp getById() invoked, id = " + id);
        return Result.success(emp);
    }

    @LogAnnotation
    @DeleteMapping("/emps/{ids}")
    public Result deleteByIds(@PathVariable("ids") List<Integer> ids) {
        empService.deleteByIds(ids);
        log.info("Emp deleteByIds() invoked, ids = " + ids);
        return Result.success();
    }

    @LogAnnotation
    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        log.info("Emp update() invoked, emp = " + emp);
        return Result.success();
    }

    @LogAnnotation
    @PostMapping("/emps")
    public Result save(@RequestBody Emp emp){
        empService.save(emp);
        log.info("Emp save() invoked, emp = " + emp);
        return Result.success();
    }

}
