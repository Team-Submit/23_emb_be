package com.example.emb.domain.info.service;

import com.example.emb.domain.info.domain.Terms;
import com.example.emb.domain.info.domain.repository.TermsRepository;
import com.example.emb.domain.info.presentation.dto.response.SearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchInfoService {

    private final TermsRepository termsRepository;

    public List<SearchResponse> execute(String name, String birthdate) {



        List<Terms> terms;

        if (birthdate != null && birthdate.equals("''")) {
            terms = termsRepository.findByName(name);
        } else if (name != null && birthdate != null) {
            terms = termsRepository.findByNameAndBirthdate(name, birthdate);
        } else {
            terms = termsRepository.findAll();
        }

        return terms.stream()
                .map(SearchInfoService::mapTerms)
                .collect(Collectors.toList());
    }

    public static SearchResponse mapTerms(Terms terms) {
        return new SearchResponse(
                terms.getTermId(),
                terms.getName(),
                terms.getBirthdate(),
                terms.getAddress(),
                terms.getFirstTenure(),
                terms.getLastTenure(),
                terms.getOccupation(),
                terms.getIssuingDepartment(),
                terms.getCurrentUserName(),
                terms.getCurrentUserNumber()
        );
    }

}
