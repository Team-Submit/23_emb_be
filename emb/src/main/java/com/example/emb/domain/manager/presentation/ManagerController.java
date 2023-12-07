package com.example.emb.domain.manager.presentation;

import com.example.emb.domain.manager.presentation.dto.request.ManagerSignUpRequest;
import com.example.emb.domain.manager.presentation.dto.response.UserGetResponse;
import com.example.emb.domain.manager.service.*;
import com.example.emb.domain.user.presentation.dto.request.UserUpdateRequest;
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
    private final MService mService;
    private final AccountGetService accountGetService;
    private final UManagerUpdateService uManagerUpdateService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/accounts")
    public void userSignUp(@RequestBody @Valid ManagerSignUpRequest request) {
        userSignUpService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/a")
    public void SignUp(@RequestBody @Valid ManagerSignUpRequest request) {
        mService.execute(request);
    }

    @DeleteMapping("/accounts/{user-id}")
    public void accountDelete(@PathVariable("user-id") Long user_id) {
        accountDeleteService.execute(user_id);
    }

    @PatchMapping("/accounts/{user-id}")
    public void userUpdate(@PathVariable("user-id") Long number, @RequestBody @Valid UserUpdateRequest request) {
        uManagerUpdateService.execute(number, request);
    }

    @GetMapping("/accounts/{user-id}")
    public UserGetResponse accountGet(@PathVariable("user-id") Long number) {
        return accountGetService.execute(number);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/lists")
    public List<Map<String, String>> getUserList() {
        return getUserListService.execute();
    }
}
