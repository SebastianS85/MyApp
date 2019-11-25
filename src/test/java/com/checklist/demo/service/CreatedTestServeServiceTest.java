package com.checklist.demo.service;

import com.checklist.demo.domain.machine.CreatedMachineTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatedTestServeServiceTest {

    @Autowired
    CreatedTestServeService createdTestServeService;
    @Test
    public void getTest() {
        //given
        //when
        List<CreatedMachineTest>tests= createdTestServeService.getTests("a2");

        //then
        assertEquals(36,tests.size());

    }


}