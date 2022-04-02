package com.example.lab4.tower;

import com.example.lab4.mage.MageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "towers")
public class TowerEntity {

    @Id
    @SequenceGenerator(name = "towers_id_s", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "towers_id_s")
    private Long id;

    private String name;

    private Integer height;

    @OneToMany(mappedBy = "tower")
    @Builder.Default
    Collection<MageEntity> mages = new LinkedList<>();

}
