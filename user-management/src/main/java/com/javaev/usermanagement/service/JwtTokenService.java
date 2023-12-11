/*package com.javaev.usermanagement.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaev.usermanagement.model.User;
import com.javaev.usermanagement.security.JwtConfig;

import java.util.Date;

@Service
public class JwtTokenService {

    @Autowired
    private JwtConfig jwtConfig;

    public String generateToken(User user) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + jwtConfig.getExpiration() * 1000);

        JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(user.getEmail())
                .claim("id", user.getId())
                .claim("name", user.getName())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, jwtConfig.getSecret());

        return jwtBuilder.compact();
    }

    public Claims parseToken(String token) {
        return jwtConfig.jwtParser().parseClaimsJws(token).getBody();
    }
}
*/