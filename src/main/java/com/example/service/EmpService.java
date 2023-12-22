package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.EmpPageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    EmpPageBean page(Integer page, Integer pageSize,
                     String name, Short gender, LocalDate begin, LocalDate end);

    void save(Emp emp);
}
