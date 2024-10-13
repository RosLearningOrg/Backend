package com.ytrewq.rosLearning.DTOs;


import com.ytrewq.rosLearning.Entities.Theme;

import java.time.LocalDateTime;
import java.util.List;

public class CourseDto {
    private String title;
    private LocalDateTime dateOfCreation;
    private String description;

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

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    private List<Theme> themes;


}
