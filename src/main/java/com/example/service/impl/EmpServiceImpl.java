package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.EmpPageBean;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public EmpPageBean page(Integer page, Integer pageSize) {
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.listPage(start, pageSize);
//
//        Long total = empMapper.getTotalRows();
//
//        return new EmpPageBean(total, rows);
//    }

    @Override
    public EmpPageBean page(Integer page, Integer pageSize,
                            String name, Short gender, LocalDate begin, LocalDate end
                            ) {
        PageHelper.startPage(page, pageSize);
        List<Emp> rows = empMapper.listAll(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) rows;
        return new EmpPageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.save(emp);
    }
}
