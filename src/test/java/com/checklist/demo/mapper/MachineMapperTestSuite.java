package com.checklist.demo.mapper;

import com.checklist.demo.domain.machine.Machine;
import com.checklist.demo.domain.machine.MachineDto;
import com.checklist.demo.domain.machine.MachineOption;
import com.checklist.demo.domain.machine.MachineOptionDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineMapperTestSuite {

    @Autowired
    MachineMapper machineMapper;
    @Mock
    OptionMapper optionMapper;


    @Test
    public void shouldMapToMachine() {
        //Given
        MachineDto machineDto = new MachineDto();
        machineDto.setMachineSerial("a1");
        machineDto.setMachineType("type1");
        List<MachineOptionDto> machineOptionDtos = new ArrayList<>();
        //When
        when(optionMapper.mapToMachineOptionList(machineOptionDtos)).thenReturn(new ArrayList<>());
        Machine machine = machineMapper.mapToMachine(machineDto);
        //Then
        assertEquals("a1", machine.getMachineSerial());
        assertEquals("type1", machine.getMachineType());
    }

    @Test
    public void shouldMapToMachineDto() {
        //Given
        MachineOption machineOption = new MachineOption(1L, "test", new ArrayList<>());
        Machine machine = new Machine("a1", "type1", new ArrayList<>());
        //When
        MachineDto machineDto = machineMapper.mapToMachineDto(machine);
        //Then
        assertEquals("a1", machineDto.getMachineSerial());
        assertEquals("type1", machineDto.getMachineType());
    }
    @Test
    public void shouldMapToDto(){
        Machine machine = new Machine("a1", "type1", new ArrayList<>());
        MachineDto testDto= machineMapper.mapToMachineDto(machine);

        System.out.println(testDto.getTests().size());
    }

}