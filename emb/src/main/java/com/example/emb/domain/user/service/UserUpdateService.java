package com.example.emb.domain.user.service;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.facade.UserFacade;
import com.example.emb.domain.user.presentation.dto.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserUpdateService {

    private final UserFacade userFacade;

    @Transactional
    public void execute(UserUpdateRequest request) {

        User user = userFacade.getCurrentUser();

        user.Userupdate(request.getUserName(), request.getUserNumber(), request.getDepartment());
    }
}
