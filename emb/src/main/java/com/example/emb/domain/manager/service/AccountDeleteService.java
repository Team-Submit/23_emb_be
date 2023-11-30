package com.example.emb.domain.manager.service;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AccountDeleteService {

    private final UserRepository userRepository;

    @Transactional
    public void execute(Long userId) {

        User user = userRepository.findByNumber(userId);

        userRepository.delete(user);
    }
}
