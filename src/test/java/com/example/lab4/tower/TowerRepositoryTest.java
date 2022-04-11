package com.example.lab4.tower;

import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public class TowerRepositoryTest implements TowerRepository {

    private final Map<Long, TowerEntity> towers = new HashMap<>();
    private Long idNextValue = 1L;

    @Override
    public TowerEntity save(TowerEntity entity) {
        if (entity.getId() != null) {
            towers.put(entity.getId(), entity);
        }
        else {
            entity.setId(idNextValue++);
            towers.put(entity.getId(), entity);
        }
        return entity;
    }

    @Override
    public <S extends TowerEntity> Iterable<S> saveAll(Iterable<S> entities) {
        throw new RuntimeException();
    }

    @Override
    public Optional<TowerEntity> findById(Long aLong) {
        return Optional.ofNullable(towers.get(aLong));
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new RuntimeException();
    }

    @Override
    public Collection<TowerEntity> findAll() {
        return towers.values();
    }

    @Override
    public Iterable<TowerEntity> findAllById(Iterable<Long> longs) {
        throw new RuntimeException();
    }

    @Override
    public long count() {
        throw new RuntimeException();
    }

    @Override
    public void deleteById(Long aLong) {
        if(!towers.containsKey(aLong)) {
            throw new RuntimeException();
        }
        towers.remove(aLong);
    }

    @Override
    public void delete(TowerEntity entity) {
        throw new RuntimeException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        throw new RuntimeException();
    }

    @Override
    public void deleteAll(Iterable<? extends TowerEntity> entities) {
        throw new RuntimeException();
    }

    @Override
    public void deleteAll() {
        throw new RuntimeException();
    }
}
