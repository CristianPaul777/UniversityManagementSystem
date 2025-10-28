package com.example.University.Management.System.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDrepository<T> {

    T save(T entity);

    List<T> findAll();

    Optional<T> findById(String id);

    boolean deleteById(String id);
}
