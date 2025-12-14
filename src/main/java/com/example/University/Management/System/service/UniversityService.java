package com.example.University.Management.System.service;

import com.example.University.Management.System.model.University;
import com.example.University.Management.System.repository.UniversityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    private final UniversityRepository repo;

    public UniversityService(UniversityRepository repo) {
        this.repo = repo;
    }

    public List<University> getFilteredAndSortedUniversities(
            String name,
            String sortField,
            String sortDir) {

        Sort sort = sortDir.equals("desc")
                ? Sort.by(sortField).descending()
                : Sort.by(sortField).ascending();

        if (!name.isEmpty()) {
            // exact ca la Teacher
            return repo.findByNameContainingIgnoreCase(name)
                    .stream().sorted((a, b) -> 0).toList();
        }

        return repo.findAll(sort);
    }

    // CRUD
    public List<University> getAllUniversities() {
        return repo.findAll();
    }

    public University getUniversityById(String id) {
        return repo.findById(id).orElse(null);
    }

    public University addUniversity(University university) {
        return repo.save(university);
    }

    public University updateUniversity(String id, University updatedUniversity) {
        if (repo.existsById(id)) {
            updatedUniversity.setId(id);
            return repo.save(updatedUniversity);
        }
        return null;
    }

    public void deleteUniversity(String id) {
        repo.deleteById(id);
    }
}