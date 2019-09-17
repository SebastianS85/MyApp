package com.checklist.demo.controller;

import com.checklist.demo.domain.*;
import com.checklist.demo.mapper.MachineMapper;
import com.checklist.demo.mapper.OptionMapper;
import com.checklist.demo.service.MachineDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "*")
public class CheckListController {

    @Autowired
    private MachineMapper machineMapper;

    @Autowired
    private OptionMapper optionMapper;
    @Autowired
    private MachineDbService machineDbService;


    @GetMapping(value = "checklist",consumes = "application/json",produces ="application/json" )
   public List<MachineTestDto> getCheckList(@RequestBody RequestChecklist requestChecklist) {
        List<MachineTestDto> list= new ArrayList<>();


        return list;
   }

    @RequestMapping(method = RequestMethod.GET, value = "machine")
      public Machine getMachine(){


        return null;
   }
    @RequestMapping(method = RequestMethod.POST,value = "add/Machine",consumes = APPLICATION_JSON_VALUE)
    public void createMachine(@RequestBody MachineDto machineDto) {
        machineDbService.saveMachine(machineMapper.mapToMachine(machineDto));
    }

}
