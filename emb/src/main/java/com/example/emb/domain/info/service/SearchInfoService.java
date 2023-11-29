package com.example.emb.domain.info.service;

import com.example.emb.domain.info.domain.Terms;
import com.example.emb.domain.info.domain.repository.TermsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchInfoService {

    private final TermsRepository termsRepository;

    public List<Terms> execute(String name, String birthdate) {

        List<Terms> terms;

        if (birthdate == null) {
            terms = termsRepository.findByName(name);
        } else if (name != null && birthdate != null) {
            terms = termsRepository.findByNameAndBirthdate(name, birthdate);
        } else {
            terms = termsRepository.findAll();
        }

        return terms;
    }
}
