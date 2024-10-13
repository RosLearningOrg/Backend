package com.ytrewq.rosLearning.services;

import com.ytrewq.rosLearning.dto.CourseDto;
import com.ytrewq.rosLearning.dto.ThemesDto;
import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Theme;
import com.ytrewq.rosLearning.repositories.Impl.CourseRepositoryImpl;
import com.ytrewq.rosLearning.repositories.Impl.ThemeRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ThemeService {
    @Autowired
    ThemeRepositoryImpl themeRepository;
    @Autowired
    CourseRepositoryImpl courseRepository;
    ModelMapper modelMapper;

    public Set<ThemesDto> getAllCourseThemes(int course_id) {
        Set<Theme> themes = themeRepository.getAllCourseThemes(course_id);
        return themes.stream()
                .map(theme -> modelMapper.map(theme, ThemesDto.class))
                .collect(Collectors.toSet());

    }

    public Theme getThemeById(int theme_id) {
        return themeRepository.findById(Theme.class, theme_id);
    }
}