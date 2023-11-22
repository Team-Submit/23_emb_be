package com.example.emb.domain.info.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GetInfoDetailsResponse {
    private String name;
    private String birthdate;
    private String address;
    private String firstTenure;
    private String lastTenure;
    private String occupation;
    private String department;
    private String userName;
    private String userNumber;

}
