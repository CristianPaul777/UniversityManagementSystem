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

    public TeachingAssignment getTeachingAssignmentById(String id) {
        return repo.findById(id);
    }

    public TeachingAssignment addTeachingAssignment(TeachingAssignment assignment) {
        return repo.save(assignment);
    }

    public TeachingAssignment updateTeachingAssignment(String id, TeachingAssignment updatedAssignment) {
        TeachingAssignment existing = repo.findById(id);
        if (existing != null) {
            updatedAssignment.setId(id);
            repo.deleteById(id);
            return repo.save(updatedAssignment);
        }
        return null;
    }

    public void deleteTeachingAssignment(String id) {
        repo.deleteById(id);
    }
}
