package com.example.University.Management.System.repository;

import com.example.University.Management.System.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByNameContainingIgnoreCase(String name);

    List<Student> findByEmailContainingIgnoreCase(String email);

    List<Student> findByNameContainingIgnoreCaseAndEmailContainingIgnoreCase(
            String name, String email
    );
}
