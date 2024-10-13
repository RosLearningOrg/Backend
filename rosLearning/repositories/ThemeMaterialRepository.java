package com.ytrewq.rosLearning.repositories;

import com.ytrewq.rosLearning.entities.Task;
import com.ytrewq.rosLearning.entities.Theme;
import com.ytrewq.rosLearning.entities.ThemeMaterial;

import java.util.List;
import java.util.Set;

public interface ThemeMaterialRepository {

    Set<ThemeMaterial> getAllThemeMaterials(int them_id);
}
