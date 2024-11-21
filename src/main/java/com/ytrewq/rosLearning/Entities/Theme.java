package com.ytrewq.rosLearning.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "themes")
public class Theme extends BaseEntity {
    private String title;
    private LocalDateTime dateOfCreation;
    private String description;
    private String tasksIdsStr = "";
    private String materialsIdsStr = "";

    public Theme(String title, LocalDateTime dateOfCreation, String description, String tasksIdsStr, String materialsIdsStr) {
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
        this.tasksIdsStr = tasksIdsStr;
        this.materialsIdsStr = materialsIdsStr;
    }

    public Theme() {
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

    @Column(name = "tasks_ids", length = 511)
    public String getTasksIdsStr() {
        return tasksIdsStr;
    }

    public void setTasksIdsStr(String tasksIdsStr) {
        this.tasksIdsStr = tasksIdsStr;
    }

    @Column(name = "materials_ids", length = 511)
    public String getMaterialsIdsStr() {
        return materialsIdsStr;
    }

    public void setMaterialsIdsStr(String materialsIdsStr) {
        this.materialsIdsStr = materialsIdsStr;
    }
}
