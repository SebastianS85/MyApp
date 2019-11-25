package com.checklist.demo.mapper;

import com.checklist.demo.domain.machine.CreatedMachineTest;
import com.checklist.demo.domain.machine.CreatedMachineTestDto;
import com.checklist.demo.domain.machine.EmbeddedTestKey;
import com.checklist.demo.domain.machine.ResultEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatedTestMapperTestSuite {
    @Autowired
    CreatedTestMapper createdTestMapper;
    @Test
    public void shouldMapToDto(){
        //Given
        CreatedMachineTest createdMachineTest=new CreatedMachineTest
                (new EmbeddedTestKey("a1",2L,3L), ResultEnum.NOT_DONE,"test");
        //When
        CreatedMachineTestDto dto=createdTestMapper.mapToCreatedMachineTestDto(createdMachineTest);
        //Then
        assertEquals(new EmbeddedTestKey("a1",2L,3L),dto.getEmbeddedTestKey());
        assertEquals(ResultEnum.NOT_DONE,dto.getResultEnum());
        assertEquals("test",dto.getComment());
    }


}