package com.checklist.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedTestDto {

    private Long id;


    private String TestComment;

    private boolean testResult;

    private MachineDto machine;
}
