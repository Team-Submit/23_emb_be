package com.example.emb.domain.auth.service;

import com.example.emb.domain.auth.exception.PasswordMisMatchException;
import com.example.emb.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.emb.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.emb.domain.manager.domain.Manager;
import com.example.emb.domain.manager.domain.repository.ManagerRepository;
import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.global.exception.UserNotFoundException;
import com.example.emb.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignInService {

    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserTokenResponse execute(UserSignInRequest request) {
        User user = userRepository.findByUserId(request.getId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        Manager manager = managerRepository.findById(request.getId()).orElse(null);

        if (!passwordEncoder.matches(request.getPassword(), user.getUserPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(user.getUserId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getUserId());

        if (manager != null) {
            return UserTokenResponse.builder()
                    .accessToken(accessToken)
                    .expiredAt(jwtTokenProvider.getExpiredTime())
                    .refreshToken(refreshToken)
                    .um(true)
                    .build();
        } else {
            return UserTokenResponse.builder()
                    .accessToken(accessToken)
                    .expiredAt(jwtTokenProvider.getExpiredTime())
                    .refreshToken(refreshToken)
                    .um(false)
                    .build();
        }
    }
}
