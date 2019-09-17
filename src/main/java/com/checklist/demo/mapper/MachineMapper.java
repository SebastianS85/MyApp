package com.checklist.demo.mapper;
import com.checklist.demo.domain.Machine;
import com.checklist.demo.domain.MachineDto;
import com.checklist.demo.domain.MachineOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;


@Component
public class MachineMapper {

    @Autowired
    private OptionMapper optionMapper;
    @Autowired
    private MachineTestMapper machineTestMapper;



    public Machine mapToMachine(final MachineDto machineDto) {

        return new Machine(machineDto.getMachineSerialNumber()
                , machineDto.getMachineType(),
                optionMapper.mapToMachineOptionList(machineDto.getOptionList()),
                machineTestMapper.mapToMachineTestList(machineDto.getTestList()));

    }

    public MachineDto mapToMachineDto(final Machine machine) {
        return new MachineDto(machine.getMachineSerialNumber(), machine.getMachineType(),
                optionMapper.mapToMachineOptionDtoList(machine.getOptionList()),
                machineTestMapper.mapToMachineTestDtoList(machine.getTestList()));





    }

    public List<MachineDto> mapToMachineDtoList(final List<Machine> machineList) {
        return machineList.stream()
                .map(machine -> new MachineDto(machine.getMachineSerialNumber(), machine.getMachineType(),
                       optionMapper.mapToMachineOptionDtoList(machine.getOptionList()),
                        machineTestMapper.mapToMachineTestDtoList(machine.getTestList())))
                .collect(Collectors.toList());
    }

    public List<Machine> mapToMachineList(final List<MachineDto> machineDtoList) {

        return machineDtoList.stream()
                .map(machineDto -> new Machine(machineDto.getMachineSerialNumber(), machineDto.getMachineType(),
                        optionMapper.mapToMachineOptionList(machineDto.getOptionList()),
                        machineTestMapper.mapToMachineTestList(machineDto.getTestList())))
                .collect(Collectors.toList());
    }


}
