package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.BaseEntity;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class InMemoryRepository<T extends BaseEntity> implements CRUDrepository<T> {

    protected final List<T> store = new CopyOnWriteArrayList<>();

    @Override
    public T save(T entity) {
        store.removeIf(e -> e.getId().equals(entity.getId()));
        store.add(entity);
        return entity;
    }

    @Override
    public List<T> findAll() {
        return store;
    }

    @Override
    public Optional<T> findById(String id) {
        return store.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean deleteById(String id) {
        return store.removeIf(entity -> entity.getId().equals(id));
    }
}
