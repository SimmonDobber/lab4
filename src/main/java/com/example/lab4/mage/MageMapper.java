package com.example.lab4.mage;

import com.example.lab4.mage.dto.MageCreateDto;
import com.example.lab4.mage.dto.MageListDto;
import com.example.lab4.mage.dto.MageResponseDto;

import java.util.Collection;
import java.util.stream.Collectors;

public class MageMapper {

    public static Collection<MageListDto> toDto(Collection<MageEntity> entities) {
        return entities.stream()
                .map(entity -> toListDto(entity))
                .collect(Collectors.toList());
    }

    public static MageListDto toListDto(MageEntity entity) {
        return MageListDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .level(entity.getLevel())
                .build();
    }

    public static MageResponseDto toDto(MageEntity entity) {
        return MageResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .level(entity.getLevel())
                .towerId(entity.getTower().getId())
                .build();
    }

    public static MageEntity toEntity(MageCreateDto dto) {
        return MageEntity.builder()
                .name(dto.getName())
                .level(dto.getLevel())
                .build();
    }

    private MageMapper() {}
}
