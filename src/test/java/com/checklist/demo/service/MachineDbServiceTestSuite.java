package com.checklist.demo.service;

import com.checklist.demo.repository.CreatedMachineTestRepository;
import com.checklist.demo.repository.MachineRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MachineDbServiceTestSuite {

    @InjectMocks
    MachineDbService machineDbService;
    @Mock
    MachineRepository machineRepository;

    @Test
    public void shouldReturnEmptyList(){
        //Given
        when(machineRepository.findAll()).thenReturn(new ArrayList<>());
        //When
        //Then
        assertEquals(0,machineDbService.getAllMachines().size());
    }

}