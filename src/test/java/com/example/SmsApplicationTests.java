package com.example;

import com.example.pojo.Dept;
import com.example.service.DeptService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SmsApplicationTests {

    @Autowired
    DeptService deptService;

    //@Test
    void contextLoads() {
    }

    //@Test
    void jwtGenerate(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", "admin");
        claims.put("id", 1);

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "some_secrte_string")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .compact();

        System.out.println(jwt);
        // for what generate at 2024/1/12 1:13:xx pm
        //      body: {id=1, exp=1705123796, username=admin}
        // eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzA1MTIzNzk2LCJ1c2VybmFtZSI6ImFkbWluIn0.eHoBGOH01dfyaehDS9R8W_0MmEhRiaVPNuvxtK1ZJ5U
    }

    //@Test
    void jwtValidate(){
        Claims claims = Jwts.parser()
                .setSigningKey("some_secrte_string")
                // parseClaimsJwt() would fail for "signed ..."
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzA1MTIzNzk2LCJ1c2VybmFtZSI6ImFkbWluIn0.eHoBGOH01dfyaehDS9R8W_0MmEhRiaVPNuvxtK1ZJ5U")
                .getBody();

        // will throw exception if expired or invalid
        // success iff jwt is valid and not expired

        System.out.println(claims);

    }


    @Test
    void testAopDeptList(){
        deptService.listAll(); // 会触发aop DemoAspect
    }

    @Test
    void testAopDeptGetById(){
        deptService.getById(1); // 会触发aop DemoAspect
    }

    @Test
    void testAopDeptAdd(){
        Dept dept = new Dept();
        dept.setName("test");
        deptService.add(new Dept()); // 【不】会触发aop DemoAspect
    }


}
