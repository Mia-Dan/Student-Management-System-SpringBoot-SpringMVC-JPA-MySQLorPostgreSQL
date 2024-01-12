package com.example.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {

    private static String signKey = "some_secrte_string";
    private static Long expire = 1000 * 60 * 60 * 24L; // in 1 day

    public static String jwtGenerate(Map<String, Object> claims){

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();

        return jwt;
        // e.g., eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzA1MTIzNzk2LCJ1c2VybmFtZSI6ImFkbWluIn0.eHoBGOH01dfyaehDS9R8W_0MmEhRiaVPNuvxtK1ZJ5U
    }

    public static Claims jwtValidate(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();

        // will throw exception if expired or invalid
        // success iff jwt is valid and not expired

        return claims;

    }

}
