package com.ytrewq.rosLearning.controllers;

import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.dto.ThemeMaterialDto;
import com.ytrewq.rosLearning.services.ThemeMaterialService;
import com.ytrewq.rosLearning.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class ThemeMaterialsController {
    @Autowired
    ThemeMaterialService themeMaterialService;
    @Autowired
    ThemeService themeService;


    @GetMapping("/user/getThemeMaterials/<course_id>_<theme_id>")
    public Set<ThemeMaterialDto> getAllThemeMaterials(@AuthenticationPrincipal User user, @RequestParam int course_id, int theme_id ) {
            return themeMaterialService.getAllThemeMaterials(course_id,theme_id);

    }
}
