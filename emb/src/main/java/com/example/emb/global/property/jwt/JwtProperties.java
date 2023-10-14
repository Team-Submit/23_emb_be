package com.example.emb.global.property.jwt;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Base64;

@Getter
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String secretKey;
    private Long accessExp;
    private Long refreshExp;

    public JwtProperties(Long accessExp, Long refreshExp) {
        this.accessExp = accessExp;
        this.refreshExp = refreshExp;
    }

    public void setSecretKey(String secretKey) {
        // Base64 인코딩을 이곳에서 수행
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }
}
