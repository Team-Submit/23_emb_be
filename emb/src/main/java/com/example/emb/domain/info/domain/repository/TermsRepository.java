package com.example.emb.domain.info.domain.repository;

import com.example.emb.domain.info.domain.Terms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TermsRepository extends JpaRepository<Terms, Long> {
<<<<<<< Updated upstream
    Terms findByTermId(Long id);
=======
    Terms findByTermId(Long term_id);

    List<Terms> findByNameAndBirthdate(String name, String birthdate);

    List<Terms> findByName(String name);
>>>>>>> Stashed changes
}
