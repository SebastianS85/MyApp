package com.checklist.demo.mapper;

import com.checklist.demo.domain.machine.OptionTest;
import com.checklist.demo.domain.machine.OptionTestDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OptionTestMapper {

    public OptionTest mapToOptionTest(OptionTestDto optionTestDto) {
        return new OptionTest(optionTestDto.getId(), optionTestDto.getDescription());
    }

    public OptionTestDto mapToOptionTestDto(OptionTest optionTest) {
        return new OptionTestDto(optionTest.getId(), optionTest.getDescription());
    }

    List<OptionTestDto> mapToOptionTestDtoList(List<OptionTest> theList) {
        return theList.stream()
                .map(optionTest -> new OptionTestDto(optionTest.getId(), optionTest.getDescription())).collect(Collectors.toList());

    }

    List<OptionTest> mapToOptionTestList(List<OptionTestDto> theList) {
        return theList.stream()
                .map(optionTest -> new OptionTest(optionTest.getId(), optionTest.getDescription())).collect(Collectors.toList());

    }
}
