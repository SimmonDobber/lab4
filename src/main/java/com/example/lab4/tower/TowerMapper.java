package com.example.lab4.tower;

import com.example.lab4.mage.MageMapper;
import com.example.lab4.tower.dto.TowerCreateDto;
import com.example.lab4.tower.dto.TowerResponseDto;

import java.util.Collection;
import java.util.stream.Collectors;

public class TowerMapper
{
    public static Collection<TowerResponseDto> toDto(Collection<TowerEntity> entities){
        return entities.stream()
                .map(entity -> toDto(entity))
                .collect(Collectors.toList());
    }

    public static TowerResponseDto toDto(TowerEntity entity){
        return TowerResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .height(entity.getHeight())
                .mages(MageMapper.toDto(entity.getMages()))
                .build();
    }

    public static TowerEntity toEntity(TowerCreateDto dto){
        return TowerEntity.builder()
                .name(dto.getName())
                .height(dto.getHeight())
                .build();
    }

    private TowerMapper() {}
}
