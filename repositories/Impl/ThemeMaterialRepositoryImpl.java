package com.ytrewq.rosLearning.repositories.Impl;

import com.ytrewq.rosLearning.Entities.ThemeMaterial;
import com.ytrewq.rosLearning.repositories.BaseRepository;
import com.ytrewq.rosLearning.repositories.ThemeMaterialRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ThemeMaterialRepositoryImpl extends BaseRepository<ThemeMaterial,Integer> implements ThemeMaterialRepository {
    @Autowired
    EntityManager entityManager;

    public ThemeMaterialRepositoryImpl() {
        super(ThemeMaterial.class);
    }

    @Override
    public Set<ThemeMaterial> getAllThemeMaterials(int course_id,int theme_id) {
        String jpql = "SELECT tm FROM Course c JOIN c.themes th JOIN th.themes tm WHERE c.id = :course_id AND th.id = theme_id";
        return new HashSet<>(entityManager.createQuery(jpql, ThemeMaterial.class)
                .setParameter("course_id", course_id)
                .setParameter("theme_id",theme_id)
                .getResultList());
    }



}
