package com.example.pojo;

public class Dept {
}

// Without the definition of Dept, the following unexpected outcome occurs:

// http://localhost:8080/dept/listAll returns:
//{
//        "code": 1,
//        "msg": "success",
//        "data": [
//        null,
//        null,
//        null,
//        null,
//        null
//        ]
//        }

// Terminal output:
//    JDBC Connection [HikariProxyConnection@219948283 wrapping com.mysql.cj.jdbc.ConnectionImpl@1a1c4527] will not be managed by Spring
//        ==>  Preparing: select * from dept
//        ==> Parameters:
//        <==    Columns: id, name, create_time, update_time
//        <==        Row: 1, 学工部, 2023-12-11 11:13:31, 2023-12-11 11:13:31
//        <==        Row: 2, 教研部, 2023-12-11 11:13:31, 2023-12-11 11:13:31
//        <==        Row: 3, 咨询部, 2023-12-11 11:13:31, 2023-12-11 11:13:31
//        <==        Row: 4, 就业部, 2023-12-11 11:13:31, 2023-12-11 11:13:31
//        <==        Row: 5, 人事部, 2023-12-11 11:13:31, 2023-12-11 11:13:31
//        <==      Total: 5
//        Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@616908cd]