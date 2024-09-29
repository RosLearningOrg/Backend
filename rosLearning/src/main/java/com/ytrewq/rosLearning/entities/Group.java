package com.ytrewq.rosLearning.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Group extends BaseEntity {
    private String profile;

    public Group(String profile) {
        this.profile = profile;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
