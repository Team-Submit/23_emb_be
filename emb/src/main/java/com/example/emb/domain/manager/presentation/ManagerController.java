package com.example.emb.domain.manager.presentation;

import com.example.emb.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.emb.domain.manager.presentation.dto.request.ManagerSignUpRequest;
import com.example.emb.domain.manager.service.AccountDeleteService;
import com.example.emb.domain.manager.service.AccountSignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/manager")
@RestController
public class ManagerController {

    private final AccountSignUpService userSignUpService;
    private final AccountDeleteService accountDeleteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/accounts")
    public UserTokenResponse userSignUp(@RequestBody @Valid ManagerSignUpRequest request) {
        return userSignUpService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/accounts/{user-id}")
    public void accountDelete(@PathVariable ("user-id") String userId) {
        accountDeleteService.execute(userId);
    }
}
