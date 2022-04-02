package com.example.lab4.mage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MageUpdateDto {
    private Long id;
    private String name;
    private Integer level;
    private Long towerId;
}
