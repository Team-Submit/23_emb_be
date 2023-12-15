package com.example.emb.domain.info.domain;

import com.example.emb.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
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

    private  String name;

    private  String birthdate;

    private  String address;

    private  String firstTenure;

    private  String lastTenure;

    private  String occupation;

    private  String department;

    private  String userName;

    private  String userNumber;

    private String issuingDepartment;
    private String currentUserName;
    private String currentUserNumber;

    public Long getTermId() {
        return termId;
    }
}
