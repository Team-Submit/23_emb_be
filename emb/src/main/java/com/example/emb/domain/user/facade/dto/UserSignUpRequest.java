package com.example.emb.domain.user.facade.dto;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @ApiModelProperty(value = "name", example = "홍길동")
    @NotNull
    @Length(max = 50)
    private String userName;

    @ApiModelProperty(value = "password", example = "aced1234")
    @NotNull
    @Length(max = 30)
    private String newPassword;

    @ApiModelProperty(value = "phoneNumber", example = "01011112222")
    @NotNull
    @Length(max = 20)
    private String userNumber;

    @ApiModelProperty(value = "department", example = "행복안전부")
    @NotNull
    @Length(max = 255)
    private String department;

}