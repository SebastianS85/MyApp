package com.checklist.demo.service;

import com.checklist.demo.domain.OptionTest;
import com.checklist.demo.repository.OptionTestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TestDBService {

    private OptionTestRepository optionTestRepository;

    public List<OptionTest> getAllTests() {
        return optionTestRepository.findAll();
    }

    public OptionTest save(OptionTest optionTest) {
        return optionTestRepository.save(optionTest);
    }

    public void deleteOptionTest(Long id) {
        optionTestRepository.deleteById(id);
    }

    public Optional<OptionTest> getOptionTest(Long id) {
        return optionTestRepository.findById(id);
    }
}
