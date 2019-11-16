package com.checklist.demo.controller;

import com.checklist.demo.domain.OptionTest;
import com.checklist.demo.repository.OptionTestRepository;
import com.checklist.demo.service.TestDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/test")
public class OptionTestController {



    @Autowired
    TestDBService testDBService;
    @Autowired
    OptionTestRepository testRepository;

    @GetMapping(value = "getAllTests",produces = "application/json")
    public List<OptionTest> getAllTests() {

        return testRepository.findAll();
    }


    @RequestMapping(method = RequestMethod.POST,value = "addTest",consumes = APPLICATION_JSON_VALUE)
    public void createTest(@RequestBody OptionTest optionTest) {
        testRepository.save(optionTest);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{testId}")
    public void deleteTest(@PathVariable Long testId) {
        testRepository.deleteById(testId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTest/{testId}")
    public Optional<OptionTest> editTest(@PathVariable Long testId) {
        System.out.println(testId);
       return  testRepository.findById(testId);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public OptionTest updateTest(@RequestBody OptionTest optionTest) {
        return testRepository.save(optionTest);
    }

}




