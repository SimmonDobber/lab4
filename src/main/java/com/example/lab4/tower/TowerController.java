package com.example.lab4.tower;

import com.example.lab4.tower.dto.TowerCreateDto;
import com.example.lab4.tower.dto.TowerResponseDto;
import com.example.lab4.tower.dto.TowerUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/tower")
@AllArgsConstructor
public class TowerController {

    private final TowerService towerService;

    @GetMapping
    public Collection<TowerResponseDto> findAll() {
        return towerService.findAll();
    }

    @GetMapping(path = "/{id}")
    public TowerResponseDto findById(@PathVariable Long id) {
        return towerService.findById(id);
    }

    @PostMapping
    public TowerResponseDto addOne(@RequestBody TowerCreateDto entity) {
        return towerService.addOne(entity);
    }

    @PutMapping
    public TowerResponseDto updateOne(@RequestBody TowerUpdateDto entity){
        return towerService.updateOne(entity);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id){
         towerService.deleteById(id);
    }

}
