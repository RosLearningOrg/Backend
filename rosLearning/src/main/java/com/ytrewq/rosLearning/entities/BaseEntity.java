package com.ytrewq.rosLearning.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",insertable=false, updatable=false)

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
