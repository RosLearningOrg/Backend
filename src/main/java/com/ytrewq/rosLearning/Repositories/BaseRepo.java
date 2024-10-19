package com.ytrewq.rosLearning.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface BaseRepo<EntityClass> extends CrudRepository<EntityClass, Integer> {
    <S extends EntityClass> S save(S entity);

    Set<EntityClass> findAll();

    Optional<EntityClass> findById(Integer entity_id);
}
