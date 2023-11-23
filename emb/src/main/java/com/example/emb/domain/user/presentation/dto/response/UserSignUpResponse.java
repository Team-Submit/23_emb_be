package com.example.emb.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserSignUpResponse {

    private String userName;

    private String newPassword;

    private String userNumber;

    private String department;
}
