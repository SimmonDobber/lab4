package com.example.lab4.tower.dto;

import com.example.lab4.mage.dto.MageListDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TowerResponseDto {
    private Long id;
    private String name;
    private Integer height;
    private Collection<MageListDto> mages;
}
