package com.example.emb.domain.user.presentation;

import com.example.emb.domain.user.domain.repository.UserRepository;
import com.example.emb.domain.user.facade.dto.UserSignUpRequest;
import com.example.emb.domain.user.service.UserLogoutService;
import com.example.emb.domain.user.service.CheckUserNameExistsService;
import com.example.emb.domain.user.service.UserSignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UserLogoutService userLogoutService;
    private UserRepository userRepository;
    private CheckUserNameExistsService checkUserNameExistsService;

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

    @PostMapping("/firstLoginCheck")
    public void checkUserNameExist(@RequestBody @Valid String userName) {
        checkUserNameExistsService.execute(userName);
    }
}