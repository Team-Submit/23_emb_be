package com.example.emb.domain.user.presentation;

import com.example.emb.domain.user.facade.dto.UserSignUpRequest;
import com.example.emb.domain.user.service.UserSignUpService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class UserController {

    private final UserSignUpService userSignUpService;


    @ApiOperation(value = "첫 로그인")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/firstLogin")
    public void userSignUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.execute(request);
    }
}