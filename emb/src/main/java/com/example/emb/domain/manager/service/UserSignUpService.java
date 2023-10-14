package com.example.emb.domain.manager.service;

import com.example.emb.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.emb.domain.manager.domain.Manager;
import com.example.emb.domain.manager.domain.repository.ManagerRepository;
import com.example.emb.domain.manager.facade.ManagerFacade;
import com.example.emb.domain.manager.presentation.dto.request.UserSignUpRequest;
import com.example.emb.global.property.jwt.JwtProperties;
import com.example.emb.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final ManagerFacade managerFacade;
    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional
    public UserTokenResponse execute(UserSignUpRequest request) {
        managerFacade.checkManagerExists(request.getId());

        Manager manager = managerRepository.save(Manager.builder()
                .id(request.getId())
                .password(passwordEncoder.encode(request.getPassword()))
                .build());
        
        String accessToken = jwtTokenProvider.generateAccessToken(manager.getId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(manager.getId());
        
        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(ZonedDateTime.now().plusSeconds(jwtProperties.getAccessExp()))
                .refreshToken(refreshToken)
                .build();
    }
}
