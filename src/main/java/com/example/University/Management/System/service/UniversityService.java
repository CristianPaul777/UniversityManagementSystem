package com.example.University.Management.System.service;

import com.example.University.Management.System.model.University;
import com.example.University.Management.System.repository.UniversityRepository;
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

    public University addUniversity(University university) {
        return repo.save(university);
    }

    public void deleteUniversity(String id) {
        repo.deleteById(id);
    }
}
