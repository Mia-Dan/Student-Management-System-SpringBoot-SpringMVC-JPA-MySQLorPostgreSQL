package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> listAll();

    void deleteById(Integer id);

    void add(Dept dept);
}
