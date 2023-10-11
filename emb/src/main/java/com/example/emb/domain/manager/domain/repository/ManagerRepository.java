package com.example.emb.domain.manager.domain.repository;

import com.example.emb.domain.manager.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Optional<Manager> findById(String id);

    Boolean existsById(String id);

}
