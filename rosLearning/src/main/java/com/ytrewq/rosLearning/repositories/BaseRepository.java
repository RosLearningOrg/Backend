package com.ytrewq.rosLearning.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class BaseRepository<Entity,T> {
    private final Class<Entity> entityClass;

    public BaseRepository(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public Entity findById(Class<Entity> entityClass, Integer id) {
        return entityManager.find(entityClass, id);
    }
    @Transactional
    public List<Entity> findAll(Class<Entity> entityClass) {
        String jpqlQuery = "SELECT e FROM %s e".formatted(entityClass);
        TypedQuery<Entity>  result= entityManager.createQuery(jpqlQuery,entityClass);
        return result.getResultList();

    }
}
