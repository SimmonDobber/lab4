package com.example.lab4.mage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MageLevelThresholdAndTowerDto {
    private Integer levelThreshold;
    private Long towerId;
}

