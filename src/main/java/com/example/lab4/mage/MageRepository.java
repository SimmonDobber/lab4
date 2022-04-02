package com.example.lab4.mage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface MageRepository extends CrudRepository<MageEntity, Long> {

    Collection<MageEntity> findAll();
    Collection<MageEntity> findAllByLevelGreaterThan(Integer levelThreshold);

    @Query(value = "select * from mages where mages.level > :levelThreshold and mages.tower_id = :towerId", nativeQuery = true)
    Collection<MageEntity> findAllByLevelGreaterThanAndTowerId(
            @Param("levelThreshold") Integer level, @Param("towerId") Long towerId);
}
