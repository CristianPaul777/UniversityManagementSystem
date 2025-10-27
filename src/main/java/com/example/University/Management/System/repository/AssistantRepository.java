package com.example.University.Management.System.repository;


import com.example.University.Management.System.model.Assistant;
import java.util.ArrayList;
import java.util.List;

public class AssistantRepository {

    private List<Assistant> assistants = new ArrayList<>();

    public Assistant save(Assistant assistant) {
        assistants.add(assistant);
        return assistant;
    }

    public List<Assistant> findAll() {
        return new ArrayList<>(assistants);
    }

    public Assistant findById(String id) {
        for (Assistant a : assistants) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public boolean deleteById(String id) {
        return assistants.removeIf(a -> a.getId().equals(id));
    }
}
