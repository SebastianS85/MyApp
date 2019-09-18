package com.checklist.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MachineTestDto {

    private Long id;

    private String description;


    private List<MachineOptionDto> optionList = new ArrayList<>();

}
