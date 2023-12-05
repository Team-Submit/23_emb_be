package com.example.emb.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCheckResponse {

    private Boolean firstLogin;

}
