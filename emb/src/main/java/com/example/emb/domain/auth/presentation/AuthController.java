package com.example.emb.domain.auth.presentation;

import com.example.emb.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.emb.domain.auth.presentation.dto.response.UserTokenRefreshResponse;
import com.example.emb.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.emb.domain.auth.service.CheckUserIdExistsService;
import com.example.emb.domain.auth.service.UserSignInService;
import com.example.emb.domain.auth.service.UserTokenRefreshService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class AuthController {

    private final UserSignInService userSignInService;
    private final UserTokenRefreshService userTokenRefreshService;
    private final CheckUserIdExistsService checkUserIdExistsService;

    @PostMapping("/login")
    public UserTokenResponse userSignIn(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.execute(request);
    }

    @PatchMapping("/reissue/access_token")
    public UserTokenRefreshResponse userTokenRefresh(@RequestHeader("Refresh-Token") String refreshToken) {
        return userTokenRefreshService.execute(refreshToken);
    }

    @RequestMapping(value = "/userId", method = RequestMethod.HEAD)
    public void checkEmailExist(@NotBlank @RequestParam(name = "userId") String userId) {
        checkUserIdExistsService.execute(userId);
    }
}
