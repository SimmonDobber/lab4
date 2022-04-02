package com.example.lab4.tower;


import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TowerRepository extends CrudRepository<TowerEntity, Long> {
    Collection<TowerEntity> findAll();
}
