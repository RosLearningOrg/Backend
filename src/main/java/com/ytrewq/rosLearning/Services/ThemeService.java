//package com.ytrewq.rosLearning.Services;
//
//import com.ytrewq.rosLearning.DTOs.CourseDto;
//import com.ytrewq.rosLearning.DTOs.ThemeMaterialDto;
//import com.ytrewq.rosLearning.DTOs.ThemesDto;
//import com.ytrewq.rosLearning.Entities.Course;
//import com.ytrewq.rosLearning.Entities.Theme;
//import com.ytrewq.rosLearning.Repositories.CourseRepository;
//import com.ytrewq.rosLearning.Repositories.ThemeRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ThemeService {
//    @Autowired
//    ThemeRepository themeRepository;
//    @Autowired
//    CourseRepository courseRepository;
//    ModelMapper modelMapper = new ModelMapper();
//
//    public ThemesDto[] getAllCourseThemes(int course_id) {
//        Optional<Course> course = courseRepository.findById(course_id);
//        if (course.isPresent()) {
//            Theme[] themes = themeRepository.getAllCourseThemes(course_id);
//            return Arrays.stream(themes).map(theme -> modelMapper.map(theme, ThemesDto.class))
//                    .toArray(ThemesDto[]::new);
//        } else throw new RuntimeException("Course not  found");
//
//    }
//
//    public ThemesDto getThemeById(int theme_id) {
//
//        return modelMapper.map(themeRepository.findById(theme_id), ThemesDto.class);
//    }
//
//    public ThemesDto[] getAllThemes() {
//        List<Theme> themes = (List<Theme>) themeRepository.findAll();
//        return themes.stream()
//                .map(theme -> modelMapper.map(theme, ThemesDto.class))
//                .toArray(ThemesDto[]::new);
//    }
//}