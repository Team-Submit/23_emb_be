package com.example.emb.domain.user.service;

import com.example.emb.domain.user.domain.Department;
import com.example.emb.domain.user.domain.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> excute() {

        List<Department> departments = departmentRepository.findAll();
        return departments;
    }
}
