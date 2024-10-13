package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.ThemesDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Services.CourseService;
import com.ytrewq.rosLearning.Services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/themes")
public class ThemeController {
    @Autowired
    ThemeService themeService;
    @Autowired
    CourseService courseService;

    @GetMapping("/getAllCourseThemes")
    public Set<ThemesDto> getAllCourseThemes(@RequestParam int id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return themeService.getAllCourseThemes(id);

        }
        return null;
    }

    @GetMapping("/getAllThemes")
    public Set<ThemesDto> getAllThemes() {
        return themeService.getAllThemes();
    }

}
