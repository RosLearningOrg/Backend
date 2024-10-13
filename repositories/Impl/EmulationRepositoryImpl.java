package com.ytrewq.rosLearning.repositories.Impl;
import com.ytrewq.rosLearning.Entities.Emulation;
import com.ytrewq.rosLearning.repositories.BaseRepository;
import org.springframework.stereotype.Repository;
@Repository
public class EmulationRepositoryImpl extends BaseRepository<Emulation,Integer> {
    public EmulationRepositoryImpl() {
        super(Emulation.class);
    }
}
