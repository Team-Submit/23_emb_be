package com.example.emb.domain.user.service;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.domain.user.facade.dto.UserSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User execute(UserSignUpRequest request) {

        return userRepository.save(User.builder()
                .userName(request.getUserName())
                .userPassword(request.getNewPassword())
//                .userPassword(passwordEncoder.encode(request.getNewPassword()))
                .userNumber(request.getUserNumber())
                .department(request.getDepartment())
                .build());
    }

}