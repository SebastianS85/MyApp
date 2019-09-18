package com.checklist.demo;

import com.checklist.demo.domain.*;
import com.checklist.demo.mapper.MachineMapper;
import com.checklist.demo.mapper.OptionMapper;
import com.checklist.demo.repository.MachineRepository;
import com.checklist.demo.repository.OptionRepository;

import com.checklist.demo.repository.TestRepository;

import com.checklist.demo.service.ListCreatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
@SpringBootTest

public class CheckListTestSuite {

    @Autowired
    MachineRepository machineRepository;
    @Autowired
    OptionRepository optionRepository;
    @Autowired
    TestRepository testRepository;

    @Autowired
    MachineMapper machineMapper;
    @Autowired
    OptionMapper optionMapper;


    @Test
    public void createRelation() {

        MachineTest test1 = new MachineTest();
        test1.setDescription("test1");
        MachineTest test2 = new MachineTest();
        test2.setDescription("test2");
        MachineTest test3 = new MachineTest();
        test3.setDescription("test3");
        testRepository.save(test1);
        testRepository.save(test2);
        testRepository.save(test3);

        MachineOption option1 = new MachineOption();
        option1.setDescription("first Option");
        option1.getMachineTestOptionList().add(test1);
        option1.getMachineTestOptionList().add(test2);
        option1.getMachineTestOptionList().add(test3);
        optionRepository.save(option1);

        MachineOption option2 = new MachineOption();
        option2.setDescription("second Option");
        option2.getMachineTestOptionList().add(test1);
        option2.getMachineTestOptionList().add(test2);
        option2.getMachineTestOptionList().add(test3);
        optionRepository.save(option2);

        Machine machine1 = new Machine();
        machine1.setMachineSerialNumber("a1");
        machine1.setMachineType("type1");
        machine1.getOptionList().add(option1);
        machine1.getOptionList().add(option2);

        ListCreatorService myCreator = new ListCreatorService();


        for (int i = 0; i < machine1.getOptionList().size(); i++) {
            machine1.getCreatedTestList().addAll(myCreator.createdTestList(machine1.getOptionList().get(i)
                    .getMachineTestOptionList(), machine1));
        }
        machineRepository.save(machine1);
        Machine machine = machineRepository.findByMachineSerialNumber("a1");

        System.out.println(machine.getCreatedTestList().stream().map(t -> t.getTestComment())
                .collect(Collectors.toList()));


    }
}