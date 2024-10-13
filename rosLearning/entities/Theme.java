package com.ytrewq.rosLearning.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "themes")
public class Theme extends BaseEntity {
    private String title;
    private LocalDateTime dateOfCreation;
    private String description;
    private Task[] tasks;
    private ThemeMaterial[] materials;

    public Theme(String title, LocalDateTime dateOfCreation, String description, Task[] tasks, ThemeMaterial[] materials) {
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
        this.tasks = tasks;
        this.materials = materials;
    }

    protected Theme() {
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
    @JoinColumn(name = "theme_id")
    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    @OneToMany
    @JoinColumn(name = "theme_id")
    public ThemeMaterial[] getMaterials() {
        return materials;
    }

    public void setMaterials(ThemeMaterial[] materials) {
        this.materials = materials;
    }
}
