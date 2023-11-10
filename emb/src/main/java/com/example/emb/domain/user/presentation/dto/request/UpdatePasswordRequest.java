package com.example.emb.domain.user.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class UpdatePasswordRequest {

    @NotNull(message = "필드는 비어 있을 수 없습니다.")
    @Length(min = 8, max = 30, message = "필드는 {min} 글자 이상 {max} 글자 이하여야 합니다.")
    private String password;

    @NotNull(message = "필드는 비어 있을 수 없습니다.")
    @Length(min = 8, max = 30, message = "필드는 {min} 글자 이상 {max} 글자 이하여야 합니다.")
    private String newPassword;

}
