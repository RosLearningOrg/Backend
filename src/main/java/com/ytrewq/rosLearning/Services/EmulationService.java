package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.DTOs.CourseDto;
import com.ytrewq.rosLearning.DTOs.EmulationDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.Emulation;
import com.ytrewq.rosLearning.Entities.Task;
import com.ytrewq.rosLearning.Entities.Theme;
import com.ytrewq.rosLearning.Repositories.EmulationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmulationService {
    private final EmulationRepository emulationRepository;
    ModelMapper modelMapper = new ModelMapper();

    public EmulationService(EmulationRepository emulationRepository) {
        this.emulationRepository = emulationRepository;
    }

    public EmulationDto save(Emulation emulation) {
        emulationRepository.save(emulation);
        return modelMapper.map(emulation,EmulationDto.class);
    }

    public List<EmulationDto> getAllEmulations() {
        Set<Emulation> emulations = emulationRepository.findAll();
        return emulations.stream().map(emulation -> modelMapper.map(emulation, EmulationDto.class)).toList();    }

    public boolean existsById(int emulationId) {
        return emulationRepository.existsById(emulationId);
    }
    public Emulation getEmulationById(int emulationId) {
        Optional<Emulation> emulation = emulationRepository.findById(emulationId);
        return emulation.orElse(null);
    }
    public void deleteTaskEmulation(int emulationID) {
        emulationRepository.deleteById(emulationID);
    }

}
