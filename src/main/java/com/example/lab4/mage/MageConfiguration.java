package com.example.lab4.mage;

import com.example.lab4.tower.TowerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MageConfiguration {

    @Bean
    MageService mageService (
            MageRepository mageRepository,
            TowerRepository towerRepository
    ){
        return new MageService(
                mageRepository,
                towerRepository
        );
    }

}
