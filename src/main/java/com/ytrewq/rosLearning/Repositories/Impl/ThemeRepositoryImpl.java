package com.ytrewq.rosLearning.Repositories.Impl;


import com.ytrewq.rosLearning.Entities.Theme;
import com.ytrewq.rosLearning.Repositories.BaseRepository;
import com.ytrewq.rosLearning.Repositories.ThemeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ThemeRepositoryImpl extends BaseRepository<Theme, Integer> implements ThemeRepository {
    @PersistenceContext
    EntityManager entityManager;

    public ThemeRepositoryImpl() {
        super(Theme.class);
    }


    @Override
    public Set<Theme> getAllCourseThemes(int course_id) {
        String jpql = "Select cs.themes FROM Course cs WHERE cs.id = :course_id";
        return new HashSet<>(entityManager.createQuery(jpql, Theme.class)
                .setParameter("course_id", course_id)
                .getResultList());
    }

}
