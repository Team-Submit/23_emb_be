package com.example.emb.domain.user.service;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.domain.user.presentation.dto.response.GetUserInfoResponse;
import com.example.emb.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetUserInfoService {

    private final UserRepository userRepository;

    public GetUserInfoResponse excute(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return GetUserInfoResponse.builder()
                .department(user.getDepartment())
                .userName(user.getUserName())
                .userNumber(user.getUserNumber())
                .build();
    }
}
