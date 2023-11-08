package com.example.emb.domain.auth.service;

import com.example.emb.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CheckUserIdExistsService {

    private final UserFacade userFacade;

    public void execute(String userid) {
        userFacade.checkUserIdExists(userid);
    }
}
