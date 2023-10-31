package com.example.emb.domain.info.service;

import com.example.emb.domain.info.domain.Terms;
import com.example.emb.domain.info.domain.repository.TermsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchPersonalService {

    private final TermsRepository termsRepository;

    @Transactional
    public List<Terms> execute(String name, String birthdate) {
        if (name != null && birthdate != null) {
            return termsRepository.findByNameAndBirthdate(name, birthdate);
        } else if (name != null) {
            return termsRepository.findByName(name);
        } else if (birthdate != null) {
            return termsRepository.findByBirthdate(birthdate);
        } else {
            return termsRepository.findAll();
        }
    }
}
