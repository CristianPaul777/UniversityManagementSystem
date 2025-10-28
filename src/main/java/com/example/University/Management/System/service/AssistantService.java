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

    public Assistant addAssistant(Assistant assistant) {
        return repo.save(assistant);
    }

    public void deleteAssistant(String id) {
        repo.deleteById(id);
    }
}
