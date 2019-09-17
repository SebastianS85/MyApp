package com.checklist.demo.domain;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MachineDto {

    private String machineSerialNumber;


    private String machineType;


    private List<MachineOptionDto> optionList = new ArrayList<>();

    private List<MachineTestDto> testList=new ArrayList<>();

}
