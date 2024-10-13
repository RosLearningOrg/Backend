package com.ytrewq.rosLearning.repositories;

import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Theme;

import java.util.Set;

public interface ThemeRepository {

    Set<Theme> getAllCourseThemes(int id);


}
