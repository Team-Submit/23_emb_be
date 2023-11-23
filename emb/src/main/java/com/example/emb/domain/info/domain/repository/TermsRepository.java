package com.example.emb.domain.info.domain.repository;

import com.example.emb.domain.info.domain.Terms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermsRepository extends JpaRepository<Terms, Long> {
    Terms findByTermId(Long id);
}
