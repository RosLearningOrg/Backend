package com.ytrewq.rosLearning.Repositories;


import com.ytrewq.rosLearning.Entities.ThemeMaterial;

import java.util.Set;

public interface ThemeMaterialRepository {

    Set<ThemeMaterial> getAllThemeMaterials(int them_id);

}
