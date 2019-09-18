package com.checklist.demo.service;

import com.checklist.demo.domain.Machine;
import com.checklist.demo.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineDbService {

    @Autowired
    MachineRepository machineRepository;

    public List<Machine> getAllMachine() {
        return machineRepository.findAll();
    }

    public Machine saveMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    public Machine getMachineBySerialNumber(String serialNumber) {
        return machineRepository.findByMachineSerialNumber(serialNumber);
    }

    public void deleteMachineBySerialNumber(String serialNumber) {
        machineRepository.deleteByMachineSerialNumber(serialNumber);
    }
}
