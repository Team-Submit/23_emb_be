package com.example.emb.domain.user.service;

import com.example.emb.domain.info.domain.Terms;
import com.example.emb.domain.info.domain.repository.TermsRepository;
import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.facade.UserFacade;
import com.example.emb.domain.user.presentation.dto.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class UserUpdateService {

    private final UserFacade userFacade;
    private final TermsRepository termsRepository;

    @Transactional
    public void execute(UserUpdateRequest request) {

        User user = userFacade.getCurrentUser();
        List<Terms> termsList = termsRepository.findByNumber(user.getNumber());


        user.Userupdate(request.getUserName(), request.getUserNumber(), request.getDepartment());
        for (Terms terms : termsList) {
            terms.termsUpdate(request.getUserName(), request.getUserNumber(), request.getDepartment());
        }
    }
}
