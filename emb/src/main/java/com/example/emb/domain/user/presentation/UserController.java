package com.example.emb.domain.user.presentation;

import com.example.emb.domain.user.presentation.dto.request.UserLoginRequest;
import com.example.emb.domain.user.service.UserLoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserLoginService userLoginService;

    @PostMapping("/login")
    public String login(@RequestBody @Valid UserLoginRequest request) {
        return userLoginService.execute(request);
    }
}
