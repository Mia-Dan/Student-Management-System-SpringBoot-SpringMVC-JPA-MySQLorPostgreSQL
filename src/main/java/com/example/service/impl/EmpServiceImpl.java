package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.EmpPageBean;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public EmpPageBean page(Integer page, Integer pageSize) {
        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.listPage((page - 1) * pageSize, pageSize);
//        Parameter 'startPage' not found. Available parameters are [arg1, arg0, param1, param2]
        List<Emp> rows = empMapper.listPage(start, pageSize);

        Long total = empMapper.getTotalRows();

        return new EmpPageBean(total, rows);
    }

}
