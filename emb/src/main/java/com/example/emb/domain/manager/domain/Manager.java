package com.example.emb.domain.manager.domain;

import com.example.emb.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "managers")
@Builder
@AllArgsConstructor
public class Manager extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    @NotNull
    private  String id;

    @NotNull
    private String password;

    @Builder
    public Manager(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
