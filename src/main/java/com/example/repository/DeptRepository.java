package com.example.repository;

import com.example.pojo.Dept;
import org.springframework.data.repository.CrudRepository;

public interface DeptRepository extends CrudRepository<Dept, Integer> {
}
