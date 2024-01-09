package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.EmpPageBean;
import com.example.repository.EmpRepository;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {


    // MyBatis -------------------------------------------------------
//    @Autowired
//    private EmpMapper empMapper;

////    @Override
////    public EmpPageBean page(Integer page, Integer pageSize) {
////        Integer start = (page - 1) * pageSize;
////        List<Emp> rows = empMapper.listPage(start, pageSize);
////
////        Long total = empMapper.getTotalRows();
////
////        return new EmpPageBean(total, rows);
////    }
//
//    @Override
//    public EmpPageBean page(Integer page, Integer pageSize,
//                            String name, Short gender, LocalDate begin, LocalDate end
//                            ) {
//        PageHelper.startPage(page, pageSize);
//        List<Emp> rows = empMapper.listAll(name, gender, begin, end);
//        Page<Emp> p = (Page<Emp>) rows;
//        return new EmpPageBean(p.getTotal(), p.getResult());
//    }
//
//    @Override
//    public void save(Emp emp) {
//        emp.setCreateTime(LocalDateTime.now());
//        emp.setUpdateTime(LocalDateTime.now());
//        empMapper.save(emp);
//    }

    // JPA -------------------------------------------------------
    @Autowired
    private EmpRepository empRepository;

//    @Override
//    public EmpPageBean page(Integer page, Integer pageSize
////                            String name, Short gender, LocalDate begin, LocalDate end
//                            ) { // Pagination
//        Pageable pageable = org.springframework.data.domain.PageRequest.of(page - 1, pageSize);
//        List<Emp> rows = empRepository.findAll(pageable).getContent();
//        Long total = empRepository.count();
//
//        return new EmpPageBean(total, rows);
//    }

    @Override
    public EmpPageBean page(Integer page, Integer pageSize
                            , String name, Short gender, LocalDate begin, LocalDate end
    ) {
        Pageable pageable = org.springframework.data.domain.PageRequest.of(page - 1, pageSize);
//        List<Emp> rows = empRepository.findAll(pageable).getContent();

        List<Emp> rows = empRepository.queryByLots(pageable, name, gender, begin, end);


//        rows = empRepository.findByName(name);
//        rows = empRepository.findEmps11ByGender(gender);
//        rows = empRepository.findByGender(gender);
//        rows = empRepository.findById(id); // the last method exists before declaring in repository interface

        Long total = (long) rows.size();
//        Long total = empRepository.count();

        return new EmpPageBean(total, rows);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empRepository.save(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empRepository.findByUsernameAndPassword(emp.getUsername(), emp.getPassword());
    }
}
