package com.example.emb.domain.manager.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @NotBlank(message = "id는 Null, 공백을 허용하지 않습니다.")
    private  String id;

    @NotBlank(message = "password는 Null, 공백을 허용하지 않습니다.")
    @Length(min = 1, max = 30, message = "password는 30글자 이하여야 합니다.")
    private String password;
}
