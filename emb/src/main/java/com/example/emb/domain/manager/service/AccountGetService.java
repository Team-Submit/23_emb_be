package com.example.emb.domain.manager.service;

import com.example.emb.domain.manager.facade.ManagerFacade;
import com.example.emb.domain.manager.presentation.dto.response.UserGetResponse;
import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AccountGetService {

    private final UserRepository userRepository;
    private final ManagerFacade managerFacade;

    @Transactional
    public UserGetResponse execute(Long number) {

        //managerFacade.getCurrentManager();
        User user = userRepository.findByNumber(number);

        return UserGetResponse.builder()
                .userName(user.getUserName())
                .userNumber(user.getUserNumber())
                .department(user.getDepartment())
                .build();
    }
}
