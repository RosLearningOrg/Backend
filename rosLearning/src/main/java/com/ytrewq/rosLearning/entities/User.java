package com.ytrewq.rosLearning.entities;

import jakarta.persistence.*;

@Entity
@IdClass(UserId.class)
@Table(name = "users")
public class User extends BaseEntity {
    private String fio;
    private String email;
    private Role role;
    private String position;
    private String registration_date;

    public User(String fio, Role role, String position, String registration_date, String email) {
        this.fio = fio;
        this.email=email;
        this.role = role;
        this.position = position;
        this.registration_date = registration_date;
    }
    @Id
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
    @OneToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }
}
