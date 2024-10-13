package com.ytrewq.rosLearning.repositories.Impl;

import com.ytrewq.rosLearning.entities.Task;
import com.ytrewq.rosLearning.entities.ThemeMaterial;
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
    public Set<ThemeMaterial> getAllThemeMaterials(int theme_id) {
        String jpql = "Select tm.materials FROM Theme tm WHERE tm.id = :theme_id";
        return new HashSet<>(entityManager.createQuery(jpql, ThemeMaterial.class)
                .setParameter("theme_id", theme_id)
                .getResultList());
    }


}
