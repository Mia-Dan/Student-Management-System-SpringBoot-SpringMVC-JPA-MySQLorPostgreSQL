package com.example.repository;

import com.example.pojo.Emp;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//public interface EmpRepository extends PagingAndSortingRepository<Emp, Integer>, JpaSpecificationExecutor<Emp> {

//    @Query("select e from Emp e where (:name is null or e.name like %:name%) " +
//            "and (e.gender = :gender or :gender is null) " +
//            "and ((e.entrydate between :begin and :end) or :begin is null or :end is null)")

//@Query("select e from Emp e where (:name is null or e.name like %:name%) " +
//        "and (e.gender = :gender or :gender is null) " +
//        "and (e.entrydate between :begin and :end)")

//    @Query("select e from Emp e where :begin is null or :end is null or :name is null or :gender is null or e.gender = 1")
//List<Emp> queryByLots(Pageable pageable,
//                          @Param("name") String name,
//                          @Param("gender") Short gender,
//                          @Param("begin") LocalDate begin,
//                          @Param("end") LocalDate end);

//}

public interface EmpRepository extends PagingAndSortingRepository<Emp, Integer>, JpaSpecificationExecutor<Emp>, CustomEmpRepository {
    // other methods...
}