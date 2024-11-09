package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.DTOs.CourseDto;
import com.ytrewq.rosLearning.DTOs.EmulationDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.Emulation;
import com.ytrewq.rosLearning.Entities.Task;
import com.ytrewq.rosLearning.Repositories.EmulationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmulationService {
    private final EmulationRepository emulationRepository;
    ModelMapper modelMapper = new ModelMapper();

    public EmulationService(EmulationRepository emulationRepository) {
        this.emulationRepository = emulationRepository;
    }

    public void save(Emulation emulation) {
        emulationRepository.save(emulation);
    }

    public List<EmulationDto> getAllEmulations() {
        Set<Emulation> emulations = emulationRepository.findAll();
        return emulations.stream().map(emulation -> modelMapper.map(emulation, EmulationDto.class)).toList();    }
}
