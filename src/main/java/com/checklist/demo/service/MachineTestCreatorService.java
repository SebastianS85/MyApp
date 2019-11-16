package com.checklist.demo.service;

import com.checklist.demo.domain.*;
import com.checklist.demo.repository.CreatedMachineTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineTestCreatorService {

    @Autowired
    CreatedMachineTestRepository createdMachineTestRepository;

    public void createMachine(Machine machine) {

        for (int i = 0; i < machine.getMachineOptions().size(); i++) {
            MachineOption option = machine.getMachineOptions().get(i);
            for (int j = 0; j < option.getOptionTests().size(); j++) {
                OptionTest optiontest = option.getOptionTests().get(j);
                createdMachineTestRepository.save(
                        new CreatedMachineTest(new EmbeddedTestKey(machine.getMachineSerial(), option.getId(),
                                optiontest.getId()), ResultEnum.NOT_DONE, "  ")
                );
            }

        }

    }
}
