package com.example.emb.domain.manager.facade;

import com.example.emb.domain.manager.domain.Manager;
import com.example.emb.domain.manager.domain.repository.ManagerRepository;
import com.example.emb.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ManagerFacade {

    private final ManagerRepository managerRepository;

    public Manager getCurrentManager() {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return getById(id);
    }

    public Manager getById(String id) {
        return managerRepository.findById(id).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public Boolean checkManagerExists(String id) {
        return managerRepository.existsById(id);
    }

    public Long getManagerId() {
        return getCurrentManager().getManagerId();
    }

}
