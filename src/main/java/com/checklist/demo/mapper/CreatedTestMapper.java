package com.checklist.demo.mapper;

import com.checklist.demo.domain.machine.CreatedMachineTest;
import com.checklist.demo.domain.machine.CreatedMachineTestDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreatedTestMapper {

    public CreatedMachineTest mapToCreatedTestDto(CreatedMachineTestDto createdMachineTestDto) {
        return new CreatedMachineTest(createdMachineTestDto.getEmbeddedTestKey(), createdMachineTestDto.getResultEnum(), createdMachineTestDto.getComment());
    }

    public CreatedMachineTestDto mapToCreatedMachineTestDto(CreatedMachineTest createdMachineTest) {
        return new CreatedMachineTestDto(createdMachineTest.getEmbeddedTestKey(), createdMachineTest.getResultEnum(),
                createdMachineTest.getComment());
    }

    public List<CreatedMachineTestDto> mapToCreatedMachineTestDtoList(List<CreatedMachineTest> theList) {
        return theList.stream().map(test -> new CreatedMachineTestDto(test.getEmbeddedTestKey(), test.getResultEnum(), test.getComment()))
                .collect(Collectors.toList());
    }



}