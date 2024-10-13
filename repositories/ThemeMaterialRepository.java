package com.ytrewq.rosLearning.repositories;

import com.ytrewq.rosLearning.Entities.ThemeMaterial;

import java.util.Set;

public interface ThemeMaterialRepository {

    Set<ThemeMaterial> getAllThemeMaterials(int course_id,int theme_id);
}
