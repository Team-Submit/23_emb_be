package com.example.emb.domain.manager.service;
import com.example.emb.domain.manager.facade.ManagerFacade;
import com.example.emb.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetUserListService {
    private final UserRepository userRepository;
    private final ManagerFacade managerFacade;

    public List<Map<String, String>> execute() {

        managerFacade.getCurrentManager();

        return userRepository.findAll().stream()
                .map(user -> {
                    Map<String, String> userMap = new HashMap<>();
                    userMap.put("id", user.getUserId());
                    userMap.put("department", user.getDepartment());
                    userMap.put("userName", user.getUserName());
                    userMap.put("userNumber", user.getUserNumber());
                    userMap.put("user_id", String.valueOf(user.getNumber()));
                    return userMap;
                })
                .collect(Collectors.toList());
    }
}

