package com.ytrewq.rosLearning.Entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    private String title;
    private LocalDateTime dateOfCreation;
    private String description;
    private Emulation emulation;

    public Task(String title, LocalDateTime dateOfCreation, String description, Emulation emulation) {
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.description = description;
        this.emulation = emulation;
    }

    public Task() {
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emulation_id", referencedColumnName = "id")
    public Emulation getEmulation() {
        return emulation;
    }

    public void setEmulation(Emulation emulation) {
        this.emulation = emulation;
    }
}
