package com.ytrewq.rosLearning.Entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    private String title;
    private LocalDateTime dateOfCreation;
    private String description;
    private String lessonTitle;
    private String courseTitle;
    private Emulation emulation;

    public Task(String title, LocalDateTime dateOfCreation, String description, String lessonTitle, String courseTitle, Emulation emulation) {
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
        this.lessonTitle = lessonTitle;
        this.courseTitle = courseTitle;
        this.emulation = emulation;
    }

    protected Task() {
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "dateOfCreation")
    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "lessonTitle")
    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    @Column(name = "courseTitle")
    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emulation_id", referencedColumnName = "id", nullable = false)
    public Emulation getEmulation() {
        return emulation;
    }

    public void setEmulation(Emulation emulation) {
        this.emulation = emulation;
    }
}
