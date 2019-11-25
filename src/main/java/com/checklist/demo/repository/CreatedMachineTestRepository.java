package com.checklist.demo.repository;

import com.checklist.demo.domain.machine.CreatedMachineTest;
import com.checklist.demo.domain.machine.EmbeddedTestKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreatedMachineTestRepository extends CrudRepository<CreatedMachineTest, EmbeddedTestKey> {


    @Override
    List<CreatedMachineTest> findAll();

    @Override
    CreatedMachineTest save(CreatedMachineTest createdMachineTest);


    void deleteByEmbeddedTestKey(EmbeddedTestKey embeddedTestKey);


    public Optional<CreatedMachineTest> getCreatedMachineTestByEmbeddedTestKey(EmbeddedTestKey embeddedTestKey);

    public List<CreatedMachineTest>findCreatedMachineTestByEmbeddedTestKey_MachineSerial(String machineSerial);


}
