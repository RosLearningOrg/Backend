package com.ytrewq.rosLearning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "user_courses")
public class UserCourse extends BaseEntity {
    private User user;
    private Course course;
    private String addition_date;

    public UserCourse(User user, Course course, String addition_date) {
        this.user = user;
        this.course = course;
        this.addition_date = addition_date;
    }

    public String getAddition_date() {
        return addition_date;
    }

    public void setAddition_date(String addition_date) {
        this.addition_date = addition_date;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}


