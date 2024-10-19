package com.ytrewq.rosLearning.Repositories;

import com.ytrewq.rosLearning.Entities.ThemeMaterial;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeMaterialRepository extends BaseRepo<ThemeMaterial> {
//    Optional<ThemeMaterial> getThemeMaterialByTitle(String title);
//
//    @Query("SELECT tm FROM Course c JOIN c.themes th JOIN th.themes tm WHERE c.id = %:course_id% AND th.id = %:theme_id%")
//    ThemeMaterial[] getAllThemeMaterials(@Param("course_id") int course_id, @Param("theme_id") int theme_id);
}
