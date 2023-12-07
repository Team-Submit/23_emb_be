package com.example.emb.domain.manager.service;

import com.example.emb.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.emb.domain.manager.facade.ManagerFacade;
import com.example.emb.domain.manager.presentation.dto.request.ManagerSignUpRequest;
import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.domain.user.facade.UserFacade;
import com.example.emb.global.property.jwt.JwtProperties;
import com.example.emb.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class AccountSignUpService {

    private final UserFacade userFacade;
    private final ManagerFacade managerFacade;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public void execute(ManagerSignUpRequest request) {
        managerFacade.getCurrentManager();
        userFacade.checkUserIdExists(request.getId());

        userRepository.save(User.builder()
                .userId(request.getId())
                .userPassword(passwordEncoder.encode(request.getPassword()))
                .build());
    }
}
