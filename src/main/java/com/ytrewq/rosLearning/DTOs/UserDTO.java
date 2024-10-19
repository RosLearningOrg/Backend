package com.ytrewq.rosLearning.DTOs;

import java.time.LocalDateTime;

public class UserDTO {
    public String username;
    public String email;
    public String name;
    public String role;
    public LocalDateTime dateOfRegistration;
    public Boolean admin;

    public UserDTO(String username, String email, String name, String role, LocalDateTime dateOfRegistration, Boolean admin) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.role = role;
        this.dateOfRegistration = dateOfRegistration;
        this.admin = admin;
    }

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDateTime dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
