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

    public List<Enrollment> getFilteredAndSortedEnrollments(
            String studentId,
            String courseId,
            String sortField,
            String sortDir
    ) {

        Sort sort = sortDir.equals("desc")
                ? Sort.by(sortField).descending()
                : Sort.by(sortField).ascending();

        if (!studentId.isEmpty() && !courseId.isEmpty()) {
            return repo
                    .findByStudent_IdContainingIgnoreCaseAndCourse_IdContainingIgnoreCase(studentId, courseId)
                    .stream().toList();
        }

        if (!studentId.isEmpty()) {
            return repo
                    .findByStudent_IdContainingIgnoreCase(studentId)
                    .stream().toList();
        }

        if (!courseId.isEmpty()) {
            return repo
                    .findByCourse_IdContainingIgnoreCase(courseId)
                    .stream().toList();
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
        if (repo.existsById(id)) {
            updatedEnrollment.setId(id);
            return repo.save(updatedEnrollment);
        }
        return null;
    }

    public void deleteEnrollment(String id) {
        repo.deleteById(id);
    }
}