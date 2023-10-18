package com.example.emb.global.property.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Base64;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "spring.security.jwt")
public class JwtProperties {

    private String secretKey;
    private Long accessExp;
    private Long refreshExp;

//    public JwtProperties(String secretKey, Long accessExp, Long refreshExp) {
//        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//        this.accessExp = accessExp;
//        this.refreshExp = refreshExp;
//    }

    public void setSecretKey(String secretKey) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }
}
