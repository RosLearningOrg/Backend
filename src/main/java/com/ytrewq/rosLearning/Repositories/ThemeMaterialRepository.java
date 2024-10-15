package com.ytrewq.rosLearning.Repositories;


import com.ytrewq.rosLearning.Entities.ThemeMaterial;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ThemeMaterialRepository extends CrudRepository<ThemeMaterial, Integer> {

    Set<ThemeMaterial> getAllThemeMaterials(int them_id);
    <S extends ThemeMaterial> S save (S entity);

}
