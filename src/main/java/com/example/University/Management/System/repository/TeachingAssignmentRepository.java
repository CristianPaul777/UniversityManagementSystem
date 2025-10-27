package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.TeachingAssignment;
import java.util.ArrayList;
import java.util.List;

public class TeachingAssignmentRepository {

    private List<TeachingAssignment> assignments = new ArrayList<>();

    public TeachingAssignment save(TeachingAssignment assignment) {
        assignments.add(assignment);
        return assignment;
    }

    public List<TeachingAssignment> findAll() {
        return new ArrayList<>(assignments);
    }

    public TeachingAssignment findById(String id) {
        for (TeachingAssignment ta : assignments) {
            if (ta.getId().equals(id)) {
                return ta;
            }
        }
        return null;
    }

    public boolean deleteById(String id) {
        return assignments.removeIf(ta -> ta.getId().equals(id));
    }

}
