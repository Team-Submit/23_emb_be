package com.example.emb.global.security.jwt;

import com.example.emb.global.property.jwt.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JwtProperties.class)
public class JwtConfiguration {

    @Autowired
    private JwtProperties jwtProperties;
}
