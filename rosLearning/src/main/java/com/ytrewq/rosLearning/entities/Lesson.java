package com.ytrewq.rosLearning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "lesson")
public class Lesson extends  BaseEntity{
    private String title;
    private String  lesson_theory;
    private int attempts_number;

    public Lesson(String title, String lesson_theory, int attempts_number) {
        this.title = title;
        this.lesson_theory = lesson_theory;
        this.attempts_number = attempts_number;
    }


    public int getAttempts_number() {
        return attempts_number;
    }

    public void setAttempts_number(int attempts_number) {
        this.attempts_number = attempts_number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTheory() {
        return lesson_theory;
    }

    public void setTheory(String lesson_theory) {
        this.lesson_theory = lesson_theory;
    }
}
