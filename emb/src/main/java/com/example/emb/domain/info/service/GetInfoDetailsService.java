package com.example.emb.domain.info.service;

import com.example.emb.domain.info.domain.Terms;
import com.example.emb.domain.info.domain.repository.TermsRepository;
import com.example.emb.domain.info.presentation.dto.response.GetInfoDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetInfoDetailsService {

    private final TermsRepository termsRepository;

    public GetInfoDetailsResponse getDetails(Long id) {
        Terms terms = termsRepository.findByTermId(id);

        return new GetInfoDetailsResponse(
                terms.getName(),
                terms.getBirthdate(),
                terms.getAddress(),
                terms.getFirstTenure(),
                terms.getLastTenure(),
                terms.getOccupation(),
                terms.getDepartment(),
                terms.getUserName(),
                terms.getUserNumber()
        );
    }
}
