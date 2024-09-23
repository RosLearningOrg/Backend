package com.ytrewq.rosLearning.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "course")
public class Course extends BaseEntity{
    private String title;
    private int lessons_number;
    private Set<Lesson> lessons;

    public Course(String title, int lessons_number, Set<Lesson> lessons) {
        this.title = title;
        this.lessons_number = lessons_number;
        this.lessons=lessons;
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

    public Set<Lesson> getLessons() {
        return lessons;
    }
    @OneToMany(mappedBy = "course" ,targetEntity =Lesson.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }


}
