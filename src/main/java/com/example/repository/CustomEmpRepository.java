package com.example.repository;

import com.example.pojo.Emp;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface CustomEmpRepository {
    List<Emp> queryByLots(Pageable pageable, String name, Short gender, LocalDate begin, LocalDate end);
}
