package com.checklist.demo.mapper;
import com.checklist.demo.domain.machine.MachineOption;
import com.checklist.demo.domain.machine.MachineOptionDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionMapperTestSuite {

    @Autowired
    OptionMapper optionMapper;

    @Test
    public void shouldMapToOptionDto() {
        //Given
        MachineOption machineOption = new MachineOption(1L, "tst", new ArrayList<>());
        //When
        MachineOptionDto dto = optionMapper.mapToMachineOptionDto(machineOption);
        //Then

        assertEquals("tst", dto.getDescription());
        assertEquals(0, dto.getOptionTests().size());

    }

    @Test
    public void shouldMapToOption() {
        //Given
        MachineOptionDto machineOptionDto = new MachineOptionDto(1L, "tst", new ArrayList<>());
        //When
        MachineOption option = optionMapper.mapToMachineOption(machineOptionDto);
        //Then


        assertEquals("tst", option.getDescription());
        assertEquals(0, option.getOptionTests().size());

    }

}