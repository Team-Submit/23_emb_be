package com.example.emb.domain.user.domain;

import com.example.emb.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @NotNull(message = "필드는 비어 있을 수 없습니다.")
    @Length(max = 255, message = "userId필드는 {max} 글자 이하여야 합니다.")
    private  String userId;

    @NotNull(message = "필드는 비어 있을 수 없습니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).*$", message = "비밀번호는 영어, 숫자, 특수문자를 포함해야 합니다.")
    @Length(min = 8, max = 255, message = "userPassword필드는 {min} 글자 이상 {max} 글자 이하여야 합니다.")
    private String userPassword;

    @Length(max = 255, message = "department필드는 {max} 글자 이하여야 합니다.")
    private String department;

    @Length(max = 50, message = "userName필드는 {max} 글자 이하여야 합니다.")
    private String userName;

    @Length(max = 20, message = "userNumber필드는 {max} 글자 이하여야 합니다.")
    private String userNumber;


    @Builder
    public User(String userId, String userPassword, String department, String userName, String userNumber) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.department = department;
        this.userName = userName;
        this.userNumber = userNumber;
    }

    public void Userupdate(String userName, String userNumber, String department) {
        this.userName = userName;
        this.userNumber = userNumber;
        this.department = department;
    }

    public void UserSignUp(String userName, String userPassword, String userNumber, String department) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userNumber = userNumber;
        this.department = department;
    }
    
    public void setPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
