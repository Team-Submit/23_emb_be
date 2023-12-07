package com.example.emb.domain.user.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class UserUpdateRequest {

    @NotBlank(message = "userName는 Null, 공백을 허용하지 않습니다.")
    @Length(max = 50, message = "필드는 {max} 글자 이하여야 합니다.")
    private String userName;

    @NotBlank(message = "userNumber는 Null, 공백을 허용하지 않습니다.")
    @Length(max = 20, message = "필드는 {max} 글자 이하여야 합니다.")
    private String userNumber;

    @NotBlank(message = "department는 Null, 공백을 허용하지 않습니다.")
    @Length(max = 255, message = "필드는 {max} 글자 이하여야 합니다.")
    private String department;
}