package com.checklist.demo.domain.machine;

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
    @Column
    private String machineSerial;


    @Column(name = "MACHINE_TYPE")
    private String machineType;

    @OneToMany
    List<MachineOption> machineOptions = new ArrayList<>();


}