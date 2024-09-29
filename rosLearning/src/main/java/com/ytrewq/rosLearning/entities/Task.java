package com.ytrewq.rosLearning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    private String name;

    private String description;

    private String emulation;

    public Task(String name, String description, String emulation) {
        this.name = name;
        this.description = description;
        this.emulation = emulation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmulation() {
        return emulation;
    }

    public void setEmulation(String emulation) {
        this.emulation = emulation;
    }
}
