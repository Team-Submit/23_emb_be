package com.example.emb.domain.info.domain.repository;

import com.example.emb.domain.info.domain.Terms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TermsRepository extends JpaRepository<Terms, Long> {

    List<Terms> findByName(String keyword);
    List<Terms> findByBirthdate(String birthdate);
    List<Terms> findByNameAndBirthdate(String keyword, String birthdate);
}
