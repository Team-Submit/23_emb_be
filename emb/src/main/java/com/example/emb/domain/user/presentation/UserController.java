package com.example.emb.domain.user.presentation;

import com.example.emb.domain.user.domain.User;
import com.example.emb.domain.user.presentation.dto.response.GetUserInfoResponse;
import com.example.emb.domain.user.service.GetUserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final GetUserInfoService getUserInfoService;

    @GetMapping("/informations/{user-id}")
    public GetUserInfoResponse getInfo(@PathVariable("user-id") String userId) {
        return getUserInfoService.excute(userId);
    }

}
