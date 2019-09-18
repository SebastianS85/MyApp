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
    OptionMapper optionMapper;

    public MachineTest mapToMachineTest(final MachineTestDto machineTestDto) {

        return new MachineTest(machineTestDto.getId(), machineTestDto.getDescription(),
                optionMapper.mapToMachineOptionList(machineTestDto.getOptionList()));

    }

    public MachineTestDto mapToMachineTestDto(final MachineTest machineTest) {
        return new MachineTestDto(machineTest.getId(), machineTest.getDescription(),
                optionMapper.mapToMachineOptionDtoList(machineTest.getMachineOptionList()));
    }

    public List<MachineTestDto> mapToMachineTestDtoList(final List<MachineTest> machineTestList) {

        return machineTestList.stream()
                .map(machineTest -> new MachineTestDto(machineTest.getId(), machineTest.getDescription(),
                        optionMapper.mapToMachineOptionDtoList(machineTest.getMachineOptionList())))
                .collect(Collectors.toList());
    }

    public List<MachineTest> mapToMachineTestList(final List<MachineTestDto> machineTestDtoList) {

        return machineTestDtoList.stream()
                .map(machineTest -> new MachineTest(machineTest.getId(), machineTest.getDescription(),
                        optionMapper.mapToMachineOptionList(machineTest.getOptionList())))
                .collect(Collectors.toList());


    }

}