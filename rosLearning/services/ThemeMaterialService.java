package com.ytrewq.rosLearning.services;

import com.ytrewq.rosLearning.entities.Task;
import com.ytrewq.rosLearning.entities.Theme;
import com.ytrewq.rosLearning.entities.ThemeMaterial;
import com.ytrewq.rosLearning.repositories.Impl.ThemeMaterialRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ThemeMaterialService {
    @Autowired
    ThemeMaterialRepositoryImpl themeMaterialRepository;

    public Set<ThemeMaterial> getAllThemeMaterials(int theme_id){
        return themeMaterialRepository.getAllThemeMaterials(theme_id);
    }


}
