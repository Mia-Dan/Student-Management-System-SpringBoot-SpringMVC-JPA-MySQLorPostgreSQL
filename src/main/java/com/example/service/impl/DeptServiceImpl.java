package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    EmpMapper empMapper;

    @Override
    public List<Dept> listAll() {
        List<Dept> depts = empMapper.listAll();
        return depts;
    }
}
