package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {


    List<Department> findByNameContainingIgnoreCase(String name);

    List<Department> findByFacultyContainingIgnoreCase(String faculty);

    List<Department> findByNameContainingIgnoreCaseAndFacultyContainingIgnoreCase(
            String name, String faculty
    );
}
