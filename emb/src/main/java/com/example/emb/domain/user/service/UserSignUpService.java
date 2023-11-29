package com.example.emb.domain.user.service;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.domain.user.facade.UserFacade;
import com.example.emb.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.emb.domain.user.presentation.dto.response.UserSignUpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserSignUpResponse execute(UserSignUpRequest request) {

        User user = userFacade.getCurrentUser();

        user.UserSignUp(request.getUserName(), passwordEncoder.encode(request.getNewPassword()), request.getUserNumber(), request.getDepartment());


        return UserSignUpResponse.builder()
                .userName(request.getUserName())
                .newPassword(request.getNewPassword())
                .userNumber(request.getUserNumber())
                .department(request.getDepartment())
                .build();

    }
}