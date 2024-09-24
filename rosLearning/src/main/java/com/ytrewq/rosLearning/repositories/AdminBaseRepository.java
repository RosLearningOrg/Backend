package com.ytrewq.rosLearning.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AdminBaseRepository<Entity,T> {
    private final Class<Entity> entityClass;

    public AdminBaseRepository(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(Entity entity) {
        entityManager.persist(entity);
    }

    @Transactional
    public Entity update(Entity entity) {
        return entityManager.merge(entity);
    }
}
