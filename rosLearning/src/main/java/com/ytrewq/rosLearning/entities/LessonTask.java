package com.ytrewq.rosLearning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "lesson_tasks")
public class LessonTask extends BaseEntity {
    private Lesson lesson;
    private Task task;
    private String addition_date;

    public LessonTask(Lesson lesson, Task task, String addition_date) {
        this.lesson = lesson;
        this.task = task;
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
    @JoinColumn(name = "task_id")
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}


