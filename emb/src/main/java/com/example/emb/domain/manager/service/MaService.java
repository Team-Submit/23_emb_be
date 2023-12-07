package com.example.emb.domain.manager.service;

import com.example.emb.domain.manager.domain.Manager;
import com.example.emb.domain.manager.domain.repository.ManagerRepository;
import com.example.emb.domain.manager.facade.ManagerFacade;
import com.example.emb.domain.user.presentation.dto.response.MaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MaService {
    private final ManagerFacade managerFacade;
    private final ManagerRepository managerRepository;

    @Transactional
    public MaResponse execute() {

        Manager manager = managerFacade.getCurrentManager();

        return MaResponse.builder()
                .managerId(manager.getManagerId())
                .id(manager.getId())
                .password(manager.getPassword())
                .build();
    }
}
