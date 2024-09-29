package com.ytrewq.rosLearning.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {
    private String name;
    private int description;
    private String creation_date;

    public Course(String name, int description, String creation_date) {

        this.name = name;
        this.description = description;
        this.creation_date = creation_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

}
