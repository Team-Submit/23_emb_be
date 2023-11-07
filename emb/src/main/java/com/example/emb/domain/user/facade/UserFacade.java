package com.example.emb.domain.user.facade;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.domain.user.exception.AlreadyUserExistException;
import com.example.emb.domain.user.exception.AlreadyUserIdExistsException;
import com.example.emb.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByUserId(userId);
    }

    public User getUserByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkUserIdExists(String userId) {
        if (userRepository.findByUserId(userId).isPresent()) {
            throw AlreadyUserIdExistsException.EXCEPTION;
        }
    }
<<<<<<< HEAD
<<<<<<< Updated upstream
=======

    public void checkUserNameExists(String userName) {
        if (userRepository.findByUserName(userName).isPresent()) {
            throw AlreadyUserExistException.EXCEPTION;
        }
    }
>>>>>>> Stashed changes
=======

    public void checkUserNameExists(String userName) {
        if (userRepository.findByUsername(userName).isPresent()) {
            throw AlreadyUserExistException.EXCEPTION;
        }
    }
>>>>>>> develop
}
