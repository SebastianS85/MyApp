package com.checklist.demo.domain.machine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
   private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TESTS_OPTIONS")
    private List<OptionTest>optionTests=new ArrayList<>();


}

