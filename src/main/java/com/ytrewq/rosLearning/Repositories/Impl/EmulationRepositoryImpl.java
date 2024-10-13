package com.ytrewq.rosLearning.Repositories.Impl;

import com.ytrewq.rosLearning.Entities.Emulation;
import com.ytrewq.rosLearning.Repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmulationRepositoryImpl extends BaseRepository<Emulation, Integer> {
    public EmulationRepositoryImpl() {
        super(Emulation.class);
    }
}
