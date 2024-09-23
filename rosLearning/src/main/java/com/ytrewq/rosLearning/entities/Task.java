package com.ytrewq.rosLearning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "task")
public class Task extends BaseEntity {
    private String data;
    private int time;
    private int result;

    private Lesson lesson;
    public Task(String data, int time, int result,Lesson lesson) {
        this.data = data;
        this.time = time;
        this.result = result;
        this.lesson=lesson;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Lesson getLesson() {
        return lesson;
    }
    @ManyToOne
    @JoinColumn(name = "lesson_id")

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
