package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpPageBean {
    // 被称为Java Bean的这些类, 具有如下特点:
    //      属性设为private,
    //      属性通过public的get/set方法访问
    private Long total; // 总记录数
    private List<Emp> rows; // 当前页的数据
}
