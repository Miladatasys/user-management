/*package com.javaev.usermanagement.security;


import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Bean
    public JwtParser jwtParser() {
        return Jwts.parser().setSigningKey(secret);
    }

    @Bean
    public JwtBuilder jwtBuilder() {
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, secret);
    }

    public String getSecret() {
        return secret;
    }

    public Long getExpiration() {
        return expiration;
    }
}
*/