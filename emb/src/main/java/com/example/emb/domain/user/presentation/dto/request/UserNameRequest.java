package com.example.emb.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class UserNameRequest {

    @Length(max = 255, message = "필드는 {max} 글자 이하여야 합니다.")
    private String userid;
}
