//package com.ytrewq.rosLearning.Services;
//
//import com.ytrewq.rosLearning.Entities.Theme;
//import com.ytrewq.rosLearning.Entities.ThemeMaterial;
//import com.ytrewq.rosLearning.Repositories.ThemeMaterialRepository;
//import com.ytrewq.rosLearning.Repositories.ThemeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util`.List;
//import java.util.Optional;
//
//@Service
//public class ThemeService {
//    @Autowired
//    private final ThemeRepository themeRepository;
//    @Autowired
//    private final ThemeMaterialRepository themeMaterialRepository;
//
//    public ThemeService(ThemeRepository themeRepository, ThemeMaterialRepository themeMaterialRepository) {
//        this.themeRepository = themeRepository;
//        this.themeMaterialRepository = themeMaterialRepository;
//    }
//
//    public List<ThemeMaterial> getThemeMaterials(Theme theme) {
//        String[] materialsIdsStr = theme.getMaterialsIdsStr().split("/;/");
//        List<Integer> materialsIds = new ArrayList<>();
//        for (String s : materialsIdsStr) {
//            materialsIds.add(Integer.parseInt(s));
//        }
//        return (List<ThemeMaterial>) themeMaterialRepository.findAllById(materialsIds);
//    }
//
//    public void setThemeMaterials(Theme theme, List<ThemeMaterial> materials) {
//        List<String> materialsIdsStr = new ArrayList<>();
//        for (ThemeMaterial material : materials) {
//            materialsIdsStr.add(String.valueOf(material.getId()));
//        }
//        theme.setMaterialsIdsStr(String.join("/;/", materialsIdsStr));
//        themeRepository.save(theme);
//    }
//
//    public ThemeMaterial getThemeMaterial(Theme theme, Integer materialId) {
//        String materialIdStr = materialId.toString();
//        for (String materialIdStrI : theme.getMaterialsIdsStr().split("/;/")) {
//            if (materialIdStrI.equals(materialIdStr)) {
//                Optional<ThemeMaterial> material = themeMaterialRepository.findById(materialId);
//                return material.orElse(null);
//            }
//        }
//        return null;
//    }
//
//    public void addThemeMaterial(Theme theme, ThemeMaterial material) {
//        String courseId = String.valueOf(material.getId());
//        if (!theme.getMaterialsIdsStr().isEmpty()) {
//            theme.setMaterialsIdsStr(theme.getMaterialsIdsStr() + "/;/" + courseId);
//        } else {
//            theme.setMaterialsIdsStr(courseId);
//        }
//        themeRepository.save(theme);
//    }
//}



//@Service
//public class ThemeService {
//    @Autowired
//    ThemeRepository themeRepository;
//    @Autowired
//    CourseRepository courseRepository;
//    ModelMapper modelMapper = new ModelMapper();
//
//    public ThemesDto[] getAllCourseThemes(int course_id) {
//        Optional<Course> course = courseRepository.findById(course_id);
//        if (course.isPresent()) {
//            Theme[] themes = themeRepository.getAllCourseThemes(course_id);
//            return Arrays.stream(themes).map(theme -> modelMapper.map(theme, ThemesDto.class))
//                    .toArray(ThemesDto[]::new);
//        } else throw new RuntimeException("Course not  found");
//
//    }
//
//    public ThemesDto getThemeById(int theme_id) {
//
//        return modelMapper.map(themeRepository.findById(theme_id), ThemesDto.class);
//    }
//
//    public ThemesDto[] getAllThemes() {
//        List<Theme> themes = (List<Theme>) themeRepository.findAll();
//        return themes.stream()
//                .map(theme -> modelMapper.map(theme, ThemesDto.class))
//                .toArray(ThemesDto[]::new);
//    }
//}