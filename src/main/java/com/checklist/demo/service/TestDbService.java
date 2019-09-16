package com.checklist.demo.service;


import com.checklist.demo.domain.Test;
import com.checklist.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestDbService {

    @Autowired
    private TestRepository testRepository;


    public List<Test> getAllOptions() {
        return testRepository.findAll();
    }

    public Test saveTest(Test test) {
        return testRepository.save(test);
    }

    public Optional<Test> getMachineOpion(Long id) {
        return testRepository.findById(id);
    }

    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }
}
