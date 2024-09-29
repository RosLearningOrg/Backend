package com.ytrewq.rosLearning.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class UserId implements Serializable {
    private String email;
    private Long id;

    public UserId(String email, Long id) {
        this.email = email;
        this.id = id;
    }
    @Id
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserId that = (UserId) obj;
        return Objects.equals(email, that.email) &&
                Objects.equals(id, that.id);
    }


}
