package com.ytrewq.rosLearning.Repositories;

import com.ytrewq.rosLearning.Entities.Theme;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends BaseRepo<Theme> {
//    Optional<Theme> getThemeByTitle(String title);
//
//    @Query("Select cs.themes FROM Course cs WHERE cs.id = %:course_id%")
//    public Theme[] getAllCourseThemes(@Param("course_id") int course_id);
}
