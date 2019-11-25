package com.checklist.demo.service;

import com.checklist.demo.domain.machine.CreatedMachineTest;
import com.checklist.demo.domain.machine.EmbeddedTestKey;
import com.checklist.demo.domain.machine.ResultEnum;
import com.checklist.demo.repository.CreatedMachineTestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreatedTestDbServiceTest {

    @InjectMocks
    CreatedTestDbService createdTestDbService;
    @Mock
    CreatedMachineTestRepository createdMachineTestRepository;

    @Test
    public void shouldReturnEmptyList() {
        //Given
        when(createdMachineTestRepository.findAll()).thenReturn(new ArrayList<>());
        //When
        //Then
        assertEquals(0, createdTestDbService.getAllCreatedTests().size());
    }

    @Test
    public void shouldReturnTest() {
        //Given
        CreatedMachineTest createdMachineTest = new CreatedMachineTest(new EmbeddedTestKey("a1", 1L, 1L), ResultEnum.DONE_OK, "test");
        when(createdMachineTestRepository.getCreatedMachineTestByEmbeddedTestKey(new EmbeddedTestKey("a1", 1L, 1L))).thenReturn(Optional.of(createdMachineTest));
        //When
        Optional<CreatedMachineTest> test = createdTestDbService.getMachineTest(new EmbeddedTestKey("a1", 1L, 1L));
        //Then
        assertEquals(ResultEnum.DONE_OK, test.get().getResultEnum());
    }

    @Test
    public void shouldSaveTest() {
        //Given
        CreatedMachineTest createdMachineTest = new CreatedMachineTest(new EmbeddedTestKey("a1", 1L, 1L), ResultEnum.DONE_NOK, "test");
        when(createdMachineTestRepository.save(createdMachineTest)).thenReturn(createdMachineTest);
        CreatedMachineTest test = createdMachineTestRepository.save(createdMachineTest);
        //When
        //Then
        assertEquals(new EmbeddedTestKey("a1", 1L, 1L), test.getEmbeddedTestKey());
        assertEquals(ResultEnum.DONE_NOK, test.getResultEnum());
    }

    @Test
    public void getMachineTestList() {

        List<CreatedMachineTest> tests = createdMachineTestRepository.findAll();
        System.out.println(tests.size());

    }
}