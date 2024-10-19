package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.ThemesDto;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Exeptions.AppException;
import com.ytrewq.rosLearning.Services.CourseService;
import com.ytrewq.rosLearning.Services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ThemeController {
    @Autowired
    ThemeService themeService;

    @Autowired
    CourseService courseService;

    @GetMapping("/user/getCourseThemes")
    public List<ThemesDto> getCourseThemes(@AuthenticationPrincipal User user, @RequestParam(name="course_id") int courseId) {
        List<ThemesDto> themes = themeService.getCourseThemes(user, courseId);
        if (themes == null) {
            throw new AppException("Course not allow for user");
        }
        return themes;
    }

    @GetMapping("/admin/getCourseThemes")
    public List<ThemesDto> getCourseThemesAdmin(@AuthenticationPrincipal User user, @RequestParam(name="course_id") int courseId) {
        List<ThemesDto> themes = themeService.getCourseThemesAdmin(courseId);
        if (themes == null) {
            throw new AppException("Course not exists");
        }
        return themes;
    }

    @GetMapping("/admin/getAllThemes")
    public List<ThemesDto> getAllThemes() {
        return themeService.getAllThemes();
    }
}
