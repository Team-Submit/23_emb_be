package com.example.emb.domain.info.domain;

import com.example.emb.domain.user.domain.User;
import com.example.emb.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
public class Terms extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    @NotNull
    private  String name;

    @NotNull
    private  String birthdate;

    @NotNull
    private  String address;

    @NotNull
    private  String firstTenure;

    @NotNull
    private  String lastTenure;

    @NotNull
    private  String occupation;

    @NotNull
    private  String department;

    @NotNull
    private  String userName;

    @NotNull
    private  String userNumber;
}
