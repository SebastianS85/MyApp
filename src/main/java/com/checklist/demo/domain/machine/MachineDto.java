package com.checklist.demo.domain.machine;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineDto {



    private String machineSerial;

    private String machineType;

    private List<MachineOptionDto> machineOptions = new ArrayList<>();

     private List<CreatedMachineTestDto>tests=new ArrayList<>();
}
