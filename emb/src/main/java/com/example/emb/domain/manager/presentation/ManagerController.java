package com.example.emb.domain.manager.presentation;

import com.example.emb.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.emb.domain.manager.presentation.dto.request.UserSignUpRequest;
import com.example.emb.domain.manager.service.UserSignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/manager")
@RestController
public class ManagerController {

    private final UserSignUpService userSignUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/accounts")
    public UserTokenResponse userSignUp(@RequestBody @Valid UserSignUpRequest request) {
        return userSignUpService.execute(request);
    }
}
