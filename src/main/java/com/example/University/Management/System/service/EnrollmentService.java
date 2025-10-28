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

    public Enrollment addEnrollment(Enrollment enrollment) {
        return repo.save(enrollment);
    }

    public void deleteEnrollment(String id) {
        repo.deleteById(id);
    }
}
