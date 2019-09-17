package com.checklist.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "OPTIONS")
public class MachineOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "OPTION_ID", unique = true)
    private Long id;


    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(mappedBy = "optionList")
    private List<Machine>machineList= new ArrayList<>();


    @ManyToMany(mappedBy = "machineTList")
   private List<MachineTest>machineTestOptionList=new ArrayList<>();


}

