package com.ytrewq.rosLearning.Entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {
    private String username;
    private String password;
    private String email;
    private String name;
    private String role;
    private LocalDateTime dateOfRegistration;
    private Boolean admin;
    private Result result;
    private Course[] courses;

    public User(String email, String name, String role, LocalDateTime dateOfRegistration, Boolean admin, Result result, Course[] courses, String username, String password) {
        this.email = email;
        this.name = name;
        this.role = role;
        this.dateOfRegistration = dateOfRegistration;
        this.admin = admin;
        this.result = result;
        this.courses = courses;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "register_date")
    public LocalDateTime getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDateTime dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "is_admin")
    public Boolean isAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "result_id", referencedColumnName = "id")
    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @OneToMany
    @JoinColumn(name = "user_id")
    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.isAdmin()) {
            return Set.of(new SimpleGrantedAuthority("admin"));
        } else {
            return Set.of(new SimpleGrantedAuthority("user"));
        }
    }

    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isEnabled() {
        return true;
    }
}
