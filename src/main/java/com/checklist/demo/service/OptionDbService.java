package com.checklist.demo.service;


import com.checklist.demo.domain.machine.MachineOption;
import com.checklist.demo.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionDbService {
    @Autowired
    private OptionRepository optionRepository;

    public List<MachineOption> getAllOptions() {
        return optionRepository.findAll();
    }

    public MachineOption saveOption(MachineOption machineOption) {
        return optionRepository.save(machineOption);
    }

    public Optional<MachineOption> getMachineOption(Long id) {
        return optionRepository.findById(id);
    }

    public void deleteMachineOption(Long id) {
        optionRepository.deleteById(id);
    }
}
