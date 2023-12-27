package com.example.repository;

import com.example.pojo.Emp;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmpRepository extends PagingAndSortingRepository<Emp, Integer> {

}
