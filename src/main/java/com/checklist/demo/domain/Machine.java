package com.checklist.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.transaction.annotation.Transactional;

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


    @ManyToMany(fetch = FetchType.EAGER )
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "MACHINE_OPTION_LIST",
            joinColumns = @JoinColumn(name = "MACHINE_SERIAL"),
            inverseJoinColumns = @JoinColumn(name = "OPTION_ID")
    )
    private List<MachineOption> optionList=new ArrayList<>();


    @OneToMany(
            targetEntity = CreatedTest.class,
            mappedBy = "machine",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    private List<CreatedTest> createdTestList=new ArrayList<>();



}
