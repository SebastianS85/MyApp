package com.checklist.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RequestChecklist {

    private  Long machineId;

    private List<Long> optionId;
}
