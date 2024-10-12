package com.ytrewq.rosLearning.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {
    private String title;
    private LocalDateTime dateOfCreation;
    private String description;
    private Theme[] themes;

    public Course(String title, LocalDateTime dateOfCreation, String description, Theme[] themes) {
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
        this.themes = themes;
    }

    protected Course() {
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

    @OneToMany
    @JoinColumn(name = "course_id")
    public Theme[] getThemes() {
        return themes;
    }

    public void setThemes(Theme[] themes) {
        this.themes = themes;
    }
}
