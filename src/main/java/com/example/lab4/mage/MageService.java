package com.example.lab4.mage;

import com.example.lab4.mage.dto.*;
import com.example.lab4.tower.TowerEntity;
import com.example.lab4.tower.TowerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static com.example.lab4.mage.MageMapper.toDto;
import static com.example.lab4.mage.MageMapper.toEntity;

@Transactional
@AllArgsConstructor
public class MageService {

    private final MageRepository mageRepository;

    private final TowerRepository towerRepository;

    public Collection<MageListDto> findAll() {
        Collection<MageEntity> entities = mageRepository.findAll();
        return toDto(entities);
    }

    public MageResponseDto findById(Long id) {
        MageEntity entity = mageRepository.findById(id).get();
        return toDto(entity);
    }

    public Collection<MageListDto> findAllByLevelGreaterThan(MageLevelThresholdDto dto){
        Collection<MageEntity> entities = mageRepository.findAllByLevelGreaterThan(dto.getLevelThreshold());
        return toDto(entities);
    }

    public Collection<MageListDto> findAllByLevelGreaterThanAndTowerId(MageLevelThresholdAndTowerDto dto){
        Collection<MageEntity> entities =
                mageRepository.findAllByLevelGreaterThanAndTowerId(dto.getLevelThreshold(), dto.getTowerId());
        return toDto(entities);
    }

    public MageResponseDto addOne(MageCreateDto dto) {
        MageEntity entity = toEntity(dto);
        entity.setTower(getTowerById(dto.getTowerId()));
        MageEntity savedEntity = mageRepository.save(entity);
        return toDto(savedEntity);
    }

    public MageResponseDto updateOne(MageUpdateDto dto) {
        MageEntity entity = mageRepository.findById(dto.getId()).get();
        entity.setName(dto.getName());
        entity.setLevel(dto.getLevel());
        entity.setTower(getTowerById(dto.getId()));
        return toDto(entity);
    }

    public void deleteById(Long id) {
        mageRepository.deleteById(id);
    }

    private TowerEntity getTowerById(Long id){
        return towerRepository.findById(id).get();
    }

}
