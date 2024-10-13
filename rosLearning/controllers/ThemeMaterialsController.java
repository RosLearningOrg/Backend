package com.ytrewq.rosLearning.controllers;

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
    public Set<ThemeMaterial> getAllThemeMaterials(@RequestParam int task_id) {
        Theme theme = themeService.getThemeById(task_id);
        if (theme!=null){
            return themeMaterialService.getAllThemeMaterials(task_id);
        }
        return null;

    }
}
