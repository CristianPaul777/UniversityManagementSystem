package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.BaseEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InFileRepository<T extends BaseEntity> implements CRUDrepository<T> {

    private final String filePath;
    private final Class<T> type;
    private final Gson gson;
    private List<T> data;

    public InFileRepository(String fileName, Class<T> type) {
        this.filePath = "src/main/resources/data/" + fileName;
        this.type = type;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        loadFromFile();
    }

    private void loadFromFile() {
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = TypeToken.getParameterized(List.class, type).getType();
            data = gson.fromJson(reader, listType);
            if (data == null) data = new ArrayList<>();
        } catch (Exception e) {
            data = new ArrayList<>();
        }
    }

    private void saveToFile() {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(data, writer);
        } catch (Exception e) {
            throw new RuntimeException("Could not save to JSON file: " + filePath, e);
        }
    }

    @Override
    public T save(T entity) {
        data.add(entity);
        saveToFile();
        return entity;
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(data);
    }

    @Override
    public T findById(String id) {
        return data.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public T update(T entity) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(entity.getId())) {
                data.set(i, entity);
                saveToFile();
                return entity;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        boolean removed = data.removeIf(e -> e.getId().equals(id));
        if (removed) saveToFile();
        return removed;
    }
}
