package com.example.emb.domain.manager.presentation.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserGetResponse {

    private String userName;
    private String userNumber;
    private String department;

}
