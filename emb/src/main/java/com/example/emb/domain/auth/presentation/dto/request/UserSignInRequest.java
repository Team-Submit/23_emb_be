package com.example.emb.domain.auth.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class UserSignInRequest {

    @NotBlank(message = "id는 Null, 공백을 허용하지 않습니다.")
    private  String id;

    @NotBlank(message = "password는 Null, 공백을 허용하지 않습니다.")
    @Length(min = 8, max = 30, message = "password는 30글자 이하여야 합니다.")
    private String password;

}
