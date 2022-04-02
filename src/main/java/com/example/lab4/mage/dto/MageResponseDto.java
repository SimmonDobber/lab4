package com.example.lab4.mage.dto;

import com.example.lab4.tower.dto.TowerResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MageResponseDto {
    private Long id;
    private String name;
    private Integer level;
    private Long towerId;
}
