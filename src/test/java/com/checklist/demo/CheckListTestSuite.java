package com.checklist.demo;
import com.checklist.demo.domain.*;
import com.checklist.demo.mapper.MachineMapper;
import com.checklist.demo.mapper.OptionMapper;
import com.checklist.demo.repository.MachineRepository;
import com.checklist.demo.repository.OptionRepository;

import com.checklist.demo.repository.TestRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


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


//    @Test
//    public void createRelation() {
//        MachineOption option1 = new MachineOption();
//        option1.setDescription("option1");
//
//        optionRepository.save(option1);
//
//        MachineTest test1 = new MachineTest();
//        test1.setDescription("test1");
//        test1.setComment("comment1");
//        test1.getMachineOptionList().add(option1);
//
//        optionRepository.save(option1);
//        testRepository.save(test1);
//
//
//        Machine machine1 = new Machine();
//        machine1.setMachineSerialNumber("a1");
//        machine1.setMachineType("type1");
//        machine1.getOptionList().add(option1);
//        option1.getMachineList().add(machine1);
//        optionRepository.save(option1);
//        machineRepository.save(machine1);
//
//    }

//    @Test
//    public void createMachineTest(){
//        MachineDto machine1dto= new MachineDto();
//        machine1dto.setMachineType("type1");
//        machine1dto.setMachineSerialNumber("a1");
//
//        machineRepository.save(machineMapper.mapToMachine(machine1dto));
//        Assert.assertEquals(1,machineRepository.findAll().size());
//
//    } @Test
//    public void createOptionTest(){
//
//        MachineOptionDto option1dto=new MachineOptionDto();
//        option1dto.setDescription("first desc");
//        optionRepository.save(optionMapper.mapToOption(option1dto));
//        Assert.assertEquals(2,optionRepository.findAll().size());
//
//    }





}
