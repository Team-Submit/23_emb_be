package com.example.emb.domain.manager.service;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.domain.user.facade.UserFacade;
import com.example.emb.domain.user.presentation.dto.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UManagerUpdateService {

    private final UserRepository userRepository;

    @Transactional
    public void execute(Long number, UserUpdateRequest request) {

        User user = userRepository.findByNumber(number);

        user.Userupdate(request.getUserName(), request.getUserNumber(), request.getDepartment());
    }
}
