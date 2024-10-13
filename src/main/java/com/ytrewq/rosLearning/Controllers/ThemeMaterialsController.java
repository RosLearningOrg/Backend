package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.ThemeMaterialDto;
import com.ytrewq.rosLearning.Services.ThemeMaterialService;
import com.ytrewq.rosLearning.Services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
