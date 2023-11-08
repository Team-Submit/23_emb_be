package com.example.emb.domain.auth.service;

import com.example.emb.domain.auth.domain.RefreshToken;
import com.example.emb.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.emb.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.emb.domain.auth.presentation.dto.response.UserTokenRefreshResponse;
import com.example.emb.global.property.jwt.JwtProperties;
import com.example.emb.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserTokenRefreshService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional
    public UserTokenRefreshResponse execute(String refreshToken) {
        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(jwtTokenProvider.parseToken(refreshToken))
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String newRefreshToken = jwtTokenProvider.generateRefreshToken(redisRefreshToken.getUserId());
        redisRefreshToken.updateToken(newRefreshToken, jwtProperties.getRefreshExp());

        String accessToken = jwtTokenProvider.generateAccessToken(redisRefreshToken.getUserId());
        return UserTokenRefreshResponse.builder()
                .accessToken(accessToken)
                .refreshToken(newRefreshToken)
                .expiredAt(jwtTokenProvider.getExpiredTime())
                .build();
    }
}
