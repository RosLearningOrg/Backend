package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.ThemeMaterialDto;
import com.ytrewq.rosLearning.Entities.ThemeMaterial;
import com.ytrewq.rosLearning.Forms.ThemeMaterialForm;
import com.ytrewq.rosLearning.Services.ThemeMaterialService;
import com.ytrewq.rosLearning.Services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/materials")
public class ThemeMaterialsController {
    private final ThemeMaterialService customThemeMaterialService;
    @Autowired
    ThemeMaterialService themeMaterialService;
    @Autowired
    ThemeService themeService;

    public ThemeMaterialsController(ThemeMaterialService customThemeMaterialService) {
        this.customThemeMaterialService = customThemeMaterialService;
    }


    @GetMapping("/getAllThemeMaterials")
    public Set<ThemeMaterialDto> getAllThemeMaterials(@RequestParam int theme_id) {
        return themeMaterialService.getAllThemeMaterials(theme_id);

    }
    @PostMapping("/admin/createThemeMaterial")
    public Map<String, String> createThemeMaterial(@RequestBody ThemeMaterialForm form){
        ThemeMaterial themeMaterial = new ThemeMaterial();
        themeMaterial.setTitle(form.getTitle());
        themeMaterial.setMaterialType(form.getMaterialType());
        themeMaterial.setMaterialURL(form.getMaterialURL());
        themeMaterial.setMaterialText(form.getMaterialText());
        customThemeMaterialService.save(themeMaterial);

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "all_ok");
        return map;
    }
}
