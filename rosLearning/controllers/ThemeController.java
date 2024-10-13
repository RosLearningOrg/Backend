package com.ytrewq.rosLearning.controllers;

import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Task;
import com.ytrewq.rosLearning.entities.Theme;
import com.ytrewq.rosLearning.services.CourseService;
import com.ytrewq.rosLearning.services.TaskService;
import com.ytrewq.rosLearning.services.ThemeService;
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
    public Set<Theme> getAllCourseThemes(@RequestParam int id) {
        Course course=courseService.getCourseById(id);
        if (course!= null){
            return themeService.getAllCourseThemes(id);

        }
        return null;
    }
}
