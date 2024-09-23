package com.ytrewq.rosLearning.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    private String fio;
    private Role role;
    private Group group;
    private int course_result;

    public User(String fio, Role role, Group group, int course_result) {
        this.fio = fio;
        this.role = role;
        this.group = group;
        this.course_result = course_result;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Role getRole() {
        return role;
    }
    @ManyToOne()
    @JoinColumn(name = "role_id")

    public void setRole(Role role) {
        this.role = role;
    }


    public Group getGroup() {
        return group;
    }
    @ManyToOne()
    @JoinColumn(name = "group_id")

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getCourse_result() {
        return course_result;
    }

    public void setCourse_result(int course_result) {
        this.course_result = course_result;
    }
}
