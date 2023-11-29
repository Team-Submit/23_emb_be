package com.example.emb.domain.user.service;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.exception.AlreadyUserExistException;
import com.example.emb.domain.user.facade.UserFacade;
import com.example.emb.domain.user.presentation.dto.request.UserNameRequest;
import com.example.emb.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CheckUserNameExistsService {

    private final UserFacade userFacade;

    public void execute(UserNameRequest request) {

        User user = userFacade.getCurrentUser();

        if (user.getUserName() == null) {
            throw UserNotFoundException.EXCEPTION;
        }
        else if (user.getUserName().equals(request.getUserName())) {
            throw AlreadyUserExistException.EXCEPTION;
        }
        else {
            throw UserNotFoundException.EXCEPTION;
        }
    }
}