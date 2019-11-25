package com.checklist.demo.repository;

import com.checklist.demo.domain.machine.MachineOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OptionRepository extends CrudRepository<MachineOption, Long> {


    @Override
    List<MachineOption> findAll();

    @Override
    Optional<MachineOption> findById(Long Long);

    @Override
    MachineOption save(MachineOption machineOption);

    @Override
    void deleteById(Long id);

}
