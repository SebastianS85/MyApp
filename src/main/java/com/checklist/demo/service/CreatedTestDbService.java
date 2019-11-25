package com.checklist.demo.service;
import com.checklist.demo.domain.machine.CreatedMachineTest;
import com.checklist.demo.domain.machine.EmbeddedTestKey;
import com.checklist.demo.repository.CreatedMachineTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreatedTestDbService {
    @Autowired
    CreatedMachineTestRepository createdMachineTestRepository;

    public List<CreatedMachineTest> getAllCreatedTests() {
        return createdMachineTestRepository.findAll();
    }

    public CreatedMachineTest save(CreatedMachineTest createdMachineTest) {
        return createdMachineTestRepository.save(createdMachineTest);
    }

    public Optional<CreatedMachineTest>getMachineTest(EmbeddedTestKey embeddedTestKey){
        return createdMachineTestRepository.getCreatedMachineTestByEmbeddedTestKey(embeddedTestKey);
    }

    public void deleteCreatedTest(EmbeddedTestKey embeddedTestKey) {
        createdMachineTestRepository.deleteByEmbeddedTestKey(embeddedTestKey);
    }

}
