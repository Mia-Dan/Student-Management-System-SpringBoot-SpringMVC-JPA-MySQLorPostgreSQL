package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.EmpPageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    EmpPageBean page(Integer page, Integer pageSize,
                     String name, Short gender, LocalDate begin, LocalDate end);

    Emp login(Emp emp); // 0 or 1 emp return is possible (since username is unique)

    void save(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void update(Emp emp);
}
