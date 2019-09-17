package com.checklist.demo.repository;

import com.checklist.demo.domain.MachineTest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TestRepository extends CrudRepository<MachineTest, Long> {

    @Override
    List<MachineTest> findAll();


    @Override
    Optional<MachineTest> findById(Long aLong);

    @Override
    MachineTest save(MachineTest test);

    @Override
    void deleteById(Long id);
}
