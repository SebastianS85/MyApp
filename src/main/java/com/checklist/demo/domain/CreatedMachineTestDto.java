package com.checklist.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedMachineTestDto {

    EmbeddedTestKey embeddedTestKey;

    private ResultEnum resultEnum;


    private String comment;



}
