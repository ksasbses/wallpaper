package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class SpringbootWebQuickstartApplicationTests {
    @Test
    public void testUuid(){
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    /**
     * 生产jwt令牌
     */
    @Test
    public void testGenJwt(){
        Map<String ,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"itheima") //签名算法
                .setClaims(claims) //自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) //设置有效期为1h
                .compact();
        System.out.println(jwt);
    }

    /**
     * 解析
     */
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4Mjc1ODQxNX0.dtrYh7JvD80JUljx4tlSy9X6wwBBjYTRbNNDNPffcHk")
                .getBody();
        System.out.println(claims);
    }

}
