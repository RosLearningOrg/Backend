package com.ytrewq.rosLearning.Forms;

import com.ytrewq.rosLearning.Entities.Emulation;
import com.ytrewq.rosLearning.Entities.Task;
import com.ytrewq.rosLearning.Entities.ThemeMaterial;

import java.time.LocalDateTime;
import java.util.List;

public class TaskForm {
    private String title;
    private LocalDateTime dateOfCreation;
    private String description;
    private String lessonTitle;
    private String courseTitle;
    private Emulation emulation;

    public TaskForm(String title, LocalDateTime dateOfCreation, String description, String lessonTitle, String courseTitle, Emulation emulation) {
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
        this.lessonTitle = lessonTitle;
        this.courseTitle = courseTitle;
        this.emulation = emulation;
    }

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

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Emulation getEmulation() {
        return emulation;
    }

    public void setEmulation(Emulation emulation) {
        this.emulation = emulation;
    }
//    public List<Task> getTasks() {
//        return tasks;
//    }
//
//    public void setTasks(List<Task> tasks) {
//        this.tasks = tasks;
//    }
//
//    public List<ThemeMaterial> getMaterials() {
//        return materials;
//    }
//
//    public void setMaterials(List<ThemeMaterial> materials) {
//        this.materials = materials;
//    }
}
