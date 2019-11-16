package com.checklist.demo.repository;

import com.checklist.demo.domain.Machine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MachineRepository extends CrudRepository<Machine, String> {

    @Override
    List<Machine> findAll();

    @Override
    Optional<Machine> findById(String serial);


    @Override
    Machine save(Machine machine);

    @Transactional
    void deleteByMachineSerial(String serialNumber);


}
