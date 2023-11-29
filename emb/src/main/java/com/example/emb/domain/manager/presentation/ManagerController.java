package com.example.emb.domain.manager.presentation;

import com.example.emb.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.emb.domain.manager.presentation.dto.request.ManagerSignUpRequest;
import com.example.emb.domain.manager.service.AccountDeleteService;
import com.example.emb.domain.manager.service.AccountSignUpService;
import com.example.emb.domain.manager.service.GetUserListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/manager")
@RestController
public class ManagerController {

    private final AccountSignUpService userSignUpService;
    private final AccountDeleteService accountDeleteService;
    private final GetUserListService getUserListService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/accounts")
    public UserTokenResponse userSignUp(@RequestBody @Valid ManagerSignUpRequest request) {
        return userSignUpService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/accounts")
    public void accountDelete() {
        accountDeleteService.execute();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/lists")
    public List<Map<String, String>> getUserList() {
        return getUserListService.getUserList();
    }
}
