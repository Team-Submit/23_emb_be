package com.example.emb.domain.info.domain;

import com.example.emb.domain.user.service.UserUpdateService;
import com.example.emb.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
public class Terms extends BaseTimeEntity {

    private static final Logger log = LoggerFactory.getLogger(UserUpdateService.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termId;

    @Column(name = "number")
    private Long number;

    private  String name;

    private  String birthdate;

    private  String address;

    private  String firstTenure;

    private  String lastTenure;

    private  String occupation;

    private  String department;

    private  String userName;

    private  String userNumber;

    @Column(name = "issuing_department")
    private String issuingDepartment;

    @Column(name = "current_user_name")
    private String currentUserName;

    @Column(name = "current_user_number")
    private String currentUserNumber;

    public Long getTermId() {
        return termId;
    }

    public void termsUpdate(String userName, String userNumber, String department) {
        this.currentUserName = userName;
        this.currentUserNumber = userNumber;
        this.issuingDepartment = department;
    }
}
