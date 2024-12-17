package com.ytrewq.rosLearning.Forms;

import com.ytrewq.rosLearning.Entities.Theme;

import java.time.LocalDateTime;
import java.util.List;

public class CourseForm {
    private String title;
    private String description;

    public CourseForm(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
