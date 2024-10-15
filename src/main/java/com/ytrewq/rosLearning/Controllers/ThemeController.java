package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.ThemesDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.Theme;
import com.ytrewq.rosLearning.Forms.ThemeForm;
import com.ytrewq.rosLearning.Services.CourseService;
import com.ytrewq.rosLearning.Services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/themes")
public class ThemeController {
    private final ThemeService customThemeService;
    @Autowired
    CourseService courseService;

    public ThemeController(ThemeService customThemeService) {
        this.customThemeService = customThemeService;
    }

    @GetMapping("/getAllCourseThemes")
    public Set<ThemesDto> getAllCourseThemes(@RequestParam int id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return customThemeService.getAllCourseThemes(id);

        }
        return null;
    }

    @GetMapping("/getAllThemes")
    public Set<ThemesDto> getAllThemes() {
        return customThemeService.getAllThemes();
    }

    @PostMapping("/admin/createTheme")
    public Map<String, String> createCourse(@RequestBody ThemeForm form){
        Theme theme = new Theme();
        theme.setTitle(form.getTitle());
        theme.setDateOfCreation(LocalDateTime.now());
        theme.setDescription(form.getDescription());
        customThemeService.save(theme);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }
}
