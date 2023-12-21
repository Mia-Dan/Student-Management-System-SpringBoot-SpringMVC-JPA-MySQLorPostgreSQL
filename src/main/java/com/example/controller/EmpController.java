package com.example.controller;


import com.example.pojo.EmpPageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    // // 请求样例: /emps?name=张&gender=1&begin=2007-09-01&end=2022-09-01&page=1&pageSize=10
    // 请求样例: /emps?page=1&pageSize=10
    @GetMapping("/emps")
//    public EmpPageBean listPage(int page, int pageSize){ // page和pageSize是请求参数,NOTICE: 命名需要与前端传来的完全一致
    public Result listPage(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("Emp listPage() invoking, page = " + page + ", pageSize = " + pageSize);
        EmpPageBean empPageBean = empService.page(page, pageSize);
        log.info("Emp listPage() invoked, page = " + page + ", pageSize = " + pageSize);
        return Result.success(empPageBean);
    }


}
