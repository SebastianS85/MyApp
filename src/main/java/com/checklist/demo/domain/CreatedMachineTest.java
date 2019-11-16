package com.checklist.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@AllArgsConstructor
@Data
@Entity
public class CreatedMachineTest {

    @EmbeddedId
    EmbeddedTestKey embeddedTestKey;

    @Column(name = "RESULT")
    private ResultEnum resultEnum;

    @Column
    private String comment;

    public CreatedMachineTest() {
        resultEnum=ResultEnum.NOT_DONE;
    }
}
