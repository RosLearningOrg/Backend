package com.ytrewq.rosLearning.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @EmbeddedId
    private UserId  userId;
    private String fio;
    private String position;
    private String registration_date;

    public User(String fio,String position, String registration_date,UserId  userId
) {
        this.fio = fio;
        this.userId=userId;
        this.position = position;
        this.registration_date = registration_date;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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
