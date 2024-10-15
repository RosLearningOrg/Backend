package com.ytrewq.rosLearning.Repositories;


import com.ytrewq.rosLearning.Entities.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface ThemeRepository extends CrudRepository<Theme, Integer> {
    <S extends Theme> S save (S entity);
    Optional<Theme> getThemeByTitle(String title);

    @Query("Select cs.themes FROM Course cs WHERE cs.id = %:course_id%")
    public Theme[] getAllCourseThemes(@Param("course_id") int course_id);

}
