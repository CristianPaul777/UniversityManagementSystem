package com.example.University.Management.System.service;

import com.example.University.Management.System.model.Enrollment;
import com.example.University.Management.System.repository.EnrollmentRepository;
import org.springframework.data.domain.Sort;
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

    public List<Enrollment> getSortedEnrollments(String field, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(field).ascending()
                : Sort.by(field).descending();

        return repo.findAll(sort);
    }

    public List<Enrollment> filterAndSort(String studentId,
                                          String courseId,
                                          String field,
                                          String direction) {

        Sort sort = Sort.by(field).ascending();
        if (direction.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }

        if (studentId != null && !studentId.isEmpty()) {
            return repo.findByStudentId(studentId, sort);
        }

        if (courseId != null && !courseId.isEmpty()) {
            return repo.findByCourseId(courseId, sort);
        }

        return repo.findAll(sort);
    }


    public Enrollment getEnrollmentById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Enrollment addEnrollment(Enrollment enrollment) {
        return repo.save(enrollment);
    }

    public Enrollment updateEnrollment(String id, Enrollment updatedEnrollment) {
        Enrollment existing = repo.findById(id).orElse(null);

        if (existing != null) {
            updatedEnrollment.setId(id);
            return repo.save(updatedEnrollment);
        }

        return null;
    }

    public void deleteEnrollment(String id) {
        repo.deleteById(id);
    }
}
