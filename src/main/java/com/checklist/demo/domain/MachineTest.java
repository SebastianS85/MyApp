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
@Table(name = "TESTS")
public class MachineTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "TEST_ID", unique = true)
    private Long id;
    @Column(name = "DESCRIPTION")
    private String description;


    @ManyToMany(mappedBy = "machineTestOptionList")
    private List<MachineOption> machineOptionList = new ArrayList<>();
}
