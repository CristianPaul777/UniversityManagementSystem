package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {

    List<Teacher> findByNameContainingIgnoreCase(String name);

    List<Teacher> findByDepartment_NameContainingIgnoreCase(String department);

    List<Teacher> findByNameContainingIgnoreCaseAndDepartment_NameContainingIgnoreCase(
            String name, String department
    );
}
