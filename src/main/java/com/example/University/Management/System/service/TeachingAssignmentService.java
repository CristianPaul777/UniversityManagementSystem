package com.example.University.Management.System.service;

import com.example.University.Management.System.model.TeachingAssignment;
import com.example.University.Management.System.repository.TeachingAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachingAssignmentService {

    private final TeachingAssignmentRepository repo;

    public TeachingAssignmentService(TeachingAssignmentRepository repo) {
        this.repo = repo;
    }

    public List<TeachingAssignment> getAllTeachingAssignments() {
        return repo.findAll();
    }

    public TeachingAssignment addTeachingAssignment(TeachingAssignment teachingAssignment) {
        return repo.save(teachingAssignment);
    }

    public void deleteTeachingAssignment(String id) {
        repo.deleteById(id);
    }
}
