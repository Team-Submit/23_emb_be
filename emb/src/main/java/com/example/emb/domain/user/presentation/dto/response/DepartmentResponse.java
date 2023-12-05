package com.example.emb.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class DepartmentResponse {

    private List<String> department;

    public List<String> getDepartments() {
        return department;
    }

    public void setDepartments(List<String> department) {
        this.department = department;
    }
}
