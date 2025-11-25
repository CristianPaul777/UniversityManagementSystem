package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Assistant;
import com.example.University.Management.System.repository.AssistantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistantService {

    private final AssistantRepository repo;

    public AssistantService(AssistantRepository repo) {
        this.repo = repo;
    }

    public List<Assistant> getAllAssistants() {
        return repo.findAll();
    }

    public Assistant getAssistantById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Assistant addAssistant(Assistant assistant) {
        return repo.save(assistant);
    }

    public Assistant updateAssistant(String id, Assistant updatedAssistant) {
        if (repo.existsById(id)) {
            updatedAssistant.setId(id);
            return repo.save(updatedAssistant);
        }
        return null;
    }

    public void deleteAssistant(String id) {
        repo.deleteById(id);
    }
}
