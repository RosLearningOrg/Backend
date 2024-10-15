package com.ytrewq.rosLearning.Forms;

import com.ytrewq.rosLearning.Entities.Theme;

import java.time.LocalDateTime;

public class ThemeForm {
    private String title;
    private LocalDateTime dateOfCreation;
    private String description;

    public ThemeForm(String title, LocalDateTime dateOfCreation, String description) {
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
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
}
