package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.TeachingAssignment;
import org.springframework.stereotype.Repository;

@Repository
public class TeachingAssignmentRepository extends InFileRepository<TeachingAssignment> {

    public TeachingAssignmentRepository() {
        super("teaching_assignments.json", TeachingAssignment.class);
    }
}
