package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select * from emp limit #{start}, #{pageSize}")
    List<Emp> listPage( @Param("start")  Integer start, @Param("pageSize") Integer pageSize);

    // 这样会报错：List<Emp> listPage( Integer start, @Param("pageSize") Integer pageSize);

    // @Select("select * from emp limit #{start}, #{pageSize}")
    // List<Emp> listPage( @Param("start")  Integer start, @Param("pageSize") Integer pageSize);
    // Would work // 通过debugger + 源码调用stack & local var值 , 调错

    // @Select("select * from emp limit #{arg0}, #{pageSize}")
    // List<Emp> listPage( Integer start, @Param("arg0") Integer pageSize);
    // Would work // 通过debugger + 源码调用stack & local var值 , 调错

    // @Select("select * from emp limit #{param1}, #{pageSize}")
    // List<Emp> listPage( Integer start, @Param("pageSize") Integer pageSize);
    // Would work // 通过debugger + 源码调用stack & local var值 , 调错

//    List<Emp> listPage(Integer start, Integer pageSize);
//    Would still lead to error:
//      Parameter 'start' not found. Available parameters are [arg1, arg0, param1, param2]

//    List<Emp> listPage(int start, int pageSize);
//    Would lead to error:
//      Parameter 'start' not found. Available parameters are [arg1, arg0, param1, param2]
//    * This typically occurs when MyBatis cannot match the parameters provided in the method signature with the parameters used in the SQL query.


    @Select("select count(*) from emp")
    Long getTotalRows();

}
