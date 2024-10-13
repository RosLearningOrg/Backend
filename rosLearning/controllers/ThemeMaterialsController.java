package com.ytrewq.rosLearning.controllers;

import com.ytrewq.rosLearning.dto.ThemeMaterialDto;
import com.ytrewq.rosLearning.entities.*;
import com.ytrewq.rosLearning.services.TaskService;
import com.ytrewq.rosLearning.services.ThemeMaterialService;
import com.ytrewq.rosLearning.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/materials")
public class ThemeMaterialsController {
    @Autowired
    ThemeMaterialService themeMaterialService;
    @Autowired
    ThemeService themeService;


    @GetMapping("/getAllThemeMaterials")
    public Set<ThemeMaterialDto> getAllThemeMaterials(@RequestParam int theme_id) {
            return themeMaterialService.getAllThemeMaterials(theme_id);

    }
}
