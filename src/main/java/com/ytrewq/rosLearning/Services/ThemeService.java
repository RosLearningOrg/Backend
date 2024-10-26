package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.DTOs.ThemesDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.Theme;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Repositories.CourseRepository;
import com.ytrewq.rosLearning.Repositories.ThemeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {
    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final ThemeRepository themeRepository;
    @Autowired
    private final UserService userService;

    ModelMapper modelMapper = new ModelMapper();


    public ThemeService(CourseRepository courseRepository, ThemeRepository themeRepository, UserService userService) {
        this.courseRepository = courseRepository;
        this.themeRepository = themeRepository;
        this.userService = userService;
    }

    public List<Theme> getCourseThemes(Course course) {
        String[] themesIdsStr = course.getThemesIdsStr().split("/;/");
        List<Integer> themesIds = new ArrayList<>();
        for (String s : themesIdsStr) {
            if (!s.isEmpty()) {
                themesIds.add(Integer.parseInt(s));
            }
        }
        return (List<Theme>) themeRepository.findAllById(themesIds);
    }

    public void setCourseThemes(Course course, List<Theme> themes) {
        List<String> themesIdsStr = new ArrayList<>();
        for (Theme theme : themes) {
            themesIdsStr.add(String.valueOf(theme.getId()));
        }
        course.setThemesIdsStr(String.join("/;/", themesIdsStr));
        courseRepository.save(course);
    }

    public Theme getCourseTheme(Course course, Integer themeId) {
        String themeIdStr = themeId.toString();
        if (("/;/" + course.getThemesIdsStr() + "/;/").contains("/;/" + themeIdStr + "/;/")) {
            Optional<Theme> theme = themeRepository.findById(themeId);
            return theme.orElse(null);
        }
        return null;
    }

    public void addCourseTheme(Course course, Theme theme) {
        String themeId = String.valueOf(theme.getId());
        if (course.getThemesIdsStr() == null) {
            course.setThemesIdsStr("");
        }
        if (!course.getThemesIdsStr().isEmpty()) {
            course.setThemesIdsStr(course.getThemesIdsStr() + "/;/" + themeId);
        } else {
            course.setThemesIdsStr(themeId);
        }
        courseRepository.save(course);
    }

    public List<ThemesDto> getCourseThemes(User user, Integer courseId) {
        Course course = userService.getUserCourse(user, courseId);
        if (course != null) {
            return getCourseThemes(course).stream().map(theme -> modelMapper.map(theme, ThemesDto.class)).toList();
        }
        return null;
    }

    public List<ThemesDto> getCourseThemesAdmin(Integer courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if (course.isPresent()) {
            return getCourseThemes(course.get()).stream().map(theme -> modelMapper.map(theme, ThemesDto.class)).toList();
        }
        return null;
    }

    public List<ThemesDto> getAllThemes() {
        return themeRepository.findAll().stream().map(theme -> modelMapper.map(theme, ThemesDto.class)).toList();
    }

    public Theme getCourseTheme(User user, Integer courseId, Integer themeId) {
        Course course = userService.getUserCourse(user, courseId);
        if (course != null) {
            for (Theme theme : getCourseThemes(course)) {
                if (theme.getId() == themeId) {
                    return theme;
                }
            }
        }
        return null;
    }

    public Theme getThemeAdmin(Integer themeId) {
        Optional<Theme> theme = themeRepository.findById(themeId);
        return theme.orElse(null);
    }

    public void save(Theme theme) {
        themeRepository.save(theme);
    }
}