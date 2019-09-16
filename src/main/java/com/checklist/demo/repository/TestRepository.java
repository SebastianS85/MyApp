package com.checklist.demo.repository;

import com.checklist.demo.domain.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TestRepository extends CrudRepository<Test, Long> {

    @Override
    List<Test> findAll();


    @Override
    Optional<Test> findById(Long aLong);

    @Override
    Test save(Test test);

    @Override
    void deleteById(Long id);
}
