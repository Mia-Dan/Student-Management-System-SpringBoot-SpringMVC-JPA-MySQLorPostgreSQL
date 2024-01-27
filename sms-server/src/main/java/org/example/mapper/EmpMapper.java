package org.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

//    @Select("select * from emp")
    List<Emp> listAll(@Param("name") String name, @Param("gender") Short gender, @Param("begin") LocalDate start , @Param("end") LocalDate end);
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    List<Emp> listPage( @Param("start")  Integer start, @Param("pageSize") Integer pageSize);
////    这样会报错：List<Emp> listPage( Integer start, Integer pageSize);
////      Parameter 'start' not found. Available parameters are [arg1, arg0, param1, param2]
////    * This typically occurs when MyBatis cannot match the parameters provided in the method signature with the parameters used in the SQL query.
//
//    @Select("select count(*) from emp")
//    Long getTotalRows();

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)"+
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void save(Emp emp);
}
