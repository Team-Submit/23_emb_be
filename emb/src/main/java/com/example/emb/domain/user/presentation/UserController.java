package com.example.emb.domain.user.presentation;

import com.example.emb.domain.user.facade.dto.UserSignUpRequest;
import com.example.emb.domain.user.service.UserLogoutService;
import com.example.emb.domain.user.service.UserSignUpService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping()
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UserLogoutService userLogoutService;

    @ApiOperation(value = "첫 로그인")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/firstLogin")

    public void userSinUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    public void logout() {
        userLogoutService.execute();
    }
}