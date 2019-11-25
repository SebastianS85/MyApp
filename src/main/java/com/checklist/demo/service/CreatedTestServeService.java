package com.checklist.demo.service;


import com.checklist.demo.domain.machine.CreatedMachineTest;
import com.checklist.demo.repository.CreatedMachineTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreatedTestServeService {

    @Autowired
    private CreatedMachineTestRepository createdMachineTestRepository;

    public List<CreatedMachineTest>getTests(String machineSerial){

       return  createdMachineTestRepository.findCreatedMachineTestByEmbeddedTestKey_MachineSerial(machineSerial);
    }

}
