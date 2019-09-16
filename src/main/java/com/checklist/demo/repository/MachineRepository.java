package com.checklist.demo.repository;

import com.checklist.demo.domain.Machine;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MachineRepository extends CrudRepository<Machine, String> {

    @Override
    List<Machine> findAll();

    Machine findByMachineSerialNumber(String serialNumber);

    @Override
    Machine save(Machine machine);


    void deleteByMachineSerialNumber(String serialNumber);


}
