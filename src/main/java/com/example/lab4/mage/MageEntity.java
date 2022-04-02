package com.example.lab4.mage;

import com.example.lab4.tower.TowerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "mages")
public class MageEntity {

    @Id
    @SequenceGenerator(name = "mages_id_s", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mages_id_s")
    private Long id;

    private String name;

    private Integer level;

    @ManyToOne
    @JoinColumn(name = "tower_id")
    private TowerEntity tower;

}
