package com.example.service.impl;

//import com.example.aop.MyLogAnnotation;
import com.example.aop.LogAnnotation;
import com.example.mapper.DeptMapper;
import com.example.pojo.Dept;
import com.example.repository.DeptRepository;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

//    MyBatis
//    @Autowired
//    DeptMapper deptMapper;
//
//    @Override
//    public List<Dept> listAll() {
//        List<Dept> depts = deptMapper.listAll();
//        return depts;
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        deptMapper.deleteById(id);
//    }
//
//    @Override
//    public void add(Dept dept) {
//        // 补全属性
//        dept.setCreateTime(LocalDateTime.now());
//        dept.setUpdateTime(LocalDateTime.now());
//
//        deptMapper.insert(dept);
//    }
//
//    @Override
//    public Dept getById(Integer id) {
//        return deptMapper.getById(id);
//    }
//
//    @Override
//    public void update(Dept dept) {
//        // 补全属性
//        dept.setUpdateTime(LocalDateTime.now());
//
//        deptMapper.updateById(dept);
//    }

    // JPA
    @Autowired
    DeptRepository deptRepository;

    @Override
//    @MyLogAnnotation
    public List<Dept> listAll() {
        List<Dept> depts = (List<Dept>) deptRepository.findAll();
        return depts;
    }

    @Override
    public void deleteById(Integer id) {
        deptRepository.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        // 补全属性
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptRepository.save(dept);
    }

    @Override
//    @MyLogAnnotation
    public Dept getById(Integer id) {
//        return deptRepository.findById(id);
        return deptRepository.findById(id).get();
    }

    @Override
    public void update(Dept dept) {
        // 补全属性
        dept.setUpdateTime(LocalDateTime.now());
        dept.setCreateTime(deptRepository.findById(dept.getId()).get().getCreateTime());
        deptRepository.save(dept); // JPA的CrudRepository中，save方法既可以新增也可以修改(但是obj的空缺值save进去，table那个字段会从有值变null)
    }
}
