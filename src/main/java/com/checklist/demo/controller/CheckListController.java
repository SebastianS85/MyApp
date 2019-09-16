package com.checklist.demo.controller;

import com.checklist.demo.domain.*;
import mapper.MachineMapper;
import mapper.OptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CheckListController {


    private MachineMapper machineMapper;

    private OptionMapper optionMapper;

    @GetMapping(value = "checklist",consumes = "application/json",produces ="application/json" )
   public List<TestDto> getCheckList(@RequestBody RequestChecklist requestChecklist) {
        List<TestDto> list= new ArrayList<>();


        return list;
   }

    @RequestMapping(method = RequestMethod.GET, value = "machine")
      public Machine getMachine(){
        System.out.println("ddddd");
        MachineDto machine1= new MachineDto();
        machine1.setMachineSerialNumber("a1");
        machine1.setMachineType("a2");
        MachineOptionDto optiondto1=new MachineOptionDto();
        optiondto1.setId(1L);
        optiondto1.setDescription("desc");
        optiondto1.getMachineList().add(machine1);
        machine1.getOptionList().add(optiondto1);

       Machine machine=machineMapper.mapToMachine(machine1);
        System.out.println(machine);
//
        return null;
   }
}
