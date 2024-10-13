package com.ytrewq.rosLearning.dto;

import com.ytrewq.rosLearning.Entities.Theme;

import java.util.Date;
import java.util.List;

public class CourseDto {
    private String title;
    private Date dateOfCreation;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
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
