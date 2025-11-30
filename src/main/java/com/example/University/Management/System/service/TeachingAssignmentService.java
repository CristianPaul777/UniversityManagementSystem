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
        return repo.findById(id).orElse(null);
    }

    public TeachingAssignment addTeachingAssignment(TeachingAssignment assignment) {
        return repo.save(assignment);
    }

    public TeachingAssignment updateTeachingAssignment(String id, TeachingAssignment updatedAssignment) {
        if (repo.existsById(id)) {
            updatedAssignment.setId(id);
            return repo.save(updatedAssignment);
        }
        return null;
    }

    public void deleteTeachingAssignment(String id) {
        repo.deleteById(id);
    }
}
