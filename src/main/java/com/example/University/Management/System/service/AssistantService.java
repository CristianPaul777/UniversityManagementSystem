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

    public List<Assistant> getAllAssistants() {
        return repo.findAll();
    }

    public List<Assistant> getFilteredAndSortedAssistants(String name,
                                                          String role,
                                                          String sortField,
                                                          String sortDir) {

        Sort sort = sortDir.equals("desc")
                ? Sort.by(sortField).descending()
                : Sort.by(sortField).ascending();


        AssistantRole roleEnum = null;
        if (role != null && !role.isBlank()) {
            roleEnum = AssistantRole.valueOf(role);
        }

        boolean hasName = name != null && !name.isBlank();
        boolean hasRole = roleEnum != null;

        if (hasName && hasRole) {
            return repo.findByNameContainingIgnoreCaseAndRole(name, roleEnum)
                    .stream().sorted((a, b) -> 0).toList();
        }

        if (hasName) {
            return repo.findByNameContainingIgnoreCase(name)
                    .stream().sorted((a, b) -> 0).toList();
        }

        if (hasRole) {
            return repo.findByRole(roleEnum)
                    .stream().sorted((a, b) -> 0).toList();
        }

        return repo.findAll(sort);
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