package com.ytrewq.rosLearning.controllers;

import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.dto.ThemesDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.services.CourseService;
import com.ytrewq.rosLearning.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class ThemeController {
    @Autowired
    ThemeService themeService;
    @Autowired
    CourseService courseService;

    @GetMapping("/user/getCourseThemes/{course_id}")
    public Set<ThemesDto> getAllCourseThemes(@AuthenticationPrincipal User user, @RequestParam int course_id) {
        Course course = courseService.getCourseById(course_id);
        if (course != null) {
            return themeService.getAllCourseThemes(course_id);

        }
        return null;
    }

    @GetMapping("/getAllThemes")
    public Set<ThemesDto> getAllThemes() {
        return themeService.getAllThemes();
    }

}
