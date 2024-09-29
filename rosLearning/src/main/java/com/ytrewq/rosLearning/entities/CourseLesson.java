package com.ytrewq.rosLearning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "course_lessons")
public class CourseLesson extends BaseEntity {
    private Lesson lesson;
    private Course course;
    private String addition_date;

    public CourseLesson(Lesson lesson, Course course, String addition_date) {
        this.lesson = lesson;
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
    @JoinColumn(name = "lesson_id")
    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
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


