package com.example.repository;


import com.example.pojo.Emp;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.*;

public interface EmpRepository extends PagingAndSortingRepository<Emp, Integer>, JpaSpecificationExecutor<Emp>, CustomEmpRepository {
    Emp findByUsernameAndPassword(String username, String password);
//    List<Emp> findEmps11ByGender(Short gender);
}


/* conditional paged query
    that works for MySQL but not PostgreSQL, due to null handling differences for :begin and :end (type Java's LocalDate)*/
/* public interface EmpRepository extends PagingAndSortingRepository<Emp, Integer>, JpaSpecificationExecutor<Emp> {

    @Query("select e from Emp e where (:name is null or e.name like %:name%) " +
            "and (e.gender = :gender or :gender is null) " +
            "and ((e.entrydate between :begin and :end) or :begin is null or :end is null)")

//@Query("select e from Emp e where (:name is null or e.name like %:name%) " +
//        "and (e.gender = :gender or :gender is null) " +
//        "and (e.entrydate between :begin and :end)")

//    @Query("select e from Emp e where :begin is null or :end is null or :name is null or :gender is null or e.gender = 1")
List<Emp> queryByLots(Pageable pageable,
                          @Param("name") String name,
                          @Param("gender") Short gender,
                          @Param("begin") LocalDate begin,
                          @Param("end") LocalDate end);

}
*/


