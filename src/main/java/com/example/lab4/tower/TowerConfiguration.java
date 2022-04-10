package com.example.lab4.tower;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TowerConfiguration {

    @Bean
    TowerService towerService(
        TowerRepository towerRepository
    ){
        return new TowerService(
                towerRepository
        );

    }
}
