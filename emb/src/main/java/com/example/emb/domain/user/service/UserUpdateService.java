package com.example.emb.domain.user.service;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.domain.user.presentation.dto.request.UserUpdateRequest;
import com.example.emb.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserUpdateService {
    private final UserRepository userRepository;

    @Transactional
    public void execute(Long userId, UserUpdateRequest request) {
        User user = userRepository.findByNumber(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        user.Userupdate(request.getUserName(), request.getUserNumber(), request.getDepartment());
    }
}
