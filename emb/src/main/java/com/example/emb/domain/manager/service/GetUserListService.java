package com.example.emb.domain.manager.service;
import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetUserListService {
    private final UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAll().stream()
                .map(user -> new User(
                        user.getUserName(),
                        user.getDepartment(),
                        user.getUserNumber()
                )).collect(Collectors.toList());
    }
}

