package com.example.emb.domain.manager.service;

import com.example.emb.domain.manager.facade.ManagerFacade;
import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.domain.user.presentation.dto.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UManagerUpdateService {

    private final UserRepository userRepository;
    private final ManagerFacade managerFacade;

    @Transactional
    public void execute(Long number, UserUpdateRequest request) {

        managerFacade.getCurrentManager();
        User user = userRepository.findByNumber(number);

        user.Userupdate(request.getUserName(), request.getUserNumber(), request.getDepartment());
    }
}
