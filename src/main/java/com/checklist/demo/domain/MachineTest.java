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
@Table(name = "TESTS")
public class MachineTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "TEST_ID", unique = true)
    private Long id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "COMMENT")
    private String comment;
    @Column(name = "RESULT")
    private String result;

    @ManyToMany(mappedBy = "machineTestOptionList")
    private List<Machine> machineList = new ArrayList<>();



    @ManyToMany
    @JoinTable(
            name = "MACHINE_TEST_OPTION_LIST",
            joinColumns = @JoinColumn(name = "TEST_ID"),
            inverseJoinColumns = @JoinColumn(name = "OPTION_ID")
    )
    private List<MachineOption> machineOptionList = new ArrayList<>();
}
