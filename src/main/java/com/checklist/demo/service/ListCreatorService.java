package com.checklist.demo.service;

import com.checklist.demo.domain.CreatedTest;
import com.checklist.demo.domain.Machine;
import com.checklist.demo.domain.MachineTest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListCreatorService {

    public List<CreatedTest> createdTestList(List<MachineTest> testList, Machine machine) {

        return testList.stream().map(t ->
                new CreatedTest(null, t.getDescription(), false, machine)).
                collect(Collectors.toList());
    }
}



