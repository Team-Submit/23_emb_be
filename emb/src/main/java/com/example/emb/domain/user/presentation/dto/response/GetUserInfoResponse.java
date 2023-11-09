package com.example.emb.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetUserInfoResponse {

    private String department;

    private String userName;

    private String userNumber;
}
