package com.ytrewq.rosLearning.dto;

import com.ytrewq.rosLearning.entities.Task;
import com.ytrewq.rosLearning.entities.ThemeMaterial;

import java.time.LocalDateTime;

public class TaskDto {
    private String title;
    private LocalDateTime dateOfCreation;
    private String description;
    private Task[] tasks;
    private ThemeMaterial[] materials;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public ThemeMaterial[] getMaterials() {
        return materials;
    }

    public void setMaterials(ThemeMaterial[] materials) {
        this.materials = materials;
    }
}
