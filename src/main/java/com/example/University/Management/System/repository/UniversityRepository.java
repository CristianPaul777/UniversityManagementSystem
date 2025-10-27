package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.University;
import java.util.ArrayList;
import java.util.List;

public class UniversityRepository {

    private List<University> universities = new ArrayList<>();

    public University save(University university) {
        universities.add(university);
        return university;
    }

    public List<University> findAll() {
        return new ArrayList<>(universities);
    }

    public University findById(String id) {
        for (University u : universities) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public boolean deleteById(String id) {
        return universities.removeIf(u -> u.getId().equals(id));
    }
}
