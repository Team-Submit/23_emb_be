package com.example.emb.domain.user.presentation;

import com.example.emb.domain.user.presentation.dto.request.UserNameRequest;
import com.example.emb.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.emb.domain.user.presentation.dto.request.UpdatePasswordRequest;
import com.example.emb.domain.user.presentation.dto.request.UserUpdateRequest;
import com.example.emb.domain.user.presentation.dto.response.DepartmentResponse;
import com.example.emb.domain.user.presentation.dto.response.UserCheckResponse;
import com.example.emb.domain.user.presentation.dto.response.UserSignUpResponse;
import com.example.emb.domain.user.service.UserLogoutService;
import com.example.emb.domain.user.service.CheckUserNameExistsService;
import com.example.emb.domain.user.service.UserSignUpService;
import com.example.emb.domain.user.service.*;
import jakarta.validation.Valid;
import com.example.emb.domain.user.presentation.dto.response.GetUserInfoResponse;
import com.example.emb.domain.user.service.GetUserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final GetUserInfoService getUserInfoService;

    private final UserSignUpService userSignUpService;
    private final UserLogoutService userLogoutService;
    private final UserUpdateService userUpdateService;
    private final UpdatePasswordService updatePasswordService;
    private final DepartmentService departmentService;
    private final CheckUserNameExistsService checkUserNameExistsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping("/firstLogin")
    public UserSignUpResponse userSinUp(@RequestBody @Valid UserSignUpRequest request) {
        return userSignUpService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/logout")
    public void logout() {
        userLogoutService.execute();
    }

    @PatchMapping("/firstLoginCheck")
    public UserCheckResponse checkUserNameExist(@RequestBody @Valid UserNameRequest request) {
        return checkUserNameExistsService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/passwords")
    public void updatePassword(@RequestBody @Valid UpdatePasswordRequest request) {
        updatePasswordService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/managers")
    public void userUpdate(@RequestBody @Valid UserUpdateRequest request) {
        userUpdateService.execute(request);
    }

    @GetMapping("/informations")
    public GetUserInfoResponse getInfo() {
        return getUserInfoService.execute();
    }

    @GetMapping("/token/departmentLists")
    public DepartmentResponse getInfoLists() {
        return departmentService.execute();
    }

}