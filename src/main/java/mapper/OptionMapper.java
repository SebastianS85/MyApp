package mapper;


import com.checklist.demo.domain.MachineOption;
import com.checklist.demo.domain.MachineOptionDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OptionMapper {


    private MachineMapper machineMapper;

    public MachineOption mapToOption(final MachineOptionDto machineOptionDto) {

        return new MachineOption(machineOptionDto.getId(), machineOptionDto.getDescription(),
                machineMapper.mapToMachineList(machineOptionDto.getMachineList()));
    }

    public MachineOptionDto mapToMachineOptionDto(final MachineOption machineOption) {

        return new MachineOptionDto(machineOption.getId(), machineOption.getDescription(),
                machineMapper.mapToMachineDtoList(machineOption.getMachineList()));
    }

    public List<MachineOptionDto> mapToMachineOptionDtoList(final List<MachineOption> machineOptionList) {

        return machineOptionList.stream()
                .map(machineOption -> new MachineOptionDto(machineOption.getId(), machineOption.getDescription(),
                        machineMapper.mapToMachineDtoList(machineOption.getMachineList())))
                .collect(Collectors.toList());

    }

    public List<MachineOption> mapToMachineOptionList(final List<MachineOptionDto> machineOptionDtoList) {
        return machineOptionDtoList.stream()
                .map(machineOptionDto -> new MachineOption(machineOptionDto.getId(), machineOptionDto.getDescription(),
                        machineMapper.mapToMachineList(machineOptionDto.getMachineList())))
                        .collect(Collectors.toList());
    }
}
