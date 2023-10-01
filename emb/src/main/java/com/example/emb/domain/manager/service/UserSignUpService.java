package com.example.emb.domain.manager.service;

import com.example.emb.domain.manager.domain.Manager;
import com.example.emb.domain.manager.domain.repository.ManagerRepository;
import com.example.emb.domain.manager.presentation.dto.request.UserSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String execute(UserSignUpRequest request) {
        Manager manager = managerRepository.findById(request.getId());
        if (manager != null) {
            return "이미 등록된 ID";
        }

        managerRepository.save(Manager.builder()
                .id(request.getId())
                .password(passwordEncoder.encode(request.getPassword()))
                .build());

        return "회원가입이 완료";
    }
}
