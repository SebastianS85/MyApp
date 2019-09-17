package com.checklist.demo.mapper;


import com.checklist.demo.domain.MachineTest;
import com.checklist.demo.domain.MachineTestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MachineTestMapper {

    @Autowired
    MachineMapper machineMapper;
    @Autowired
    OptionMapper optionMapper;

    public MachineTest mapToMachineTest(final MachineTestDto machineTestDto) {

        return new MachineTest(machineTestDto.getId(),machineTestDto.getDescription(),machineTestDto.getComment(),
                machineTestDto.getResult(),machineMapper.mapToMachineList(machineTestDto.getMachineList()),
                optionMapper.mapToMachineOptionList(machineTestDto.getOptionList()));

    }

    public List<MachineTestDto> mapToMachineTestDtoList(final List<MachineTest> machineTestList) {

        return machineTestList.stream()
                .map(machineTest -> new MachineTestDto(machineTest.getId(), machineTest.getDescription(),
                        machineTest.getComment(), machineTest.getResult(),
                        machineMapper.mapToMachineDtoList(machineTest.getMachineTList()),
                        optionMapper.mapToMachineOptionDtoList(machineTest.getMachineOptionList())))
                .collect(Collectors.toList());
    }

    public List<MachineTest> mapToMachineTestList(final List<MachineTestDto> machineTestDtoList) {

        return machineTestDtoList.stream()
                .map(machineTest -> new MachineTest(machineTest.getId(), machineTest.getDescription(),
                        machineTest.getComment(), machineTest.getResult(),
                        machineMapper.mapToMachineList(machineTest.getMachineList()),
                       optionMapper.mapToMachineOptionList(machineTest.getOptionList())))
                        .collect(Collectors.toList());


    }

}