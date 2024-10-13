package com.ytrewq.rosLearning.Repositories;


import com.ytrewq.rosLearning.Entities.Theme;

import java.util.Set;

public interface ThemeRepository {

    Set<Theme> getAllCourseThemes(int id);

}
