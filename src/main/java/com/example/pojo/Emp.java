package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emp")
public class Emp {

    // auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "emp_id_seq", sequenceName = "emp_id_seq", allocationSize = 1) // allocationSize: 每次递增的量
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_id_seq")
//    Hibernate:
//
//    create table emp_id_seq (
//            next_val bigint
//    ) engine=InnoDB
//    Hibernate:
//
//    insert into emp_id_seq values ( 1 )
    private Integer id; //ID

    @Column(name = "username", unique = true, nullable = false, length = 20)
    private String username; //用户名

    @Column(name = "password", length = 32)
    @ColumnDefault("123456") // set default value=123456
    private String password; //密码

    @Column(name = "name", nullable = false, length = 10)
    private String name; //姓名

    @Column(name = "gender", nullable = false, columnDefinition = "tinyint unsigned")
    @Comment("性别, 说明: 1 男, 2 女")
    private Short gender; //性别 , 1 男, 2 女

    private String image; //图像url
    private Short job; //职位 , 1 班主任 , 2 讲师 , 3 学工主管 , 4 教研主管 , 5 咨询师
    private LocalDate entrydate; //入职日期 // map to `entrydate` in table `emp`
    private Integer deptId; //部门ID // map to `dept_id` in table `emp`
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
