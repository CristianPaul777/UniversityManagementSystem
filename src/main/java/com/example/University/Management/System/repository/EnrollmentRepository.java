package com.example.University.Management.System.repository;


import com.example.University.Management.System.model.Enrollment;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

    private List<Enrollment> enrollments = new ArrayList<>();

    public Enrollment save(Enrollment enrollment) {
        enrollments.add(enrollment);
        return enrollment;
    }
    public List<Enrollment> findAll() {
        return new ArrayList<>(enrollments);
    }

    public Enrollment findById(String id) {
        for (Enrollment e : enrollments) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public boolean deleteById(String id) {
        return enrollments.removeIf(e -> e.getId().equals(id));
    }

}
