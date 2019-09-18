package com.checklist.demo.mapper;

import com.checklist.demo.domain.CreatedTest;
import com.checklist.demo.domain.CreatedTestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CreatedTestMapper {
    @Autowired
    MachineMapper machineMapper;
    @Autowired
    MachineTestMapper machineTestMapper;

    public CreatedTest mapToCreatedTest(CreatedTestDto createdTestDto) {

        return new CreatedTest(createdTestDto.getId(), createdTestDto.getTestComment(),
                createdTestDto.isTestResult(), machineMapper.mapToMachine(createdTestDto.getMachine()));
    }

    public CreatedTestDto mapToCreatedTestDto(CreatedTest createdTest) {

        return new CreatedTestDto(createdTest.getId(), createdTest.getTestComment(),
                createdTest.isTestResult(), machineMapper.mapToMachineDto(createdTest.getMachine()));
    }

    public List<CreatedTest> mapToCreatedTestList(List<CreatedTestDto> createdTestDtoList) {

        return createdTestDtoList.stream().map(createdTestDto -> new CreatedTest(createdTestDto.getId(),
                createdTestDto.getTestComment(), createdTestDto.isTestResult(), machineMapper.mapToMachine(
                createdTestDto.getMachine()))).collect(Collectors.toList());

    }

    public List<CreatedTestDto> mapToCreatedTestDtoList(List<CreatedTest> createdTestList) {
        return createdTestList.stream().map(createdTest -> new CreatedTestDto(createdTest.getId(),
                createdTest.getTestComment(), createdTest.isTestResult(), machineMapper.mapToMachineDto(
                createdTest.getMachine()))).collect(Collectors.toList());
    }


}
