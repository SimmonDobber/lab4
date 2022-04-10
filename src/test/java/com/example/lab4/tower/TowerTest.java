package com.example.lab4.tower;

import com.example.lab4.tower.dto.TowerCreateDto;
import com.example.lab4.tower.dto.TowerResponseDto;
import org.junit.Test;

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



    void setup() {
        towerRepository = new TowerRepositoryTest();
        towerService = new TowerService(towerRepository);
    }

}
