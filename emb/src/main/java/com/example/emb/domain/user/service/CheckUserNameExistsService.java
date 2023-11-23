package com.example.emb.domain.user.service;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.domain.user.exception.AlreadyUserExistException;
import com.example.emb.domain.user.facade.UserFacade;
import com.example.emb.domain.user.presentation.dto.request.UserNameRequest;
import com.example.emb.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CheckUserNameExistsService {

    private final UserRepository userRepository;

    public void execute(Long userId, UserNameRequest request) {

        User user = userRepository.findByNumber(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

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