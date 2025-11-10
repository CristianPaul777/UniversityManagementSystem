package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Enrollment;
import com.example.University.Management.System.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository repo;

    public EnrollmentService(EnrollmentRepository repo) {
        this.repo = repo;
    }

    public List<Enrollment> getAllEnrollments() {
        return repo.findAll();
    }

    public Enrollment getEnrollmentById(String id) {
        return repo.findById(id);
    }

    public Enrollment addEnrollment(Enrollment enrollment) {
        return repo.save(enrollment);
    }


    public Enrollment updateEnrollment(String id, Enrollment updatedEnrollment) {
        Enrollment existing = repo.findById(id);
        if (existing != null) {
            updatedEnrollment.setId(id);
            repo.deleteById(id);
            return repo.save(updatedEnrollment);
        }
        return null;
    }

    public void deleteEnrollment(String id) {
        repo.deleteById(id);
    }
}
