package com.example.lab4.mage;

import com.example.lab4.mage.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/mage")
public class MageController {

    @Autowired
    private MageService mageService;

    @GetMapping
    public Collection<MageListDto> findAll(){
        return mageService.findAll();
    }

    @GetMapping(path = "/{id}")
    public MageResponseDto findById(@PathVariable Long id){
        return mageService.findById(id);
    }

    @GetMapping(path = "/level")
    public Collection<MageListDto> findAllByLevelGreaterThan(@RequestBody MageLevelThresholdDto dto){
        return mageService.findAllByLevelGreaterThan(dto);
    }

    @GetMapping(path = "/tower")
    public Collection<MageListDto> findAllByLevelGreaterThanAndTowerId(@RequestBody MageLevelThresholdAndTowerDto dto){
        return mageService.findAllByLevelGreaterThanAndTowerId(dto);
    }

    @PostMapping
    public MageResponseDto addOne(@RequestBody MageCreateDto dto){
        return mageService.addOne(dto);
    }

    @PutMapping
    public MageResponseDto updateOne(@RequestBody MageUpdateDto entity){
        return mageService.updateOne(entity);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id){
        mageService.deleteById(id);
    }

}
