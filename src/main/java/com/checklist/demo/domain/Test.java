package com.checklist.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TESTS")
public class Test {

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
}
