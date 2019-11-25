package com.checklist.demo.mapper;

import com.checklist.demo.domain.machine.MachineOption;
import com.checklist.demo.domain.machine.MachineOptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OptionMapper {
    @Autowired
    OptionTestMapper optionTestMapper;

    public MachineOption mapToMachineOption(MachineOptionDto machineOptionDto) {
        return new MachineOption(machineOptionDto.getId(), machineOptionDto.getDescription(),
                optionTestMapper.mapToOptionTestList(machineOptionDto.getOptionTests()));
    }

    public MachineOptionDto mapToMachineOptionDto(MachineOption machineOption) {
        return new MachineOptionDto(machineOption.getId(), machineOption.getDescription()
                , optionTestMapper.mapToOptionTestDtoList(machineOption.getOptionTests()));
    }

    public List<MachineOptionDto> mapToMachineOptionDtoList(List<MachineOption> machineOptions) {
        return machineOptions.stream()
                .map(machineOption -> new MachineOptionDto(machineOption.getId(), machineOption.getDescription(),
                        optionTestMapper.mapToOptionTestDtoList(machineOption.getOptionTests()))).collect(Collectors.toList());

    }

    public List<MachineOption> mapToMachineOptionList(List<MachineOptionDto> machineOptionsDto) {
        return machineOptionsDto.stream()
                .map(machineOption -> new MachineOption(machineOption.getId(), machineOption.getDescription(),
                        optionTestMapper.mapToOptionTestList(machineOption.getOptionTests()))).collect(Collectors.toList());
    }
}
