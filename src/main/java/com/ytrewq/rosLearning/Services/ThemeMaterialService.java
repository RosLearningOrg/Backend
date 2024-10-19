package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.Entities.Theme;
import com.ytrewq.rosLearning.Entities.ThemeMaterial;
import com.ytrewq.rosLearning.Repositories.ThemeMaterialRepository;
import com.ytrewq.rosLearning.Repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ThemeMaterialService {
    @Autowired
    private final ThemeRepository themeRepository;
    @Autowired
    private final ThemeMaterialRepository themeMaterialRepository;

    public ThemeMaterialService(ThemeRepository themeRepository, ThemeMaterialRepository themeMaterialRepository) {
        this.themeRepository = themeRepository;
        this.themeMaterialRepository = themeMaterialRepository;
    }

    public List<ThemeMaterial> getThemeMaterials(Theme theme) {
        String[] materialsIdsStr = theme.getMaterialsIdsStr().split("/;/");
        List<Integer> materialsIds = new ArrayList<>();
        for (String s : materialsIdsStr) {
            materialsIds.add(Integer.parseInt(s));
        }
        return (List<ThemeMaterial>) themeMaterialRepository.findAllById(materialsIds);
    }

    public void setThemeMaterials(Theme theme, List<ThemeMaterial> materials) {
        List<String> materialsIdsStr = new ArrayList<>();
        for (ThemeMaterial material : materials) {
            materialsIdsStr.add(String.valueOf(material.getId()));
        }
        theme.setMaterialsIdsStr(String.join("/;/", materialsIdsStr));
        themeRepository.save(theme);
    }

    public ThemeMaterial getThemeMaterial(Theme theme, Integer materialId) {
        String materialIdStr = materialId.toString();
        for (String materialIdStrI : theme.getMaterialsIdsStr().split("/;/")) {
            if (materialIdStrI.equals(materialIdStr)) {
                Optional<ThemeMaterial> material = themeMaterialRepository.findById(materialId);
                return material.orElse(null);
            }
        }
        return null;
    }

    public void addThemeMaterial(Theme theme, ThemeMaterial material) {
        String courseId = String.valueOf(material.getId());
        if (!theme.getMaterialsIdsStr().isEmpty()) {
            theme.setMaterialsIdsStr(theme.getMaterialsIdsStr() + "/;/" + courseId);
        } else {
            theme.setMaterialsIdsStr(courseId);
        }
        themeRepository.save(theme);
    }
}


//package com.ytrewq.rosLearning.Services;
//
//import com.ytrewq.rosLearning.DTOs.TaskDto;
//import com.ytrewq.rosLearning.DTOs.ThemeMaterialDto;
//import com.ytrewq.rosLearning.Entities.ThemeMaterial;
//import com.ytrewq.rosLearning.Repositories.ThemeMaterialRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//@Service
//public class ThemeMaterialService {
//    @Autowired
//    ThemeMaterialRepository themeMaterialRepository;
//    ModelMapper modelMapper = new ModelMapper();
//
//    public ThemeMaterialDto[] getAllThemeMaterials(int course_id, int theme_id) {
//        Optional<ThemeMaterial> theme = themeMaterialRepository.findById(theme_id);
//        if (theme.isPresent()) {
//            ThemeMaterial[] themeMaterials = themeMaterialRepository.getAllThemeMaterials(course_id, theme_id);
//            return Arrays.stream(themeMaterials)
//                    .map(themeMaterial -> modelMapper.map(themeMaterial, ThemeMaterialDto.class))
//                    .toArray(ThemeMaterialDto[]::new);
//
//        } else throw new RuntimeException("ThemeMaterial not  found");
//    }
//
//
//}
