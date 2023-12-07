package com.example.emb.domain.manager.facade;

import com.example.emb.domain.manager.domain.Manager;
import com.example.emb.domain.manager.domain.repository.ManagerRepository;
import com.example.emb.domain.manager.exception.AlreadyManagerExistException;
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
        return getManagerById(id);
    }

    public Manager getManagerById(String id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public Manager getManagerBymanagerId(Long managerId) {
        return managerRepository.findById(managerId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkManagerExists(String id) {
        if(managerRepository.findById(id).isPresent()) {
            throw AlreadyManagerExistException.EXCEPTION;
        }
    }

}
