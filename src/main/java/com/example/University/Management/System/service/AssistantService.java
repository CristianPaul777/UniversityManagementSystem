package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Assistant;
import com.example.University.Management.System.model.AssistantRole;
import com.example.University.Management.System.repository.AssistantRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistantService {

    private final AssistantRepository repo;

    public AssistantService(AssistantRepository repo) {
        this.repo = repo;
    }

    public List<Assistant> getFilteredAndSorted(String name,
                                                AssistantRole role,
                                                String sortField,
                                                String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortField).descending()
                : Sort.by(sortField).ascending();

        if (name != null && !name.isEmpty() && role != null) {
            return repo.findByNameContainingIgnoreCaseAndRole(name, role, sort);
        }
        else if (name != null && !name.isEmpty()) {
            return repo.findByNameContainingIgnoreCase(name, sort);
        }
        else if (role != null) {
            return repo.findByRole(role, sort);
        }
        else {
            return repo.findAll(sort);
        }
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
