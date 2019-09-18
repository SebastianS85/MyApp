package com.checklist.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CreatedTest {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "TEST_ID", unique = true)
    private Long id;


    @Column(name = "COMMENT")
    private String TestComment;

    @Column(name = "TEST_RESULT")
    private boolean testResult;

    @ManyToOne
    @JoinColumn(name = "MACHINE_SERIAL")
    private Machine machine;


}
