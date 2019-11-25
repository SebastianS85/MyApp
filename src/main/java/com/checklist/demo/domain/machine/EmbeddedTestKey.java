package com.checklist.demo.domain.machine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmbeddedTestKey implements Serializable {



    private String machineSerial;

    private Long option_id;

    private Long test_id;




}
