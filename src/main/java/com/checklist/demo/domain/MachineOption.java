package com.checklist.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


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


    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "OPTION_TEST_LIST",
            joinColumns = @JoinColumn(name = "OPTION_ID"),
            inverseJoinColumns = @JoinColumn(name = "TEST_ID")
    )
     private List<MachineTest>machineTestOptionList=new ArrayList<>();


}

