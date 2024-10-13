package com.ytrewq.rosLearning.services;

import com.ytrewq.rosLearning.dto.CourseDto;
import com.ytrewq.rosLearning.dto.ThemeMaterialDto;
import com.ytrewq.rosLearning.entities.Task;
import com.ytrewq.rosLearning.entities.Theme;
import com.ytrewq.rosLearning.entities.ThemeMaterial;
import com.ytrewq.rosLearning.repositories.Impl.ThemeMaterialRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ThemeMaterialService {
    @Autowired
    ThemeMaterialRepositoryImpl themeMaterialRepository;
    ModelMapper modelMapper;

    public Set<ThemeMaterialDto> getAllThemeMaterials(int theme_id){
        ThemeMaterial theme = themeMaterialRepository.getAllThemeMaterials(theme_id);
        if (theme!=null) {
            Set<ThemeMaterial> themeMaterials = themeMaterialRepository.getAllThemeMaterials(theme_id);
            return themeMaterials.stream()
                    .map(themeMaterial -> modelMapper.map(themeMaterial, ThemeMaterialDto.class))
                    .collect(Collectors.toSet());
        }
        else throw new RuntimeException("ThemeMaterial not  found");
    }


}
