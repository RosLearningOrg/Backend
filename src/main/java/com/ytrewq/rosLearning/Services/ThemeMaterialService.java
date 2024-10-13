package com.ytrewq.rosLearning.Services;


import com.ytrewq.rosLearning.DTOs.ThemeMaterialDto;
import com.ytrewq.rosLearning.Entities.ThemeMaterial;
import com.ytrewq.rosLearning.Repositories.Impl.ThemeMaterialRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ThemeMaterialService {
    @Autowired
    ThemeMaterialRepositoryImpl themeMaterialRepository;
    ModelMapper modelMapper = new ModelMapper();

    public Set<ThemeMaterialDto> getAllThemeMaterials(int course_id, int theme_id) {
        ThemeMaterial theme = themeMaterialRepository.findById(ThemeMaterial.class, theme_id);
        if (theme != null) {
            Set<ThemeMaterial> themeMaterials = themeMaterialRepository.getAllThemeMaterials(course_id, theme_id);
            return themeMaterials.stream()
                    .map(themeMaterial -> modelMapper.map(themeMaterial, ThemeMaterialDto.class))
                    .collect(Collectors.toSet());
        } else throw new RuntimeException("ThemeMaterial not  found");
    }


}
