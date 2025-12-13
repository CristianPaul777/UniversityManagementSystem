package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, String> {


    List<University> findByNameContainingIgnoreCase(String name);
}
