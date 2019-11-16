package com.checklist.demo.controller;

import com.checklist.demo.domain.*;
import com.checklist.demo.mapper.MachineMapper;
import com.checklist.demo.mapper.OptionMapper;
import com.checklist.demo.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class MachineController {

    @Autowired
    private MachineMapper machineMapper;

    @Autowired
    private OptionMapper optionMapper;
    @Autowired
    MachineRepository machineRepository;


    @GetMapping(value = "getAllMachines",produces ="application/json" )
    public List<MachineDto>getAllMachines(){
        return machineMapper.mapToMachineDtoList(machineRepository.findAll());
    }


    @RequestMapping(method = RequestMethod.GET, value = "getMachine")
      public Optional<Machine> getMachine(@RequestParam  String machineSerial){
        return machineRepository.findById(machineSerial);
   }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteMachine")
    public void deleteMachine(@RequestParam String machineSerial) {
        machineRepository.deleteByMachineSerial(machineSerial);
    }

}
