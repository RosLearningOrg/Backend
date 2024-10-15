package com.ytrewq.rosLearning.Repositories;


import com.ytrewq.rosLearning.Entities.Theme;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ThemeRepository extends CrudRepository<Theme, Integer> {
`
    Set<Theme> getAllCourseThemes(int id);
    <S extends Theme> S save (S entity);

}
