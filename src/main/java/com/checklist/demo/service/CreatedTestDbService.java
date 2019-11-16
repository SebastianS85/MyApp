package com.checklist.demo.service;
import com.checklist.demo.domain.CreatedMachineTest;
import com.checklist.demo.domain.EmbeddedTestKey;
import com.checklist.demo.repository.CreatedMachineTestRepository;
import jdk.nashorn.internal.runtime.options.Option;
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
