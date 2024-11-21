package com.ytrewq.rosLearning.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {
    private String title;
    private LocalDateTime dateOfCreation;
    private String description;
    private String themesIdsStr = "";

    public Course(String title, LocalDateTime dateOfCreation, String description, String themesIdsStr) {
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
        this.themesIdsStr = themesIdsStr;
    }

    public Course() {
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

    @Column(name = "description", length = 1023)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "themes_ids", length = 511)
    public String getThemesIdsStr() {
        return themesIdsStr;
    }

    public void setThemesIdsStr(String themesIdsStr) {
        this.themesIdsStr = themesIdsStr;
    }
}
