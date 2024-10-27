package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.ThemesDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.Theme;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Exeptions.AppException;
import com.ytrewq.rosLearning.Forms.ThemeForm;
import com.ytrewq.rosLearning.Services.CourseService;
import com.ytrewq.rosLearning.Services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ThemeController {
    @Autowired
    ThemeService themeService;

    @Autowired
    CourseService courseService;

    @GetMapping("/user/getCourseThemes")
    public List<ThemesDto> getCourseThemes(@AuthenticationPrincipal User user, @RequestParam(name = "course_id") int courseId) {
        List<ThemesDto> themes = themeService.getCourseThemes(user, courseId);
        if (themes == null) {
            throw new AppException("Course not allow for user");
        }
        return themes;
    }

    @GetMapping("/admin/getCourseThemes")
    public List<ThemesDto> getCourseThemesAdmin(@AuthenticationPrincipal User user, @RequestParam(name = "course_id") int courseId) {
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

    @PostMapping("/admin/createTheme")
    public Map<String, String> createCourse(@RequestBody ThemeForm form) {
        Theme theme = new Theme();
        theme.setTitle(form.getTitle());
        theme.setDateOfCreation(LocalDateTime.now());
        theme.setDescription(form.getDescription());
        themeService.save(theme);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }

    @GetMapping("/admin/removeCourseThemes")
    public Map<String, String> removeCourseThemes(@RequestParam(name = "course_id") int courseId,
                                                  @RequestParam(name = "theme_id") int themeId) {

        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            throw new AppException("Course not found.");
        }


        if (!themeService.existsById(themeId)) {
            throw new AppException("Theme not found.");
        }

        themeService.removeCourseTheme(course, themeId);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }
}
