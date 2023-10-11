package com.example.emb.domain.manager.domain.repository;

import com.example.emb.domain.manager.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Manager findById(String id);
}
