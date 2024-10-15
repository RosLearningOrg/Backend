package com.ytrewq.rosLearning.Repositories;

import com.ytrewq.rosLearning.Entities.Emulation;
import com.ytrewq.rosLearning.Entities.Theme;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface EmulationRepository extends CrudRepository<Theme, Integer> {
    Set<Emulation> getAllEmulations(int id);
    <S extends Emulation> S save (S entity);
}
