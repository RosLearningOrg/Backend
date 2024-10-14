package com.ytrewq.rosLearning.Repositories;

import com.ytrewq.rosLearning.Entities.ThemeMaterial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ThemeMaterialRepository extends CrudRepository<ThemeMaterial, Integer> {
    Optional<ThemeMaterial> getThemeMaterialByTitle(String title);

    @Query("SELECT tm FROM Course c JOIN c.themes th JOIN th.themes tm WHERE c.id = %:course_id% AND th.id = %:theme_id%")
    ThemeMaterial[] getAllThemeMaterials(@Param("course_id") int course_id, @Param("theme_id") int theme_id);
}
