package com.example.emb.domain.info.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class CreateInfoRequest {

    @NotBlank(message = "name는 Null, 공백을 허용하지 않습니다.")
    @Length(min = 1, max = 50, message = "name는 50글자 이하여야 합니다.")
    private String name;

    @NotBlank(message = "birthdate는 Null, 공백을 허용하지 않습니다.")
    private String birthdate;

    @NotBlank(message = "address는 Null, 공백을 허용하지 않습니다.")
    private String address;

    @NotBlank(message = "firstTenure는 Null, 공백을 허용하지 않습니다.")
    private String firstTenure;

    @NotBlank(message = "lastTenure는 Null, 공백을 허용하지 않습니다.")
    private String lastTenure;

    @NotBlank(message = "occupation는 Null, 공백을 허용하지 않습니다.")
    private String occupation;

    private String issuingDepartment;
    private String currentUserName;
    private String currentUserNumber;
}
