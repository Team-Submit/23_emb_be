package com.example.emb.domain.user.domain;

import com.example.emb.global.entity.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @NotNull
    @Length(max = 255)
    private  String user_id;

    @NotNull
    @Length(max = 30)
    private String user_password;

    @NotNull
    @Length(max = 255)
    private String department;

    @NotNull
    @Length(max = 50)
    private String user_name;

    @NotNull
    @Length(max = 20)
    private String user_number;
}
