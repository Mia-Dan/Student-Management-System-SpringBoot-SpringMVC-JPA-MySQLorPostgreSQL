package com.example.repository.impl;

import com.example.pojo.Emp;
import com.example.repository.CustomEmpRepository;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomEmpRepositoryImpl implements CustomEmpRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Emp> queryByLots(Pageable pageable, String name, Short gender, LocalDate begin, LocalDate end) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Emp> cq = cb.createQuery(Emp.class);

        Root<Emp> emp = cq.from(Emp.class);
        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(cb.like(emp.get("name"), "%" + name + "%"));
        }
        if (gender != null) {
            predicates.add(cb.equal(emp.get("gender"), gender));
        }
        if (begin != null && end != null) {
            predicates.add(cb.between(emp.get("entrydate"), begin, end));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Emp> query = entityManager.createQuery(cq);

        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        return query.getResultList();
    }
}