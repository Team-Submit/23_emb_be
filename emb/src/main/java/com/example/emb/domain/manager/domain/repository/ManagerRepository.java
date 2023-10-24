package com.example.emb.domain.manager.domain.repository;

import com.example.emb.domain.manager.domain.Manager;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ManagerRepository extends CrudRepository<Manager, Long> {

    Optional<Manager> findById(String id);

}
