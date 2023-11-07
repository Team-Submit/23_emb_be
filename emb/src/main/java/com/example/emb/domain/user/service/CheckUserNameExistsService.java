package com.example.emb.domain.user.service;

import com.example.emb.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CheckUserNameExistsService {

    private final UserFacade userFacade;

    public void execute(String userName) {
        userFacade.checkUserNameExists(userName);
    }
}