/* sample dynamic query drawn from other projects */
/*
public interface sampleRepository extends  PagingAndSortingRepository<Emp, Integer>, JpaSpecificationExecutor<Emp>, CustomEmpRepository {
    public ResultBean searchMember(Integer page, Integer size, MemberQueryOv memberQueryOv) {
        Pageable pageable = PageRequest.of(page, size);
        PageRequest pageRequest = PageRequest.of(page, size);

        Specification<Member> specification = (Root<Member> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new LinkedList<>();
            predicates.add(cb.equal(root.get("isdelete"), 0));
            if (StringUtils.isNotBlank(memberQueryOv.getGonghao())) {
                predicates.add(cb.equal(root.get("gonghao").as(String.class), memberQueryOv.getGonghao()));

            }
            if (StringUtils.isNotBlank(memberQueryOv.getXingming())) {
                predicates.add(cb.like(root.get("xingming"),"%"+ memberQueryOv.getXingming()+"%"));

            }
            if (StringUtils.isNotBlank(memberQueryOv.getJuzhuaddress())) {
                predicates.add(cb.like(root.get("juzhuaddress"),"%"+ memberQueryOv.getJuzhuaddress()+"%"));

            }
            if (memberQueryOv.getYuangongzu().size() != 0) {
                Path<Object> path = root.get("yuangongzu");
                CriteriaBuilder.In<Object> in = cb.in(path);
                for (String str : memberQueryOv.getYuangongzu()) {
                    in.value(str);
                }
                predicates.add(cb.and(in));
            }
            if (memberQueryOv.getYuangongzizu().size() != 0) {
                Path<Object> path = root.get("yuangongzizu");
                CriteriaBuilder.In<Object> in = cb.in(path);
                for (String str : memberQueryOv.getYuangongzizu()) {
                    in.value(str);
                }
                predicates.add(cb.and(in));
            }
            if (StringUtils.isNotBlank(memberQueryOv.getCountry())) {
                predicates.add(cb.equal(root.get("country").as(String.class), memberQueryOv.getCountry()));
            }
            if (StringUtils.isNotBlank(memberQueryOv.getGender())) {
                predicates.add(cb.equal(root.get("gender").as(String.class), memberQueryOv.getGender()));
            }
            if (memberQueryOv.getMinzu().size() != 0) {
                Path<Object> path = root.get("minzu");
                CriteriaBuilder.In<Object> in = cb.in(path);
                for (String str : memberQueryOv.getMinzu()) {
                    in.value(str);
                }
                predicates.add(cb.and(in));
            }
            //  年龄
            if (memberQueryOv.getAge().size() != 0) {
                Path<Object> path = root.get("agelabel");
                CriteriaBuilder.In<Object> in = cb.in(path);
                for (String str : memberQueryOv.getAge()) {
                    in.value(str);
                }
                predicates.add(cb.and(in));
            }
            //党派
            if (memberQueryOv.getDangpai().size() != 0) {
                Path<Object> path = root.get("dangpai");
                CriteriaBuilder.In<Object> in = cb.in(path);
                for (String str : memberQueryOv.getDangpai()) {
                    in.value(str);
                }
                predicates.add(cb.and(in));
            }
            if (memberQueryOv.getTongzhanpartyId().size() != 0) {
                Set<Long> memberIdlist = memberRepository.findByTzpartyIds(memberQueryOv.getTongzhanpartyId());
                Path<Object> path = root.get("id");
                CriteriaBuilder.In<Object> in = cb.in(path);
                for(Long id:memberIdlist){
                    in.value(id);
                }
                predicates.add(cb.and(in));
            }
            if (memberQueryOv.getXuewei().size() != 0) {
                Path<Object> path = root.get("xuewei");
                CriteriaBuilder.In<Object> in = cb.in(path);
                for (String str : memberQueryOv.getXuewei()) {
                    in.value(str);
                }
                Path<Object> path1 = root.get("zzxuewei");
                CriteriaBuilder.In<Object> zzin = cb.in(path1);
                for (String str : memberQueryOv.getXuewei()) {
                    zzin.value(str);
                }
                predicates.add(cb.or(zzin, in));

            }
            if (memberQueryOv.getZhichengjibie().size() != 0) {
                Path<Object> path = root.get("zhichengjibie");
                CriteriaBuilder.In<Object> in = cb.in(path);
                int flag =0;//标记有没有其他
                Set<String> paichu = new HashSet<>();
                paichu.add("正高级");
                paichu.add("副高级");
                paichu.add("中级");
                for (String str : memberQueryOv.getZhichengjibie()) {
                    if(str.equals("其他")){
                        flag = 1;
                    }else {
                        in.value(str);
                        paichu.remove(str);
                    }

                }
                if(flag == 1){
                    CriteriaBuilder.In<Object> newin = cb.in(path);
                    for(String str:paichu){
                        newin.value(str);
                    }
                    predicates.add(cb.and(newin.not()));
                }else {
                    predicates.add(cb.and(in));
                }

            }
            if (memberQueryOv.getZhuanjiatype().size() != 0) {
                Path<Object> path = root.get("zhuanjiatype");
                CriteriaBuilder.In<Object> in = cb.in(path);
                for (String str : memberQueryOv.getZhuanjiatype()) {
                    in.value(str);
                }
                predicates.add(cb.and(in));
            }
            //单位到一级部门
            if (memberQueryOv.getDanwei().size() != 0) {
//                Path<Object> path = root.get("dep1");
//                CriteriaBuilder.In<Object> in = cb.in(path);
//                for (String str : memberQueryOv.getDanwei()) {
//                    in.value(str);
//                }
//                predicates.add(cb.and(in));
//                List<String> searchdanwei = memberQueryOv.getDanwei();
//                List<String> newsearchdanwei = new ArrayList<>();
//                for(String danwei:searchdanwei){
//                    String[] strings = danwei.split(",");
//                    for(String s:strings){
//                        if(!newsearchdanwei.contains(s)){
//                            newsearchdanwei.add(s);
//                        }
//                    }
//                }
                List<String> danweis = memberQueryOv.getDanwei();
                Set<Long> memberIdlist = memberRepository.findByDept1(danweis.get(0));
                for(String danwei:danweis){
                    memberIdlist.addAll(memberRepository.findByDept1(danwei));
                }
                Path<Object> path = root.get("id");
                CriteriaBuilder.In<Object> in = cb.in(path);
                for(Long id:memberIdlist){
                    in.value(id);
                }
                predicates.add(cb.and(in));
            }
            if (memberQueryOv.getZhiwujibie().size() != 0) {
                Path<Object> path = root.get("zhichengjibie");
                CriteriaBuilder.In<Object> in = cb.in(path);
                for (String str : memberQueryOv.getZhiwujibie()) {
                    in.value(str);
                }
                predicates.add(cb.and(in));
            }
            if (StringUtils.isNotBlank(memberQueryOv.getAboard())) {
                if (memberQueryOv.getAboard().equals("1")) {//1有海外学习
                    predicates.add(cb.isNotNull(root.get("abroad").as(String.class)));
                } else {
                    predicates.add(cb.isNull(root.get("abroad").as(String.class)));
                }
            }
            if (memberQueryOv.getJobaddress().size() != 0) {
                Path<Object> path = root.get("jobaddress");
                CriteriaBuilder.In<Object> in = cb.in(path);
                for (String str : memberQueryOv.getJobaddress()) {
                    in.value(str);
                }
                predicates.add(cb.and(in));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };

        Page<Member> members = memberRepository.findAll(specification, pageable);
        List<Member> list = members.getContent();
        return ResultBean.success(list, Integer.valueOf(String.valueOf(members.getTotalElements())));
    }   // other methods...

}
 */
