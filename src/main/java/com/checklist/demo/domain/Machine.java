package com.checklist.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "MACHINE")
public class Machine {

    @Id
    @Column(name ="MACHINE_SERIAL")
    private String machineSerialNumber;

    @Column(name = "MACHINE_TYPE")
    private String machineType;


    @ManyToMany
    @JoinTable(
            name = "MACHINE_OPTION_LIST",
            joinColumns = @JoinColumn(name = "MACHINE_SERIAL"),
            inverseJoinColumns = @JoinColumn(name = "OPTION_ID")
    )
    private List<MachineOption> optionList=new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "MACHINE_TEST_LIST",
            joinColumns = @JoinColumn(name = "MACHINE_SERIAL"),
            inverseJoinColumns = @JoinColumn(name = "TEST_ID")
    )
    private List<MachineTest> testList=new ArrayList<>();
}
