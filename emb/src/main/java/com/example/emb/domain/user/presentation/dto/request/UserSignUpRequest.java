package com.example.emb.domain.user.presentation.dto.request;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @ApiModelProperty(value = "name", example = "홍길동")
    @NotNull(message = "필드는 비어 있을 수 없습니다.")
    @Length(max = 50, message = "필드는 {max} 글자 이하여야 합니다.")
    private String userName;

    @ApiModelProperty(value = "password", example = "aced1234")
    @NotNull(message = "필드는 비어 있을 수 없습니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).*$", message = "비밀번호는 영어, 숫자, 특수문자를 포함해야 합니다.")
    @Length(min = 8, max = 30, message = "필드는 {min} 글자 이상 {max} 글자 이하여야 합니다.")
    private String newPassword;

    @ApiModelProperty(value = "phoneNumber", example = "01011112222")
    @NotNull(message = "필드는 비어 있을 수 없습니다.")
    @Length(max = 255, message = "필드는 {max} 글자 이하여야 합니다.")
    private String userNumber;

    @ApiModelProperty(value = "department", example = "행복안전부")
    @NotNull(message = "필드는 비어 있을 수 없습니다.")
    @Length(min = 2, max = 255)
    private String department;

}