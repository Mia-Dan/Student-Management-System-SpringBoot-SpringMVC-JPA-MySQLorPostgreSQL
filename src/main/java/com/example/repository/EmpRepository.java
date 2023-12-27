package com.example.repository;

import com.example.pojo.Emp;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface EmpRepository extends PagingAndSortingRepository<Emp, Integer>, JpaSpecificationExecutor<Emp> {

//    @Query("select e from Emp e where e.name like %:name% and e.gender = :gender and e.entrydate between :begin and :end, limit :page, :pageSize")
//    List<Emp> queryByLots(Pageable pageable,
//                          @Param("name") String name,
//                          @Param("gender") Short gender,
//                          @Param("begin") LocalDate begin,
//                          @Param("end") LocalDate end);

    @Query("select e from Emp e where e.name like %:name% and e.gender = :gender and e.entrydate between :begin and :end")
    List<Emp> queryByLots(Pageable pageable,
                          @Param("name") String name,
                          @Param("gender") Short gender,
                          @Param("begin") LocalDate begin,
                          @Param("end") LocalDate end);

}
