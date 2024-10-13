package com.ytrewq.rosLearning.services;

import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Theme;
import com.ytrewq.rosLearning.repositories.Impl.CourseRepositoryImpl;
import com.ytrewq.rosLearning.repositories.Impl.ThemeRepositoryImpl;
import com.ytrewq.rosLearning.repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ThemeService {
    @Autowired
    ThemeRepositoryImpl themeRepository;
    @Autowired
    CourseRepositoryImpl courseRepository;
    public Set<Theme> getAllCourseThemes(int course_id) {
        Course course=courseRepository.findById(Course.class,course_id);
        if (course != null) {
            themeRepository.getAllCourseThemes(course);
        }
        return null;
    }
    public Theme getThemeById(int theme_id){
        return themeRepository.findById(Theme.class,theme_id);
    }
}