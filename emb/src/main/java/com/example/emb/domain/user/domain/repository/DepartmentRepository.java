package com.example.emb.domain.user.domain.repository;

import com.example.emb.domain.user.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findAllByDepartment();
}
