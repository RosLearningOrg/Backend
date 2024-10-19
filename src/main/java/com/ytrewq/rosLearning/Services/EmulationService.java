package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.Emulation;
import com.ytrewq.rosLearning.Repositories.EmulationRepository;

public class EmulationService {
    private final EmulationRepository repo;

    public EmulationService(EmulationRepository repo) {
        this.repo = repo;
    }

    public void save(Emulation emulation) {
        repo.save(emulation);
    }
}
