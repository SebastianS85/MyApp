package com.checklist.demo.repository;

import com.checklist.demo.domain.OptionTest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OptionTestRepository extends CrudRepository<OptionTest, Long> {

    @Override
    List<OptionTest>findAll();
    @Override
    OptionTest save(OptionTest optionTest);

    @Override
    Optional<OptionTest> findById(Long id);

    @Override
    void deleteById(Long id);
}
