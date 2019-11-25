package com.checklist.demo.controller;

import com.checklist.demo.domain.machine.MachineOption;
import com.checklist.demo.domain.machine.MachineOptionDto;
import com.checklist.demo.mapper.OptionMapper;
import com.checklist.demo.repository.OptionRepository;
import com.checklist.demo.repository.OptionTestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/option")
public class MachineOptionController {

    Logger logger = LoggerFactory.getLogger(MachineOptionController.class);

    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private OptionMapper optionMapper;
    @Autowired
    private OptionTestRepository optionTestRepository;


    @GetMapping(value = "getAllOptions",produces ="application/json" )
    public List<MachineOptionDto> getAllOptions(){
        return optionMapper.mapToMachineOptionDtoList(optionRepository.findAll());
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{optionId}")
    public void deleteTest(@PathVariable Long optionId) {
        optionRepository.deleteById(optionId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOption/{optionId}")
    public Optional<MachineOption> editTest(@PathVariable Long optionId) {
        System.out.println(optionId);
        return  optionRepository.findById(optionId);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public MachineOption updateTest(@RequestBody MachineOption machineOption) {
        return optionRepository.save(machineOption);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addTest/{optionId},{testId}")
    public MachineOption addTest(@PathVariable Long optionId, @PathVariable Long testId) {
        logger.info(optionId +" "+testId);
       MachineOption option= optionRepository.findById(optionId).get();
       option.getOptionTests().add((optionTestRepository.findById(testId).get()));
        return  optionRepository.save(option);
    }
}
