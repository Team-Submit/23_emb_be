package com.example.emb.domain.user.service;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.domain.user.exception.AlreadyUserExistException;
import com.example.emb.domain.user.facade.UserFacade;
import com.example.emb.domain.user.presentation.dto.request.UserNameRequest;
import com.example.emb.domain.user.presentation.dto.response.UserCheckResponse;
import com.example.emb.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CheckUserNameExistsService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    public UserCheckResponse execute(UserNameRequest request) {

        Optional<User> userOptional = userRepository.findByUserId(request.getUserid());

        if (userOptional.isPresent()) {
            String user = userFacade.getCurrentUser().getUserName();
            String userNameFromDB = userOptional.get().getUserName();

            if (user != null && user.equals(userNameFromDB)) {
                return UserCheckResponse.builder().firstLogin(false).build();
            } else {
                return UserCheckResponse.builder().firstLogin(true).build();
            }

        } else {
            return UserCheckResponse.builder().firstLogin(false).build();
        }
    }
}