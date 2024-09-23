package com.ytrewq.rosLearning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course extends BaseEntity{
    private String title;
    private int lessons_number;

    public Course(String title, int lessons_number) {
        this.title = title;
        this.lessons_number = lessons_number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLessons_number() {
        return lessons_number;
    }

    public void setLessons_number(int lessons_number) {
        this.lessons_number = lessons_number;
    }
}
