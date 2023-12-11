package com.example.service.impl;

import com.example.mapper.DeptMapper;
import com.example.pojo.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public List<Dept> listAll() {
        List<Dept> depts = deptMapper.listAll();
        return depts;
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }
}
