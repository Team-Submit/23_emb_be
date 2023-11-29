package com.example.emb.domain.user.service;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.facade.UserFacade;
import com.example.emb.domain.user.presentation.dto.response.GetUserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetUserInfoService {

    private final UserFacade userFacade;

    public GetUserInfoResponse excute() {

        User user = userFacade.getCurrentUser();

        return GetUserInfoResponse.builder()
                .department(user.getDepartment())
                .userName(user.getUserName())
                .userNumber(user.getUserNumber())
                .build();
    }
}
