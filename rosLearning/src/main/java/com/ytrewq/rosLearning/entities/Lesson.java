package com.ytrewq.rosLearning.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "lessons")
public class Lesson extends  BaseEntity{
    private String name;

    private String  lesson_theory;

    private String creation_date;

    public Lesson(String name, String lesson_theory, String creation_date) {
        this.name = name;
        this.lesson_theory = lesson_theory;
        this.creation_date = creation_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLesson_theory() {
        return lesson_theory;
    }

    public void setLesson_theory(String lesson_theory) {
        this.lesson_theory = lesson_theory;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

}
