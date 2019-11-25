package com.checklist.demo.service;


import com.checklist.demo.domain.machine.MachineOption;
import com.checklist.demo.repository.OptionRepository;
import com.checklist.demo.repository.OptionTestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbserviceTest {

    @Autowired
    OptionTestRepository optionTestRepository;
    @Autowired
    OptionRepository optionRepository;

    @Test
    public void testAddingTestToOption(){
     MachineOption option =  optionRepository.findById(472L).get();
     option.getOptionTests().add(optionTestRepository.findById(464L).get());
    optionRepository.save(option);


    }
}
