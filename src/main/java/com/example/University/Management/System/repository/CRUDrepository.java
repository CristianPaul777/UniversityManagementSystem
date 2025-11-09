package com.example.University.Management.System.repository;

import java.util.List;

public interface CRUDrepository<T> {
    T save(T entity);
    List<T> findAll();
    T findById(String id);
    T update(T entity);
    boolean deleteById(String id);
}
