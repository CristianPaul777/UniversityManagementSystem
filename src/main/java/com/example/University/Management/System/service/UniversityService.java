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

    public List<University> getAllUniversities() {
        return repo.findAll();
    }

    public List<University> getSortedUniversities(String field, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(field).ascending()
                : Sort.by(field).descending();

        return repo.findAll(sort);
    }


    public List<University> getFilteredAndSorted(String name, String field, String direction) {

        List<University> result;

        if (name != null && !name.isEmpty()) {
            result = repo.findByNameContainingIgnoreCase(name);
        } else {
            result = repo.findAll();
        }

        if (field != null && !field.isEmpty()) {
            Sort sort = direction.equalsIgnoreCase("asc")
                    ? Sort.by(field).ascending()
                    : Sort.by(field).descending();

            result = repo.findAll(sort);
        }

        return result;
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
