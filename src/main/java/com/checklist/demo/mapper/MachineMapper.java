package com.checklist.demo.mapper;

import com.checklist.demo.domain.machine.Machine;
import com.checklist.demo.domain.machine.MachineDto;
import com.checklist.demo.service.CreatedTestServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class MachineMapper {
    @Autowired
    private OptionMapper optionMapper;

    @Autowired
    private CreatedTestServeService serveService;
    @Autowired
    private CreatedTestMapper createdTestMapper;

    public MachineDto mapToMachineDto(Machine machine) {
        return new MachineDto(machine.getMachineSerial(), machine.getMachineType(),
                optionMapper.mapToMachineOptionDtoList(machine.getMachineOptions()),
                createdTestMapper.mapToCreatedMachineTestDtoList(serveService.getTests(machine.getMachineSerial())));
    }

    public Machine mapToMachine(MachineDto machineDto) {
        return new Machine(machineDto.getMachineSerial(), machineDto.getMachineType(),
                optionMapper.mapToMachineOptionList(machineDto.getMachineOptions()));
    }

    public List<MachineDto> mapToMachineDtoList(List<Machine> machineList) {
        return machineList.stream()
                .map(machine -> new MachineDto(machine.getMachineSerial(), machine.getMachineType(),
                        optionMapper.mapToMachineOptionDtoList(machine.getMachineOptions()), createdTestMapper
                        .mapToCreatedMachineTestDtoList(serveService.getTests(machine.getMachineSerial()))
                )).collect(Collectors.toList());

    }

}
