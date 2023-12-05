package com.example.emb.domain.user.service;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.domain.user.presentation.dto.response.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DepartmentService {

    private final UserRepository userRepository;

    public DepartmentResponse execute() {

        List<String> uniqueDepartments = userRepository.findAll()
                .stream()
                .map(User::getDepartment)
                .filter(department -> department != null && !department.isEmpty())
                .distinct()
                .collect(Collectors.toList());

        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setDepartments(uniqueDepartments);

        return departmentResponse;
    }
}
