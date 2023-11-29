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
public class Department extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @NotNull(message = "필드는 비어 있을 수 없습니다.")
    @Length(max = 255, message = "필드는 {max} 글자 이하여야 합니다.")
    private String department;

    @Builder
    public Department(String department) {
        this.department = department;
    }
}
