package com.example.emb.domain.manager.service;

import com.example.emb.domain.manager.domain.Manager;
import com.example.emb.domain.manager.domain.repository.ManagerRepository;
import com.example.emb.domain.manager.presentation.dto.request.ManagerSignUpRequest;
import com.example.emb.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MService {

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;
    private final ManagerRepository managerRepository;

    @Transactional
    public void execute(ManagerSignUpRequest request) {

        managerRepository.save(Manager.builder()
                .id(request.getId())
                .password(passwordEncoder.encode(request.getPassword()))
                .build());
    }
}
