package com.example.emb.domain.user.service;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DepartmentService {

    private final UserRepository userRepository;

    public List<String> execute() {

        List<String> uniqueDepartments = userRepository.findAll()
                .stream()
                .map(User::getDepartment)
                .filter(department -> department != null && !department.isEmpty())
                .distinct()
                .collect(Collectors.toList());

        return uniqueDepartments;
    }
}
