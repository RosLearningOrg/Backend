package com.ytrewq.rosLearning.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
