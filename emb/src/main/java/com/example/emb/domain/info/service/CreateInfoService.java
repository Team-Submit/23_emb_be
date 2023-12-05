package com.example.emb.domain.info.service;

import com.example.emb.domain.info.domain.Terms;
import com.example.emb.domain.info.domain.repository.TermsRepository;
import com.example.emb.domain.info.presentation.dto.request.CreateInfoRequest;
import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateInfoService {
    private final UserFacade userFacade;
    private final TermsRepository termsRepository;

    @Transactional
    public void execute(CreateInfoRequest request) {

        User user = userFacade.getCurrentUser();

        Terms terms = Terms.builder()
                .name(request.getName())
                .birthdate(request.getBirthdate())
                .address(request.getAddress())
                .firstTenure(request.getFirstTenure())
                .lastTenure(request.getLastTenure())
                .occupation(request.getOccupation())
                .userName(user.getUserName())
                .userNumber(user.getUserNumber())
                .build();
        termsRepository.save(terms);
    }
}
