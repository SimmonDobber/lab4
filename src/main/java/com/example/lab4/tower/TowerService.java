package com.example.lab4.tower;

import com.example.lab4.tower.dto.TowerCreateDto;
import com.example.lab4.tower.dto.TowerResponseDto;
import com.example.lab4.tower.dto.TowerUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static com.example.lab4.tower.TowerMapper.toDto;
import static com.example.lab4.tower.TowerMapper.toEntity;

@Service
@Transactional
public class TowerService {

    @Autowired
    private TowerRepository towerRepository;

    public Collection<TowerResponseDto> findAll(){
        Collection <TowerEntity> entities = towerRepository.findAll();
        return toDto(entities);
    }

    public TowerResponseDto findById(Long id){
        TowerEntity entity = towerRepository.findById(id).get();
        return toDto(entity);
    }

    public TowerResponseDto addOne(TowerCreateDto dto){
        TowerEntity entity = toEntity(dto);
        TowerEntity savedEntity = towerRepository.save(entity);
        return toDto(savedEntity);
    }

    public TowerResponseDto updateOne(TowerUpdateDto dto) {
        TowerEntity entity = towerRepository.findById(dto.getId()).get();
        entity.setName(dto.getName());
        entity.setHeight(dto.getHeight());
        return toDto(entity);
    }

    public void deleteById(Long id){
        towerRepository.deleteById(id);
    }
}
