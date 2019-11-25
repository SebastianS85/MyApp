package com.checklist.demo.service;

import com.checklist.demo.domain.machine.Machine;
import com.checklist.demo.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineDbService {

    @Autowired
    MachineRepository machineRepository;

    List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    Optional<Machine> findMachineBySerialNr(String serialNr) {
        return findMachineBySerialNr(serialNr);
    }

    Machine saveMachine(Machine machine) {
        return machineRepository.save(machine);
    }


}
