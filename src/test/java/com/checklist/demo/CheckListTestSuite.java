package com.checklist.demo;


import com.checklist.demo.domain.Machine;
import com.checklist.demo.domain.MachineOption;
import com.checklist.demo.repository.MachineRepository;
import com.checklist.demo.repository.OptionRepository;
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
    @Test
    public void testCheckListDao(){

        Machine machine1=new Machine();
        Machine machine2=new Machine();
        machine1.setMachineSerialNumber("a1");
        machine2.setMachineSerialNumber("a2");
        machine1.setMachineType("type1");
        machine2.setMachineType("type2");

        MachineOption option1=new MachineOption();
        MachineOption option2=new MachineOption();
        MachineOption option3=new MachineOption();
        option1.setDescription("first");
        option2.setDescription("second");
        option3.setDescription("third");
        optionRepository.save(option1);
        optionRepository.save(option2);
        optionRepository.save(option3);
       machine1.getOptionList().add(option1);
       machine2.getOptionList().add(option1);
//       machine1.getOptionList().add(option2);
       machine2.getOptionList().add(option2);

       machineRepository.save(machine1);
       machineRepository.save(machine2);


       if(machine1.getOptionList().contains(option1)){
           machine1.getOptionList().add(option2);
       }
        machineRepository.save(machine1);
        machineRepository.save(machine2);



    }
}
