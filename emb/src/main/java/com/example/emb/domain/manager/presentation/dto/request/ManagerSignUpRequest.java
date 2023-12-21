package com.example.emb.domain.manager.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class ManagerSignUpRequest {

    @NotBlank(message = "id는 Null, 공백을 허용하지 않습니다.")
    private  String id;

    @NotBlank(message = "password는 Null, 공백을 허용하지 않습니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).*$", message = "비밀번호는 영어, 숫자, 특수문자를 포함해야 합니다.")
    @Length(min = 8, max = 255, message = "password는 30글자 이하여야 합니다.")
    private String password;
}
