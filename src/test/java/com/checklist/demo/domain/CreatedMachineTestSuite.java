package com.checklist.demo.domain;

import com.checklist.demo.domain.machine.Machine;
import com.checklist.demo.domain.machine.MachineOption;
import com.checklist.demo.domain.machine.OptionTest;
import com.checklist.demo.repository.CreatedMachineTestRepository;
import com.checklist.demo.repository.MachineRepository;
import com.checklist.demo.repository.OptionRepository;
import com.checklist.demo.repository.OptionTestRepository;
import com.checklist.demo.service.MachineTestCreatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatedMachineTestSuite {

    @Autowired
    CreatedMachineTestRepository createdMachineTestRepository;
    @Autowired
    MachineRepository machineRepository;
    @Autowired
    OptionRepository optionRepository;
    @Autowired
    OptionTestRepository optionTestRepository;
    @Autowired
    MachineTestCreatorService creatorService;
    @Test
    public void shouldCreateTests() {
        OptionTest test = new OptionTest();
        test.setDescription("test description");
        OptionTest test1 = new OptionTest();
        test1.setDescription("test1 description");
        OptionTest test2 = new OptionTest();
        test1.setDescription("test1 description");
        optionTestRepository.save(test);
        optionTestRepository.save(test1);
        optionTestRepository.save(test2);
        MachineOption machineOption = new MachineOption();
        machineOption.setDescription("test");
        MachineOption machineOption1 = new MachineOption();
        machineOption1.setDescription("test");
        machineOption.getOptionTests().add(test);
        machineOption.getOptionTests().add(test1);
        machineOption1.getOptionTests().add(test2);
        optionRepository.save(machineOption);
        optionRepository.save(machineOption1);
        Machine machine = new Machine();
        machine.setMachineSerial("a2");
        machine.setMachineType("type1");
        machine.getMachineOptions().add(machineOption);
        machine.getMachineOptions().add(machineOption1);
        machineRepository.save(machine);
        creatorService.createMachine(machine);

    }

}