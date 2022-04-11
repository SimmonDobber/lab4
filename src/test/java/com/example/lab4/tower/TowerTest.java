package com.example.lab4.tower;

import com.example.lab4.tower.dto.TowerCreateDto;
import com.example.lab4.tower.dto.TowerResponseDto;
import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

import static org.junit.Assert.*;

public class TowerTest {

    private TowerRepositoryTest towerRepository;
    private TowerService towerService;

    @Test
    public void should_add_tower() {
        // given
        setup();
        TowerCreateDto dto = TowerCreateDto.builder()
                .name("testName")
                .height(1)
                .build();

        // when
        TowerResponseDto towerResponseDto = towerService.addOne(dto);

        // then
        assertNotNull(towerResponseDto.getId());
        assertNotNull(towerRepository.getTowers().get(towerResponseDto.getId()));
        TowerEntity entity = towerRepository.getTowers().get(towerResponseDto.getId());
        assertEquals(dto.getName(), entity.getName());
        assertEquals(dto.getHeight(), entity.getHeight());
    }

    @Test
    public void should_throw_illegal_argument_exception_on_delete_nonexistent_object() {
        // given
        setup();
        // then
        assertThrows(IllegalArgumentException.class, () -> towerService.deleteById(2137L));
    }

    @Test
    public void should_get_tower(){
        //given
        setup();
        TowerCreateDto dto = TowerCreateDto.builder()
                .name("testName")
                .height(1)
                .build();
        towerService.addOne(dto);

        //when

        TowerResponseDto  towerResponseDto = towerService.findById(1L);

        //then

        assertNotNull(towerResponseDto);
        assertEquals(Optional.of(1L), Optional.of(towerResponseDto.getId()));
        assertEquals(dto.getName(), towerResponseDto.getName());
        assertEquals(dto.getHeight(), towerResponseDto.getHeight());
    }

    @Test
    public void should_get_all_towers(){
        //given
        setup();

        LinkedList<TowerResponseDto> dtoS = new LinkedList<>();
        TowerCreateDto dto = TowerCreateDto.builder()
                .name("testName")
                .height(1)
                .build();
        dtoS.add(towerService.addOne(dto));
        
        dto = TowerCreateDto.builder()
                .name("testName2")
                .height(2)
                .build();
        dtoS.add(towerService.addOne(dto));
        
        //when
        
        Collection<TowerResponseDto> towerResponseDtoS = towerService.findAll();
        
        //then

        assertNotNull(towerResponseDtoS);
        assertEquals(towerResponseDtoS.size(), dtoS.size());
        assertTrue(towerResponseDtoS.containsAll(dtoS) && dtoS.containsAll(towerResponseDtoS));
    }

    void setup() {
        towerRepository = new TowerRepositoryTest();
        towerService = new TowerService(towerRepository);
    }

}
