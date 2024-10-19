package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.Entities.Emulation;
import com.ytrewq.rosLearning.Repositories.EmulationRepository;
import org.springframework.stereotype.Service;

@Service
public class EmulationService {
    private final EmulationRepository emulationRepository;

    public EmulationService(EmulationRepository emulationRepository) {
        this.emulationRepository = emulationRepository;
    }

    public void save(Emulation emulation) {
        emulationRepository.save(emulation);
    }
}
