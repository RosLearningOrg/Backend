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
