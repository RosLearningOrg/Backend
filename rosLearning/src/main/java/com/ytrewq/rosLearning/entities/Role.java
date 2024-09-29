package com.ytrewq.rosLearning.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {
    private String role;

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
